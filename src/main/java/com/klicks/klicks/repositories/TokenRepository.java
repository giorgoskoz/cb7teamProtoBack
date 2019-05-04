package com.klicks.klicks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.klicks.klicks.entities.Token;

@Repository
public interface TokenRepository extends JpaRepository<Token, Integer> {

	Token findByAlphanumeric(String alphanumeric);

	@Transactional
	void deleteByAlphanumeric(String alphanumeric);

}
