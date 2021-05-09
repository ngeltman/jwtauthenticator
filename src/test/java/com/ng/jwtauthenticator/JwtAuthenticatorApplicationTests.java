package com.ng.jwtauthenticator;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.ng.jwtauthenticator.model.User;
import com.ng.jwtauthenticator.repo.UserRepo;

@SpringBootTest
class JwtAuthenticatorApplicationTests {

	@Autowired
	private UserRepo repo;
	
	@Test
	void crearUsers() {
		List<GrantedAuthority> ga=new ArrayList();
		
		ga.add(new SimpleGrantedAuthority("ROLE_SENSEI"));
		
		User u=new User();
		u.setUsername("nico");
		u.setPassword(new BCryptPasswordEncoder().encode("nico"));
		u.setEnabled(true);
		u.setAuthorities(ga);
		User r=repo.save(u);
		
		Assertions.assertTrue(r.getUsername().equals(u.getUsername()));
		
	}

}
