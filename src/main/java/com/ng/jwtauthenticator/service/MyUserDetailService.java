package com.ng.jwtauthenticator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ng.jwtauthenticator.model.User;
import com.ng.jwtauthenticator.repo.UserRepo;

@Service
public class MyUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepo repo;
	
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	UserDetails u=repo.findByUsername(username); 		
		return u;
    }

}
