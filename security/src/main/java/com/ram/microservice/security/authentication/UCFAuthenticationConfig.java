package com.ram.microservice.security.authentication;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
//@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
@Order(1)
@EnableOAuth2Sso
public class UCFAuthenticationConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	@Qualifier("epUser")
    private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationSuccessHandler successHandler;
	
	@Override
	protected void configure(AuthenticationManagerBuilder authManagerBuilder) 
			throws Exception 
	{

		authManagerBuilder.userDetailsService(userDetailsService)
											.passwordEncoder(userPasswordEncoder());

	}	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
            .antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
            .and()
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
               // .and().csrf().disable()
                ;
                
    }
	
	@Bean
    public PasswordEncoder userPasswordEncoder() {
        return new BCryptPasswordEncoder(8);
	}
}
