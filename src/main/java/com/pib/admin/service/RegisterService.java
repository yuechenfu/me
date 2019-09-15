package com.pib.admin.service;

import com.pib.admin.entity.Account;
import com.pib.admin.entity.Person;
import com.pib.admin.exception.FailException;
import com.pib.admin.exception.ServiceException;

public interface RegisterService {
    boolean registerAccount(Account account) throws FailException, ServiceException;
    boolean registerBaseInfo(Account account) throws FailException, ServiceException;
}
