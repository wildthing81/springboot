package com.ram.microservice.security.authorization;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableAuthorizationServer
public class UCFAuthorizationConfig extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	@Qualifier("epUser")
    private UserDetailsService userDetailsService;
	
	@Autowired
	private DataSource dataSource;
	
	public TokenStore tokenStore() {
		// TODO Auto-generated method stub
		return new JdbcTokenStore(dataSource);
	}
	
	@Bean
    public OAuth2AccessDeniedHandler authAccessDeniedHandler() {
        return new OAuth2AccessDeniedHandler();
    }
	
	@Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) {
		oauthServer.allowFormAuthenticationForClients();
        oauthServer.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
        //.passwordEncoder(oauthClientPasswordEncoder);
    }

	@Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.tokenStore(tokenStore());
        endpoints.authenticationManager(authenticationManager);
        //endpoints.
    }
	
	

	@Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                //jdbc(dataSource)
        		.withClient("clientapp")
        		.authorizedGrantTypes("password", "refresh_token")
        		.scopes("read", "trust")
        		.resourceIds("resource-server-rest-api")
        		.secret("123456")
        		.accessTokenValiditySeconds(180)
                .refreshTokenValiditySeconds(600)
        		.autoApprove(true).and().build();
    }
	
	 
}
