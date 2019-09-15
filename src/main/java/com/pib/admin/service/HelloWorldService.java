package com.pib.admin.service;

import java.util.List;

import com.pib.admin.entity.HelloWorld;

public interface HelloWorldService {

	List<HelloWorld>  find( );
	
	HelloWorld findById(HelloWorld e);
}
