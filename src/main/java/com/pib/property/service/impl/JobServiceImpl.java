package com.pib.property.service.impl;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pib.property.dao.JobDao;
import com.pib.property.entity.Account;
import com.pib.property.entity.Job;
import com.pib.property.exception.FailException;
import com.pib.property.exception.ServiceException;
import com.pib.property.model.SearchCondition;
import com.pib.property.service.JobService;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobDao dao;

    @Override
    public boolean save(Job e) throws FailException {
        e.fillNotRequire();
        e.createAt();
        e.updateAt();
        return dao.save(e) == 1;
    }

    @Override
    public boolean delete(Job e) {
        return dao.delete(e) == 1;
    }


    @Override
    public boolean update(Job e) {
        e.updateAt();
        return dao.update(e) == 1;
    }
    
    @Override
    public Job findById(Job e) {
        Job result = dao.findById(e);
        return result != null ? result : Job.NULL;
    }
    
    @Override
	public List<Job> findByTitleAndAddress(Job e) {
    	if(e.getTitle() != null) e.setTitle("%"+e.getTitle()+"%");
    	if(e.getLocation() != null) e.setLocation("%"+e.getLocation()+"%");
		return dao.findByTitleAndAddress(e);
	}

    @Override
    public List<Job> findByEmployerId(Job e) {
        return dao.findByEmployerId( e);
    }

	@Override
	public Job findByLogin(Job e) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
