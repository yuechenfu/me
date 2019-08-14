package com.pib.property.service;



import java.util.List;

import com.pib.property.entity.Account;
import com.pib.property.entity.Person;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;
import com.pib.property.model.SearchCondition;

public interface AccountService {

    boolean save(Account e) throws FailException;

    boolean delete(Account e);


    boolean update(Account e);

    void updatePassword(Account e);


    Account findById(Account e);


    Account findByLogin(Account e);
    

    int countByUsername(Account e);

    Account findByUsername(Account e);


}
