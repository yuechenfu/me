package com.pib.admin.service;


import java.util.List;

import com.pib.admin.entity.Account;
import com.pib.admin.entity.Person;
import com.pib.admin.exception.FailException;
import com.pib.admin.exception.ServiceException;
import com.pib.admin.model.SearchCondition;

public interface PersonService {
	int save(Person e);

    void savePersonAndAccount(Person e, Account account) throws FailException;

    boolean delete(Person e) throws FailException;

    void deletePersonAndAccount(Person e) throws FailException;

    void updatePersonAndAccount(Person e, Account account) throws FailException;

    boolean update(Person e);

    Person findById(Person e);
    
    Person findByAccountId(Person e);

    int count(SearchCondition searchCondition);

    List<Person> find(SearchCondition searchCondition);

    boolean checkEmailExist(String email) throws FailException;

    boolean checkPhoneExist(String phone) throws FailException;

    void checkPersonExist(Person person) throws FailException, ServiceException;

    void updatePhoneByCode(String code, Person person) throws FailException, ServiceException;

    void updateEmailByCode(String code, Person person) throws FailException, ServiceException;

    void deletePhoneAccount(Person person) throws FailException, ServiceException;

    void deleteEmailAccount(Person person) throws FailException, ServiceException;
}
