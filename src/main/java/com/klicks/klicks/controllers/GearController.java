package com.klicks.klicks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klicks.klicks.entities.ExtraGear;
import com.klicks.klicks.entities.StandartGear;
import com.klicks.klicks.entities.Token;
import com.klicks.klicks.repositories.ExtraGearRepository;
import com.klicks.klicks.repositories.SessionRepository;
import com.klicks.klicks.repositories.StandartGearRepository;
import com.klicks.klicks.repositories.TokenRepository;
import com.klicks.klicks.validation.Validation;

@RestController
@RequestMapping("/gear")
@CrossOrigin(origins = "*")
public class GearController {
	
	@Autowired
	ExtraGearRepository extraGearRepository;
	
	@Autowired
	StandartGearRepository standartGearRepository;
	
	@Autowired
	TokenRepository tokenRepository;
	
	@Autowired
	SessionRepository sessionRepository;
	
	@GetMapping("all-standart")
	public List<StandartGear> getAllstandartGear(){
		return standartGearRepository.findAll();
	}

	@GetMapping("all-extra")
	public List<ExtraGear> getAllExtraGear(){
		return extraGearRepository.findAll();
	}
	
	@GetMapping("by-session/{sessionId}")
	public List<ExtraGear> getGearBySession(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric,@PathVariable int sessionId){
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		return extraGearRepository.findGearBySessions(sessionId);

	}
	
	@PostMapping("delete-standart/{gearId}")
	public void reamoveStandartGear(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric,@PathVariable int gearId) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		standartGearRepository.deleteById(gearId);
	}
	
	@PostMapping("delete-extra/{gearId}")
	public void reamoveExtratGear(@RequestHeader(value = "X-KLICKS-AUTH") String alphanumeric,@PathVariable int gearId) {
		Token token = tokenRepository.findByAlphanumeric(alphanumeric);
		Validation.validateToken(token);
		extraGearRepository.deleteById(gearId);
	}
	
}

