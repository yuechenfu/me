package com.pib.admin.service.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pib.admin.dao.HelloWorldDao;
import com.pib.admin.entity.HelloWorld;
import com.pib.admin.service.HelloWorldService;
@Service
public class HelloWorldServiceImpl implements HelloWorldService {
	
	@Autowired
    private HelloWorldDao dao;
	
	@Override
    public List<HelloWorld> find() {
		List<HelloWorld>   result = dao.find();
        return result != null ? result : null;
    }

	@Override
	public HelloWorld findById(HelloWorld e) {
		
		return dao.findById(e);
	}
}
