package com.cognizant.springlearn.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.logging.Logger;

public class Country {

	@NotNull
	@Size(min = 2, max = 2, message = "Country code should be 2 characters")
	private String code;
	private String name;
	
	
	
	public Country() {
		
		Logger logger=Logger.getLogger("Country.class");
		logger.info("inside constructor");
		// TODO Auto-generated constructor stub
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Country(String code, String name) {
		super();
		this.code = code;
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
}
