package com.cognizant.LearnTodayRESTAPI.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Trainer not found")
public class TrainerNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TrainerNotFoundException() {
		super("Trainer not found");
	}

}