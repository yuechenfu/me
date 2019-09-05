package com.pib.property.service.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pib.property.dao.AccountDao;
import com.pib.property.entity.Account;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;
import com.pib.property.model.SearchCondition;
import com.pib.property.service.AccountService;

import java.util.List;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao dao;

    @Override
    public boolean save(Account e) throws FailException {
        e.fillNotRequire();
        e.createAt();
        e.updateAt();
        e.md5Password();
        return dao.save(e) == 1;
    }

    @Override
    public boolean delete(Account e) {
        return dao.delete(e) == 1;
    }



    @Override
    public boolean update(Account e) {
        e.updateAt();
        e.md5Password();
        return dao.update(e) == 1;
    }

    private final static String email = "email";
    private final static String phone = "phone";

    private Account getAccount(List<Account> accountList, String type) {
        return accountList.stream()
                .filter(e -> type.equals(email) ? e.getUsername().indexOf("@") != -1 : e.getUsername().indexOf("@") == -1)
                .findFirst().orElse(Account.NULL);
    }

    @Override
    public Account findById(Account e) {
        Account result = dao.findById(e);
        return result != null ? result : Account.NULL;
    }

  
    @Override
    public Account findByLogin(Account e) {
        e.md5Password(); 
        Account result = dao.findByEmailAndPassword(e); 
        return result != null ? result : Account.NULL;
    }

    @Override
    public int countByUsername(Account e) {
        return dao.countByUsername(e);
    }
    
    @Override
    public int countByEmail(Account e) {
        return dao.countByEmail(e);
    }

    @Override
    public Account findByUsername(Account e) {
        Account result = dao.findByUsername(e);
        return result != null ? result : Account.NULL;
    }
    
    @Override
    public Account findByEmail(Account e) {
        Account result = dao.findByEmail(e);
        return result != null ? result : Account.NULL;
    }

	@Override
	public void updatePassword(Account e) {
		// TODO Auto-generated method stub
		
	}
 


}
