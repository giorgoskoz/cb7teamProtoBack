package com.klicks.klicks.repositories;

			
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.klicks.klicks.entities.Role;
import com.klicks.klicks.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findById(int id);

	User findByUsername(String username);
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByEmail(String email);
	
	List<User> findByRole(Role role, Pageable pageable);
	
}
