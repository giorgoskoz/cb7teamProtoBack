package com.klicks.klicks.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.klicks.klicks.entities.ExtraGear;
import com.klicks.klicks.entities.StandartGear;
import com.klicks.klicks.repositories.ExtraGearRepository;
import com.klicks.klicks.repositories.StandartGearRepository;

@RestController
@RequestMapping("/gear")
@CrossOrigin(origins = "*")
public class GearController {
	
	@Autowired
	ExtraGearRepository extraGearRepository;
	
	@Autowired
	StandartGearRepository standartGearRepository;
	
	@GetMapping("/all-standart")
	public List<StandartGear> getAllstandartGear(){
		return standartGearRepository.findAll();
	}

	@GetMapping("/all-extra")
	public List<ExtraGear> getAllExtraGear(){
		return extraGearRepository.findAll();
	}
}
