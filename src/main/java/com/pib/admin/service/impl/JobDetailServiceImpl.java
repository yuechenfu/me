package com.pib.admin.service.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pib.admin.dao.JobDetailDao;
import com.pib.admin.entity.JobDetail;
import com.pib.admin.exception.FailException;
import com.pib.admin.exception.ServiceException;
import com.pib.admin.model.SearchCondition;
import com.pib.admin.service.JobDetailService;

import java.util.List;

@Service
public class JobDetailServiceImpl implements JobDetailService {
    @Autowired
    private JobDetailDao dao;

    @Override
    public boolean save(JobDetail e) throws FailException {
        e.fillNotRequire();
        e.createAt();
        e.updateAt();
        return dao.save(e) == 1;
    }

    @Override
    public boolean delete(JobDetail e) {
        return dao.delete(e) == 1;
    }


    @Override
    public boolean update(JobDetail e) {
        e.updateAt();
        return dao.update(e) == 1;
    }
    
    @Override
    public JobDetail findById(JobDetail e) {
        JobDetail result = dao.findById(e);
        return result != null ? result : JobDetail.NULL;
    }

	@Override
	public JobDetail findByLogin(JobDetail e) {
		// TODO Auto-generated method stub
		return null;
	}

}
