package com.prasad.learnspring.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
//binding with the status number
public class BadInputException extends RuntimeException {

	public BadInputException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BadInputException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}