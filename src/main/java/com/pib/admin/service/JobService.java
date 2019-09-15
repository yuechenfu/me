package com.pib.admin.service;



import java.util.List;

import com.pib.admin.entity.Job;
import com.pib.admin.entity.Person;
import com.pib.admin.exception.FailException;
import com.pib.admin.exception.ServiceException;
import com.pib.admin.model.SearchCondition;

public interface JobService {

    boolean save(Job e) throws FailException;

    boolean delete(Job e);


    boolean update(Job e);


    Job findById(Job e);
    
    List<Job> findByTitleAndAddress(Job e);

    List<Job> findByEmployerId(Job e);

    Job findByLogin(Job e);
    

}
