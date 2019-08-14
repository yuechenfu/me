package com.pib.property.service.impl;


import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pib.property.dao.SecurityCodeDao;
import com.pib.property.entity.Person;
import com.pib.property.entity.SecurityCode;
import com.pib.property.entity.SecurityCodeStatus;
import com.pib.property.entity.SecurityCodeType;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;
import com.pib.property.log.LogUtil;
import com.pib.property.model.ProjectRestCode;
import com.pib.property.model.SearchCondition;
import com.pib.property.service.SecurityCodeService;
import com.pib.util.ShortMessageUtil;
import com.pib.util.StringUtil;
import com.pib.util.ThreadUtil;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SecurityCodeServiceImpl implements SecurityCodeService {
    @Autowired
    private SecurityCodeDao dao;
    @Autowired
    private ShortMessageUtil shortMessageUtil;


    @Override
    public int save(SecurityCode e) {
        e.fillNotRequire();
        e.updateAt();
        e.createAt();
        return dao.save(e);
    }

    @Override
    public SecurityCode saveCodeByPerson(Person person , SecurityCodeType type) {
        String name  = getName(person);
        String code = StringUtil.generateRandomInteger(4);
        SecurityCode securityCode = new SecurityCode.Builder().set("name", name).set("code", code).set("type", type).build();
        save(securityCode);
        return securityCode;
    }

    @Override
    public String getName(Person person) {
        
    	String email = person.getEmail();
        String phone = person.getPhone();
        String name = StringUtils.isEmpty(email) ? phone : email;
        return name;
    }

    @Override
    public boolean delete(SecurityCode e) {
        return dao.delete(e) == 1;
    }

    @Override
    public boolean update(SecurityCode e) {
        e.updateAt();
        return dao.update(e) == 1;
    }

    @Override
    public SecurityCode findById(SecurityCode e) {
        SecurityCode result = dao.findById(e);
        return result != null ? result : SecurityCode.NULL;
    }

    @Override
    public int count(SearchCondition searchCondition) {
        return dao.count(searchCondition);
    }

    @Override
    public List<SecurityCode> find(SearchCondition searchCondition) {
        searchCondition.setDefaultSortBy("id");
        return dao.find(searchCondition);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void verifyCodeAndUsed(String code, String name, SecurityCodeType type)  throws FailException, ServiceException{
        //验证安全码
        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setName(name);
        searchCondition.setType(type.toString());
        searchCondition.setStatus(String.valueOf(SecurityCodeStatus.UN_USE));
        List<SecurityCode> list = find(searchCondition);
        if (list.isEmpty()) {
            throw new ServiceException(ProjectRestCode.SECURITY_CODE_WRONG.getMessage(),ProjectRestCode.SECURITY_CODE_WRONG);
        }
        SecurityCode securityCode = list.get(0);
        if (!code.equals(securityCode.getCode())) {
            throw new ServiceException(ProjectRestCode.SECURITY_CODE_WRONG.getMessage(),ProjectRestCode.SECURITY_CODE_WRONG);
        }
        if (!securityCode.getCreateAt().isAfter(LocalDateTime.now(ZoneId.of("UTC")).minusMinutes(30))){
            throw new ServiceException(ProjectRestCode.SECURITY_CODE_EXPIRED.getMessage(),ProjectRestCode.SECURITY_CODE_EXPIRED);
        }
        //更新安全码为已经使用
        securityCode.setStatus(SecurityCodeStatus.USED);
        update(securityCode);
    }


    @Override
    public void sendCode(SecurityCode e) throws FailException {
        ThreadUtil.run(() -> {
            String name = e.getName();
            try {
                if (name.indexOf("@") != -1) {
                    String subject = null;
                    String templateId = null;
                    if (e.getType() == SecurityCodeType.REGISTER) {
                        subject = "Complete sign up";
                        templateId ="1";// SendGridEmailTemplate.REGISTER_EMAIL();
                    } else {
                        subject = "Change Your Email";
                        templateId ="1";// SendGridEmailTemplate.VERIFY_EMAIL();
                    }
                    Map<String, Object> data = new HashMap<>();
                    char[] codes = e.getCode().toCharArray();
                    for (int i = 0; i < codes.length; i++) {
                        String key = "code" + (i + 1);
                        data.put(key, new String(new char[]{codes[i]}));
                    }
                    //sendGridEmailUtil.sendByTemplate(name, subject, templateId, data);
                } else {
                    String content = SecurityCodeType.getContent(e);
                    shortMessageUtil.sendByNexmo(name, content);
                }
            } catch (Exception ex) {
                LogUtil.error("send code fail:", ex);
            }
        });
    }


    //for testcase usage
    public void setShortMessageUtil(ShortMessageUtil shortMessageUtil) {
        this.shortMessageUtil = shortMessageUtil;
    }
  
}
