package com.klicks.klicks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klicks.klicks.entities.ExtraGear;
import com.klicks.klicks.entities.StudioSessions;
import com.klicks.klicks.entities.Token;
import com.klicks.klicks.entities.User;
import com.klicks.klicks.repositories.SessionRepository;
import com.klicks.klicks.repositories.TokenRepository;
import com.klicks.klicks.validation.Validation;

@RestController
@RequestMapping("/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

	@Autowired
	SessionRepository sessionRepository;

	@Autowired
	TokenRepository tokenRepository;

	@GetMapping("between/{date}/{date2}")
	public List<StudioSessions> findbetween(@PathVariable String date, @PathVariable String date2) {
		return sessionRepository.findByDateBetween(date, date2);
	}

//	@PostMapping("book/{date}/{price}")
//	public void bookSession(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric, @PathVariable String date, @PathVariable double price) {
//		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
//		User user = token.getUser();
//		StudioSessions session = new StudioSessions(user, date, price);
//		sessionRepository.save(session);
//	}
	
	@GetMapping("by-date/{date}")
	public StudioSessions getSessionsByDate(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric,
			@PathVariable String date) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		return sessionRepository.findByDate(date);
	}
		
	@GetMapping("before/{date}")
	public List<StudioSessions> getSessionsBefore(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric, @PathVariable String date) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		return sessionRepository.findByDateBefore(date);
	}
	
	
	@GetMapping("after/{date}")
	public List<StudioSessions> getSessionsAfter(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric, @PathVariable String date) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		return sessionRepository.findByDateAfter(date);
	}
	
	@GetMapping("by-user-before")
	public List<StudioSessions> getMySessionsBefore(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric, @PathVariable String date) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		User user = token.getUser();
		return sessionRepository.findByUserAndDateBefore(user, date);
	}
	
	@GetMapping("by-user-after")
	public List<StudioSessions> getMySessionsAfter(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric, @PathVariable String date) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		User user = token.getUser();
		return sessionRepository.findByUserAndDateAfter(user, date);
	}
	
	@PostMapping("book2/{date}/{price}")
	public void book(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric, @PathVariable String date,
			@PathVariable double price, @RequestBody List<ExtraGear> extras) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		User user = token.getUser();
		StudioSessions session = new StudioSessions(user, date, price);
		double sum = price;
		for (ExtraGear extra : extras) {
			sum += extra.getPrice();
		}
		session.setTotalPrice(sum);
		sessionRepository.save(session);
		for (ExtraGear extra : extras) {
			sessionRepository.addExtraGear(extra.getId(), session.getId());
		}
	}

	@GetMapping("for-user")
	public List<StudioSessions> usersSessions(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		User user = token.getUser();
		return sessionRepository.findByUser(user);
	}

	@PostMapping("/delete/{sessionId}")
	public void deleteMsg(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric, @PathVariable int sessionId) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		sessionRepository.deleteById(sessionId);
	}

}
