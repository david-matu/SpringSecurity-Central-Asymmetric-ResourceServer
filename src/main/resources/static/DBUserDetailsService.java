package com.dave.spring.starter.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Configuration
@Service
public class DBUserDetailsService implements UserDetailsService {
	
	private final UserRepository userRepository;
	
    public DBUserDetailsService(UserRepository userRepo) {
        this.userRepository = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userAccount = userRepository.findByUsername(username);
        
        System.out.println("Loading user by username: " + username);
        
        if (userAccount == null) {
            throw new UsernameNotFoundException("User with username [" + username + "] not found in the system");
        }
        return userAccount;
    }
    
    @Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
    
}
