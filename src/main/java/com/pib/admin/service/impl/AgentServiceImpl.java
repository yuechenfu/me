package com.pib.admin.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pib.admin.dao.AgentDao;
import com.pib.admin.entity.Agent;
import com.pib.admin.exception.FailException;
import com.pib.admin.service.AgentService;


@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentDao dao;

    @Override
    public boolean save(Agent e) throws FailException {
        e.fillNotRequire();
        e.createAt();
        e.updateAt();
        e.md5Password();
        return dao.save(e) == 1;
    }

    @Override
    public boolean delete(Agent e) {
        return dao.delete(e) == 1;
    }



    @Override
    public boolean update(Agent e) {
        e.updateAt();
        e.md5Password();
        return dao.update(e) == 1;
    }

    public int count() {
    	return dao.count();
    }
    
    @Override
    public List<Agent> find(int begRow,int rows) {
    	List<Agent> result = dao.find(begRow,rows);
        return result ;
    }

    @Override
    public Agent findById(Agent e) {
    	Agent result = dao.findById(e);
        return result != null ? result : Agent.NULL;
    }

 

    @Override
    public Agent findByUsername(Agent e) {
    	Agent result = dao.findByUsername(e);
        return result != null ? result : Agent.NULL;
    }
    
    @Override
    public Agent findByEmail(Agent e) {
    	Agent result = dao.findByEmail(e);
        return result != null ? result : Agent.NULL;
    }
 
 


}
