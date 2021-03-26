package com.cognizant.LearnTodayRESTAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Course not found")
public class CourseNotFoundException  extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CourseNotFoundException() {
		super("Course not found");
	}
}