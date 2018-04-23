package com.forum.authentication;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebMvcSecurity
public class UCFSecurityConfig extends WebSecurityConfigurerAdapter{
	
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
													.passwordEncoder(encoder());
		
		/*authManagerBuilder.jdbcAuthentication().dataSource(epDataSource)
                .passwordEncoder(new BCryptPasswordEncoder());*/
         
         	//	.usersByUsernameQuery("select user_name,password from ep_user where user_name=?" +
         	//			"and password=?");
         		//.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
         		
    }
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
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
