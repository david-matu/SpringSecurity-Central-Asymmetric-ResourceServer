package com.dave.spring.alpha.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class AppConfigs {
	/*
	@Value("${spring.security.oauth2.resourceserver.opaquetoken.introspection-uri}")
	private String introspectURI;
	
	@Value("${spring.security.oauth2.resourceserver.opaquetoken.client-id}")
	private String introspectClient;
	
	@Value("${spring.security.oauth2.resourceserver.opaquetoken.client-secret}")
	private String introspectClientSecret;
	*/
	
	/*
	 * @Autowired private JmsTemplate jms;
	 */	
	
	/*
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
				.anyRequest().authenticated()
				
				.and()
				.oauth2ResourceServer(
						c -> c.opaqueToken(
								o -> {
									o.introspectionUri(introspectURI);
									o.introspectionClientCredentials(introspectClient, introspectClientSecret);
								})
						
						);

				;
		
		return http.build();
	}
	*/

}
