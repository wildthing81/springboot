package com.ram.microservice.security.authentication;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
@Order(3)
public class UCFResourceConfig extends ResourceServerConfigurerAdapter{
	
	private static final String RESOURCE_ID = "resource-server-rest-api";

	
	
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.
        authorizeRequests().
        antMatchers("/oauth/token").permitAll().
        anyRequest().access("#oauth2.hasScope('read')").
        //.sessionManagement().
        //sessionCreationPolicy(SessionCreationPolicy.STATELESS).
        and().
        csrf().disable();
                
    }
	
}
