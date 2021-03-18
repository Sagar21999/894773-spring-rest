package com.cognizant.springlearn;

import java.util.logging.Logger;

public class Country {

	private String code;
	private String name;
	public Logger logger=Logger.getLogger("Country.class");
	
	
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
	public Country() {
		logger.info("Inside country constructor");
	}
	
}
