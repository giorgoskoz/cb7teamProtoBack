package com.klicks.klicks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.klicks.klicks.entities.ExtraGear;

public interface ExtraGearRepository extends JpaRepository<ExtraGear, Integer>{

	ExtraGear findById(int id);
}
