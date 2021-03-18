package com.cognizant.springlearn;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {
	
	public static Logger logger=Logger.getLogger("SpringLearnApplication.class");
	

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		
		logger.setLevel(Level.FINE);
		displayCountry();
		displayCountries();
	}

	private static void displayCountries() {
		ApplicationContext context=new ClassPathXmlApplicationContext("country.xml");
		logger.info("handson 3");
		List<Country> countryList=(List<Country>) context.getBean("countryList", ArrayList.class);
		//System.out.println(countryList);
		logger.info(countryList.toString());
	}

	private static void displayCountry() {
	
		ApplicationContext context= new ClassPathXmlApplicationContext("country.xml");
		logger.info("handson 1&2");
		Country country= (Country) context.getBean("country", Country.class);
		Country anothercountry= context.getBean("country", Country.class);
		//System.out.println(country);
		logger.info(country.toString());
		
	}

}
