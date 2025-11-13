package com.ajith.SpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ajith.SpringSecurity.Model.UserPrinciple;
import com.ajith.SpringSecurity.Model.Users;
import com.ajith.SpringSecurity.repo.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Users user = userRepo.findByUserName(username);
		if(user==null) {
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found exception");
		}
		return new UserPrinciple(user);
	}

}
