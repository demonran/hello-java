package com.tcl.helloworld.json;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;



@JsonTypeInfo(  
		use = JsonTypeInfo.Id.NAME,  
		include = JsonTypeInfo.As.PROPERTY,  
		property = "properties")  
//difine sub types name for 
@JsonSubTypes({  
	@Type(value = Dog.class, name = "dog"),
	@Type(value = Fish.class, name = "fish"),
	})
public abstract class Animal
{
	private String eye;

	public String getEye()
	{
		return eye;
	}

	public void setEye(String eye)
	{
		this.eye = eye;
	}
	
	
}
