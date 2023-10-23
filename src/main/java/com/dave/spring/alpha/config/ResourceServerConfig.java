package com.dave.spring.alpha.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	/*
	//@Autowired
	//private DataSource dataSource;
	
	//@Value("${jwt.key}")
	//private String jwtKey;
	
	@Value("${publicKey}")
	private String publicKey;
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		
		//super.configure(resources);
		resources.tokenStore(tokenStore());
	}

	@Bean
	public TokenStore tokenStore() {
		//return new JdbcTokenStore(dataSource);	// Forgo the blackboarding and go for JWT symmetric key validation 
		return new JwtTokenStore(JwtAccessTokenConverter());
	}

	@Bean
	public JwtAccessTokenConverter JwtAccessTokenConverter() {
		JwtAccessTokenConverter conv = new JwtAccessTokenConverter();
		//conv.setSigningKey(jwtKey);
		
		conv.setVerifierKey(publicKey);
		
		return conv;
	}
	*/
	
}