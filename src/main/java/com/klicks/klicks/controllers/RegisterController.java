package com.klicks.klicks.controllers;

import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.klicks.klicks.entities.User;
import com.klicks.klicks.repositories.TokenRepository;
import com.klicks.klicks.repositories.UserRepository;


@RestController
@RequestMapping("/register")
@CrossOrigin(origins = "*")
public class RegisterController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	TokenRepository tokenRepository;

	@PostMapping("/user")
	public void registerUser(@RequestBody User user) {
		User user2 = userRepository.findByUsername(user.getUsername());
		User user3 = userRepository.findByEmail(user.getEmail());
		if ((user2 == null) && (user3 == null)) {
			String password = user.retrievePassword();
			String random = UUID.randomUUID().toString();
			user.setRandom(random);
			String sha256hex = DigestUtils.sha256Hex(password + random);
			user.setPassword(sha256hex);
			userRepository.save(user);
		} else if ((user2 != null) && (user3 == null)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username Already Exists");
		} else if ((user2 == null) && (user3 != null)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email Already Exists");
		} else if ((user2 != null) && (user3 != null)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Email and Username Already Exist");
		}

	}

}
