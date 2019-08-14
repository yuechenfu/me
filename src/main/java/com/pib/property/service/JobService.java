package com.pib.property.service;



import java.util.List;

import com.pib.property.entity.Job;
import com.pib.property.entity.Person;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;
import com.pib.property.model.SearchCondition;

public interface JobService {

    boolean save(Job e) throws FailException;

    boolean delete(Job e);


    boolean update(Job e);


    Job findById(Job e);
    
    List<Job> findByTitleAndAddress(Job e);

    List<Job> findByEmployerId(Job e);

    Job findByLogin(Job e);
    

}
