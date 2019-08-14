package com.pib.property.service;


import java.util.List;

import com.pib.property.entity.Account;
import com.pib.property.entity.Person;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;
import com.pib.property.model.SearchCondition;

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
