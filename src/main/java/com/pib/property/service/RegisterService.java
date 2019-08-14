package com.pib.property.service;

import com.pib.property.entity.Account;
import com.pib.property.entity.Person;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;

public interface RegisterService {
    boolean registerAccount(Account account) throws FailException, ServiceException;
    boolean registerBaseInfo(Account account) throws FailException, ServiceException;
}
