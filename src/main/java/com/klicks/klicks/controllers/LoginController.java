package com.klicks.klicks.controllers;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.klicks.klicks.entities.Login;
import com.klicks.klicks.entities.Token;
import com.klicks.klicks.entities.User;
import com.klicks.klicks.repositories.TokenRepository;
import com.klicks.klicks.repositories.UserRepository;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*")
public class LoginController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TokenRepository tokenRepository;

	@PostMapping("/user")
	public Token loginUser(@RequestBody Login login) {
		String username = login.getUsername();
		String password = login.getPassword();
		User user1 = userRepository.findByUsername(username);
		String random = user1.retrieveRandom();
		String sha256hex = DigestUtils.sha256Hex(password + random);
		User user = userRepository.findByUsernameAndPassword(username, sha256hex);
		if (user != null) {
				String alphanumeric = UUID.randomUUID().toString();
				Token token = new Token(alphanumeric, user);
				tokenRepository.save(token);
				return token;
		} else {
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid Username/Password");
		}
	}

	@PostMapping("/logout")
	public void logout(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric) {
		tokenRepository.deleteByAlphanumeric(alphanumeric);
	}
}
