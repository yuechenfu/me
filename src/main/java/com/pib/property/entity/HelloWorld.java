package com.pib.property.entity;

import java.io.Serializable;

import com.pib.nullhandler.NotNullObject;
import com.pib.nullhandler.NullObject;
import com.pib.property.model.builder.AbstractBuilder;

public class HelloWorld implements Serializable, NotNullObject{

	private long id;

	private String name;
	
	public static final Null NULL = new Null();
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

    private static class Null extends HelloWorld implements NullObject {
    }
    
	public static class Builder extends AbstractBuilder {
        @Override
        public HelloWorld build() {
            try {
                return super.build(HelloWorld.class);
            } catch (InstantiationException | IllegalAccessException e) {
                return NULL;
            }
        }
    }
	
}
