package com.pib.property.service;

import com.pib.property.entity.JobDetail;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;
import com.pib.property.model.SearchCondition;

public interface JobDetailService {

    boolean save(JobDetail e) throws FailException;

    boolean delete(JobDetail e);


    boolean update(JobDetail e);


    JobDetail findById(JobDetail e);


    JobDetail findByLogin(JobDetail e);
    

}
