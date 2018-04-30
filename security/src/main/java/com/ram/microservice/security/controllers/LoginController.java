package com.ram.microservice.security.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ram.microservice.security.entities.UCFUserSession;


@Controller
public class LoginController {

	@Autowired
	private UCFUserSession userSession;
	
	/*@Bean
	@Scope("session")
	public UCFUserSession createUserSession(HttpServletRequest req){
		
		UCFUserSession userSession=new UCFUserSession();
		userSession.setLoginTime(new Date());
		userSession.setUserName(userDetails.getUsername());
	}*/
	
	@RequestMapping(value="/login.htm")
	public String login(Model model)
	{
		return "login";
	}
	
	@RequestMapping(value="/homepage.htm")
	public String dashboard(Model model,HttpSession session)
	{
		System.out.println("login with "+userSession.getUserName()+" was successful");
		model.addAttribute("loginTime",userSession.getLoginTime());
		model.addAttribute("user", userSession.getUserName());
		return "homepage";
	}
	
	@RequestMapping(value="/error.htm")
	public String failurePage(Model model)
	{
		System.out.println("LoginController:error");
		return "error";
	}
	
		
	@RequestMapping(value="/403")
	public String accesssDenied(Model model) 
	{
 
	  //check if user is login
	  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	  if (!(auth instanceof AnonymousAuthenticationToken)) 
	  {
		UserDetails userDetail = (UserDetails) auth.getPrincipal();	
		model.addAttribute("username", userDetail.getUsername());
	  }
 
	  return "403";
 
	}
}
