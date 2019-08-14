package com.pib.property.dao;
 
import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.pib.property.entity.HelloWorld;
 

@Repository
public interface HelloWorldDao {
	 @Select("select * from log ")
	 List<HelloWorld>  find();
	 
	 @Select("select * from log where id =#{id}")
	 HelloWorld  findById(HelloWorld e);
}
