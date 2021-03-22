package com.cognizant.springlearn.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cognizant.springlearn.model.Country;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	public Country getCountry(String code)throws CountryNotFoundException {
		ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
		List<Country> countryList=(List<Country>) context.getBean("countryList", ArrayList.class);
		int flag=0;
		for(Country c:countryList) {
			if(c.getCode().equalsIgnoreCase(code)) {
				flag=1;
				return c;
			}
		}
		if(flag==0) {
			throw new CountryNotFoundException("Country Not Found");
		}
		return null;

	}
}
