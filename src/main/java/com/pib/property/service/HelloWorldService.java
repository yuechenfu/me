package com.pib.property.service;

import java.util.List;

import com.pib.property.entity.HelloWorld;

public interface HelloWorldService {

	List<HelloWorld>  find( );
	
	HelloWorld findById(HelloWorld e);
}
