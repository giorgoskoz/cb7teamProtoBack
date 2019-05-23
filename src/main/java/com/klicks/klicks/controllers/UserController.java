package com.klicks.klicks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klicks.klicks.database.DatabaseHelper;
import com.klicks.klicks.entities.Result;
import com.klicks.klicks.entities.Role;
import com.klicks.klicks.entities.Token;
import com.klicks.klicks.entities.User;
import com.klicks.klicks.repositories.TokenRepository;
import com.klicks.klicks.repositories.UserRepository;
import com.klicks.klicks.validation.Validation;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TokenRepository tokenRepository;
	
	@GetMapping("all")
	public Result<User> getAllUsers(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric, @RequestParam int page, @RequestParam int size){
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
//		Validation.validatePageAndSize(page, size);
		Role role = new Role(1, "USER");
		int count = DatabaseHelper.getSimpleUsersCount();
		List<User> users = userRepository.findByRole(role, PageRequest.of(page, size));
		return new Result<User>(count, users);
	}
	
	@PostMapping("delete/{userId}")
	public void deleteUser(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric,@PathVariable int userId) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		User user = userRepository.findById(userId);
		Validation.validateUser(user);
		userRepository.delete(user);
	}
	
}
