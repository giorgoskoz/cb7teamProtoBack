package com.klicks.klicks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klicks.klicks.entities.StudioSessions;
import com.klicks.klicks.repositories.SessionRepository;

@RestController
@RequestMapping("/sessions")
@CrossOrigin(origins = "*")
public class SessionController {

	@Autowired
	SessionRepository sessionRepository;
	
	
	@GetMapping("between/{date}/{date2}")
	public List<StudioSessions> findbetween(@PathVariable String date, @PathVariable String date2){
		return sessionRepository.findByDateBetween(date, date2);
	}
}
