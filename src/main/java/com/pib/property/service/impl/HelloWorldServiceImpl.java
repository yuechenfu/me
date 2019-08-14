package com.pib.property.service.impl;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pib.property.dao.HelloWorldDao;
import com.pib.property.entity.HelloWorld;
import com.pib.property.service.HelloWorldService;
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
