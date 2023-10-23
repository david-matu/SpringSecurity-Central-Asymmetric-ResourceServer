package com.dave.spring.alpha.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.web.SecurityFilterChain;

import com.dave.spring.alpha.user.UserRepoUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {	//extends WebSecurityConfigurerAdapter
	
	
	private final UserRepoUserDetailsService userDetailService;
	
	public SecurityConfig(UserRepoUserDetailsService userDetailService) {
		this.userDetailService = userDetailService;
	}
	
	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		//System.out.println("Security filter chain passed... ");
		//System.out.println("Application bean: " + applicationContext.getBean(UserRepository.class));
		
		/*
		return http
				.authorizeHttpRequests(authorizeRequests -> 
						authorizeRequests.anyRequest().authenticated()
				)				
				.formLogin(Customizer.withDefaults())
				.build();
				
				*/
		
		return http
				.authorizeHttpRequests(authorizeRequests -> authorizeRequests
						.antMatchers(HttpMethod.POST).permitAll()
						.antMatchers(HttpMethod.PUT).permitAll()
						.anyRequest().authenticated())
				.build();
					
		/**
		 * 
		 * Uncomment when using oauth2 dependency
		return http
				.csrf(csrf -> csrf.disable())	//Disable Cross-Site Request Forgery - use with disabled session management
				.authorizeHttpRequests(auth -> auth
						.anyRequest().authenticated() //User should be authenticated for any request in the application
				)
				.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) //SPring should not create HttpSession
				.httpBasic(Customizer.withDefaults()) //Spring Security's Basic HTTP Authentication is enabled by default
				.build();
				
				*/
		
		/*
		http
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeHttpRequests((authz) -> authz
                    .antMatchers(HttpMethod.POST, "/login/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/users/**").hasAuthority("ROLE_ADMIN")
                    .anyRequest().authenticated()
            )
			.addFilter(new CustomAuthenticationFilter(authenticationManager))
			.addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthentication.class)
			.headers().cacheControl();
		
		return http.build();
		*/
		
		/*
		http.csrf().disable()
	        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
	        .and()
	        .authorizeRequests().antMatchers(HttpMethod.POST, "/login/**").permitAll()
	        .and()
	        .authorizeRequests().antMatchers(HttpMethod.POST, "/users/**").hasAuthority("ROLE_ADMIN")
	        .and()
	        .authorizeRequests().anyRequest().authenticated()
	        .and()
	        .addFilter(new CustomAuthenticationFilter(super.authenticationManagerBean()))
	        .addFilterBefore(new CustomAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

		http.headers().cacheControl();
		*/
	}
	
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/*
	@Bean
	JwtDecoder jwtDecorder() {
		return NimbusJwtDecoder.withPublicKey(rsaKeys.publicKey()).build();
	}
	*/
	
	
	/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}
	*/
}
