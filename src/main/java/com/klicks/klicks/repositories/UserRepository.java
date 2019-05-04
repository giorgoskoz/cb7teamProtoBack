package com.klicks.klicks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klicks.klicks.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findById(int id);

	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByEmail(String email);
}
