package com.hcl.zuora.initialize;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * 
 * Used to map the Spring security filter chain. SOmething that was done in web.xml in XML config.
 * 
 * @author Vaibhav.Saxena
 *
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
	
	public SecurityWebApplicationInitializer() {
		super(SecurityConfig.class);
	}
}
