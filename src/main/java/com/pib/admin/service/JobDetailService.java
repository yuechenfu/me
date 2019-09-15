package com.pib.admin.service;

import com.pib.admin.entity.JobDetail;
import com.pib.admin.exception.FailException;
import com.pib.admin.exception.ServiceException;
import com.pib.admin.model.SearchCondition;

public interface JobDetailService {

    boolean save(JobDetail e) throws FailException;

    boolean delete(JobDetail e);


    boolean update(JobDetail e);


    JobDetail findById(JobDetail e);


    JobDetail findByLogin(JobDetail e);
    

}
