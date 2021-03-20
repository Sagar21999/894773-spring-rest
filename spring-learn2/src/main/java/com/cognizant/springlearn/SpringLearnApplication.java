package com.cognizant.springlearn;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {
	
	public static Logger logger=Logger.getLogger("SpringLearnApplication.class");
	

	public static void main(String[] args) {
		SpringApplication.run(SpringLearnApplication.class, args);
		
		/*
		 * logger.setLevel(Level.FINE); displayCountry(); displayCountries();
		 */
	}

	
}
