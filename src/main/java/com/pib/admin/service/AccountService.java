package com.pib.admin.service;



import java.util.List;

import com.pib.admin.entity.Account; 
import com.pib.admin.exception.FailException;
import com.pib.admin.exception.ServiceException;
import com.pib.admin.model.SearchCondition;

public interface AccountService {

    boolean save(Account e) throws FailException;

    boolean delete(Account e);


    boolean update(Account e);

    void updatePassword(Account e);


    Account findById(Account e);


    Account findByLogin(Account e);
    

    int countByUsername(Account e);
    
    int countByEmail(Account e);

    Account findByUsername(Account e);
    
    Account findByEmail(Account e);


}
