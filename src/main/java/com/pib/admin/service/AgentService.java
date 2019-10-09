package com.pib.admin.service;

 

import java.util.List;

import com.pib.admin.entity.Agent;
import com.pib.admin.exception.FailException; 

public interface AgentService {

    boolean save(Agent e) throws FailException;

    boolean delete(Agent e);

    boolean update(Agent e);
    
    int count();
    
    List<Agent> find(int begRow,int rows);
 
    Agent findById(Agent e);

    Agent findByUsername(Agent e);
    
    Agent findByEmail(Agent e);


}
