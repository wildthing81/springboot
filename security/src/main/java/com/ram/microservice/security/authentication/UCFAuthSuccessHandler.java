package com.forum.authentication;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.forum.entities.UCFUserSession;
import com.forum.services.UserActivityService;
import com.forum.utils.UCFConstants;

@Component
public class UCFAuthSuccessHandler implements AuthenticationSuccessHandler {
		
	private static final SimpleGrantedAuthority ADMIN_AUTHORITY = new SimpleGrantedAuthority("ROLE_ADMIN");
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Autowired
    private UserActivityService userActivityService;
	@Autowired
	private UCFUserSession userSession;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest req, HttpServletResponse res, 
										Authentication auth) throws IOException, ServletException 
	{
		String userName="Guest";
		LocalDateTime loginTime=LocalDateTime.now();
		if (auth!=null & !(auth instanceof AnonymousAuthenticationToken))
			userName=((UserDetails) auth.getPrincipal()).getUsername();			
			
		userSession.setLoginTime(loginTime);
		userSession.setUserName(userName);
		userActivityService.updateLoginActivity(loginTime,userName);        
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();
        if (authorities.contains(ADMIN_AUTHORITY)) {
        	userSession.setRole(ADMIN_AUTHORITY.getAuthority());
            redirectStrategy.sendRedirect(req, res, "/homepage.htm");
        } else {
            redirectStrategy.sendRedirect(req, res, "/homepage.htm");
        }

	}

}
