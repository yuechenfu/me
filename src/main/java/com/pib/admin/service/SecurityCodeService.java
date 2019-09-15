package com.pib.admin.service;



import java.util.List;

import com.pib.admin.entity.Person;
import com.pib.admin.entity.SecurityCode;
import com.pib.admin.entity.SecurityCodeType;
import com.pib.admin.exception.FailException;
import com.pib.admin.exception.ServiceException;
import com.pib.admin.model.SearchCondition;

public interface SecurityCodeService {
    int save(SecurityCode e);

    SecurityCode saveCodeByPerson(Person person, SecurityCodeType type);

    String getName(Person person);

    boolean delete(SecurityCode e);

    boolean update(SecurityCode e);

    SecurityCode findById(SecurityCode e);

    int count(SearchCondition searchCondition);

    List<SecurityCode> find(SearchCondition searchCondition);

    /**
     * 发送安全码到某邮箱或手机短信
     * @param e
     * @throws FailException
     */
    void sendCode(SecurityCode e) throws FailException;

    /**
     * 检查一个更新用户操作的安全码
     * 如果验证通过，更新这个安全码状态为已经使用
     * 该方法嵌入在其他用户相关的更新事务中
     * @param code
     * @param name
     * @param type
     * @return 验证码验证结果
     */
    void verifyCodeAndUsed(String code, String name, SecurityCodeType type) throws FailException, ServiceException;
}
