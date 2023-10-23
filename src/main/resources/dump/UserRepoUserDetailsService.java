package com.dave.spring.alpha.user;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Configuration
@Service
@Component
public class UserRepoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private final UserRepository userRepo;
	
	public UserRepoUserDetailsService(UserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		
		if(user != null) {
			System.out.println("Blog 8080 API - Fetched User Details from Db: " + user.getFullname());
			return user;
		}
		
		throw new UsernameNotFoundException("User '" + username + "' not found");
	}
	/*
	@Bean
	public UserRepoUserDetailsService userDetailsService() {
		return new UserRepoUserDetailsService(userRepo);
	}
	*/
}