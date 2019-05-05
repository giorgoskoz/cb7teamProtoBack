package com.klicks.klicks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klicks.klicks.entities.StudioSessions;
import com.klicks.klicks.entities.Token;

@Repository
public interface SessionRepository extends JpaRepository<StudioSessions, Integer>  {
	
	StudioSessions findById(int id);
	
	StudioSessions findByDate(String date);
	
	List<StudioSessions> findByDateBetween(String start, String end);

}
