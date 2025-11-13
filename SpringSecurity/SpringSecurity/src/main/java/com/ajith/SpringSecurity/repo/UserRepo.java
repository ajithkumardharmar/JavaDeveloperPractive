package com.ajith.SpringSecurity.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ajith.SpringSecurity.Model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {
	
	Users findByUserName(String username);

}
