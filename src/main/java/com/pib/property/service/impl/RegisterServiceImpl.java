package com.pib.property.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pib.property.entity.Account;
import com.pib.property.entity.Person;
import com.pib.property.entity.SecurityCodeType;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;
import com.pib.property.service.AccountService;
import com.pib.property.service.PersonService;
import com.pib.property.service.RegisterService;
import com.pib.property.service.SecurityCodeService;

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
