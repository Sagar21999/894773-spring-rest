package com.cognizant.springlearn.controller;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.entity.Country;
import com.cognizant.springlearn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@RestController
public class CountryController {

	ApplicationContext context = new ClassPathXmlApplicationContext("country.xml");
	CountryService service;
	public static Logger logger = Logger.getLogger("Countrycontroller.class");

	public CountryController(CountryService service) {
		super();
		this.service = service;
	}

	@RequestMapping(value = "/country", produces = { APPLICATION_JSON_VALUE })
	public Country getCountryIndia() {
		logger.info("start /country");
		System.out.println("h2");
		Country country = (Country) context.getBean("in", Country.class);
		System.out.println(country);
		logger.info("end /country");

		return country;
	}

	@RequestMapping(value = "/countries", produces = { APPLICATION_JSON_VALUE })
	public List<Country> getAllCountries() {
		logger.info("start /countries");

		System.out.println("h3");
		List<Country> countryList = (List<Country>) context.getBean("countryList", ArrayList.class);
		logger.info("end /countries");

		return countryList;
	}

	@GetMapping(value = "/countries/{code}", produces = { APPLICATION_JSON_VALUE })
	public Country getcountry(@PathVariable("code") String code) throws CountryNotFoundException {
		logger.info("start /countries/{code}");

		System.out.println("h4.1" + code);
		Country country = service.getCountry(code);
		logger.info("end /countries/{code}");

		return country;
	}

}
