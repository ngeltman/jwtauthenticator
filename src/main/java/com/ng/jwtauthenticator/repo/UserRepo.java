package com.ng.jwtauthenticator.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.ng.jwtauthenticator.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
	public UserDetails findByUsername(String user);
}
