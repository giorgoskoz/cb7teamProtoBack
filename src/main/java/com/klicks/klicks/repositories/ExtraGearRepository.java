package com.klicks.klicks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.klicks.klicks.entities.ExtraGear;
import com.klicks.klicks.entities.StudioSessions;

public interface ExtraGearRepository extends JpaRepository<ExtraGear, Integer>{

	ExtraGear findById(int id);
	
	List<ExtraGear> findBySessions(StudioSessions session);
	
	@Query(value="SELECT idextra_gear,price,description,piclink FROM extra_gear,session_gear WHERE idextra_gear = fk_gear_id AND fk_session_id = ?1",nativeQuery = true)
	List<ExtraGear> findGearBySessions(int sessionId);
}
