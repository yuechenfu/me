package com.pib.admin.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pib.admin.entity.Account;
import com.pib.admin.entity.Person;
import com.pib.admin.entity.SecurityCodeType;
import com.pib.admin.exception.FailException;
import com.pib.admin.exception.ServiceException;
import com.pib.admin.service.AccountService;
import com.pib.admin.service.PersonService;
import com.pib.admin.service.RegisterService;
import com.pib.admin.service.SecurityCodeService;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private AccountService accountService;
    @Autowired
    private PersonService personService;
    @Autowired
    private SecurityCodeService securityCodeService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public boolean registerAccount(Account account) throws FailException, ServiceException {
    	return accountService.save(account);
    }

	@Override
	public boolean registerBaseInfo(Account account) throws FailException, ServiceException {
		Person e = new Person.Builder().set("accountId", account.getId()).set("email", account.getUsername()).set("type", account.getType()).build();
		e.fillNotRequire();
		return personService.save(e) >0 ;
	}
    

}
