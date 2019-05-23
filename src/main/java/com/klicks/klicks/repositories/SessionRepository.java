package com.klicks.klicks.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klicks.klicks.entities.StudioSessions;
import com.klicks.klicks.entities.User;

@Repository
public interface SessionRepository extends JpaRepository<StudioSessions, Integer>  {
	
	StudioSessions findById(int id);
	
	StudioSessions findByDate(String date);
	
	List<StudioSessions> findByDateBefore(String date);
	
	List<StudioSessions> findByUserAndDateBefore(User user, String date);

	List<StudioSessions>  findByUserAndDateAfter(User user, String date);
	
	List<StudioSessions> findByDateAfter(String date);
	
	List<StudioSessions> findByDateBetween(String start, String end);
	
	List<StudioSessions> findByUser(User user);

	@Modifying
    @Query(value = "INSERT INTO session_gear(fk_gear_id, fk_session_id) VALUES (:gearId,:sessionId)", nativeQuery = true)
    @Transactional
    void addExtraGear(@Param("gearId") int fk_gear_id, @Param("sessionId") int fk_session_id);

}
