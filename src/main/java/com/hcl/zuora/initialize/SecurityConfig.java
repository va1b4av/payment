package com.hcl.zuora.initialize;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 
 * Security configuration for quizup. We provide a custom user details service
 * here. Also provide channels (https) for various requests.
 * 
 * @author Vaibhav.Saxena
 * 
 */
@Configuration
@EnableWebSecurity
@ComponentScan("com.hcl.zuora.initialize")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	

	

	
	/**
	 * Configure all aspects of security. Provide secured URL's, requires channel, successHandler etc.
	 * 
	 * @param http HttpSecurity.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			
			
			.requiresChannel().anyRequest().requiresSecure(); // All requests to be secured (https).
			//Adds the SocialAuthenticationFilter to Spring Security's filter chain.
			
	}

	

	
	
	
}