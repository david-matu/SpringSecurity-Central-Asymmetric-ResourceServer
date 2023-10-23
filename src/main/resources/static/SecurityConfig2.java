package com.dave.spring.alpha.security;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.context.WebApplicationContext;

import org.springframework.security.authentication.AuthenticationManager;

//import com.dave.spring.starter.user.UserRepoUserDetailsService;
import com.dave.spring.starter.user.UserRepository;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig2 {	//extends WebSecurityConfigurerAdapter
	
	/*
	@Autowired
	private WebApplicationContext applicationContext;
	 
	 @Autowired
	 private DataSource dataSource;
	 */
	//private UserRepository userRepo;
	
	/*
	private UserDetailsService userDetailsService;
	
	@PostConstruct
	public void completeSetup() {
		userDetailsService = applicationContext.getBean(UserRepoUserDetailsService.class);
	}
	
	public SecurityConfig(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}
	*/
	
	/*
	@Bean
	public DaoAuthenticationProvider authenticationProvider(UserDetailsService userDetailsService) {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		return authProvider;
	}
	*/
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests().antMatchers("/api/secured/**").authenticated().and().httpBasic();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	@Bean 
	public UserDetailsService userDetailsService() { 
		return new UserRepoUserDetailsService(userRepo); 
	}
	*/
	
	/*
	
	@Bean
    public UserDetailsManager users(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManagerBuilder.class)
            .userDetailsService(userDetailsService)
            .passwordEncoder(passwordEncoder())
            .and()
            .authenticationProvider(authenticationProvider())
            .build();

        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setAuthenticationManager(authenticationManager);
        return jdbcUserDetailsManager;
    }
	
	@Bean
    public DaoAuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
	*/
}
