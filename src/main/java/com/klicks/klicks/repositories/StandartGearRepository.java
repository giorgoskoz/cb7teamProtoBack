package com.klicks.klicks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klicks.klicks.entities.StandartGear;

@Repository
public interface StandartGearRepository extends JpaRepository<StandartGear, Integer> {

	StandartGear findById(int id);
}
