package com.cognizant.springlearn.controller;

import java.util.logging.Logger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	public static Logger logger=Logger.getLogger("HelloController.class");


	@RequestMapping("/hello")
	public String sayHello() {
		//System.out.println("hello");
		logger.info("sayHello() method start");
		logger.info("sayHello() method end");

		return "Hello World!";
	}
}
