package com.dave.spring.alpha;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dave.spring.alpha.repo.PostRepository;
import com.dave.spring.alpha.user.UserRepository;

@Configuration
public class AppBeans {
	
	//@Autowired
	//public PostRepository postRepo;
	
//	@Autowired
//	public UserRepository userRepo;
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	
	
	/*
	@Bean
	UserDetailsService userDetailsService(UserRepository userRepo) {
		System.out.println("Fetching User Details from Db: " + userRepo.findByUsername("admini"));
		
		return username -> userRepo.findByUsername(username);
	}
	*/
	
	/*
	@Bean
	public InMemoryUserDetailsManager users() {
	    return new InMemoryUserDetailsManager(
	            User.withUsername("dave")
	                    .password("$2a$10$uFqjwY5VjiPN6AWRjo7oP.Lj5T6Q7r8ZVeO.S39.5Hm5fgVGUoDkK")
	                    .authorities("read")
	                    .build()
	    );
	}
	*/
	
	/*
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}
	*/
	
	/*
	@Bean(name="entityManagerFactory")
	public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

	    return sessionFactory;
	}
	*/
	
	
	/*
	@Bean
    public IDGen idGen(PostRepository postRepository) {
        return new IDGen(postRepository);
    }
    */
}