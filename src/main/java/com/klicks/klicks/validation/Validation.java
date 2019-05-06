package com.klicks.klicks.validation;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import com.klicks.klicks.entities.Token;
import com.klicks.klicks.entities.User;


public class Validation {

	public static void validateToken(Token token) {
		if (token == null) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not Authorized");
		}
	}
	
	public static void validateUser(User user) {
		if (user == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User Not Found");
		}
	}

}
