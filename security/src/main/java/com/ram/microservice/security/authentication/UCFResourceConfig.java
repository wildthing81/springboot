package com.ram.microservice.security.authentication;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableResourceServer
public class UCFResourceConfig extends ResourceServerConfigurerAdapter{
	
	private static final String RESOURCE_ID = "resource-server-rest-api";

	
	
	@Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID);
    }
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                //.antMatchers("/rest/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login.htm").failureUrl("/error.htm")
                .loginProcessingUrl("/spring_sec_auth.htm")
                .usernameParameter("username").passwordParameter("password").permitAll()
                .successHandler(successHandler)
                .and()
                .logout()
                //.logoutSuccessUrl("/login.htm?logout")
                .invalidateHttpSession(true)
                .and().headers().xssProtection()
                .and().csrf().disable()
                ;
                
    }
	
	@Bean
    public PlaintextPasswordEncoder encoder() {
        //return new BCryptPasswordEncoder(); /* will encode passwords on registration*/
		return new PlaintextPasswordEncoder();
    }
}
