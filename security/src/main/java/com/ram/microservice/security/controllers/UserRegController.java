package com.ram.microservice.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ram.microservice.security.dao.UCFUserDao;
import com.ram.microservice.security.entities.UCFUser;


@RestController
public class UserRegController {
	
	@Autowired
	private UCFUserDao ucfUserDao;
	
	@PostMapping(value="/userreg.htm")
	public String userRegistration(@ModelAttribute UCFUser ucfUser)
	{
		ucfUserDao.saveUCFUser(ucfUser);
		//logger.info("User Registered Successfully!!!!!!");
		return "Your registration is complete.You will recieve an email shortly containing" +
				"your login credentials.Have a nice day";
	}
	

	@RequestMapping(value="/newsletter.htm")
	public String subscribeLetter(@RequestParam Boolean newsletterFlag,Model model)
	{
		//epUserDao.setEPUser(epUser);
		//logger.info("User Registered Successfully!!!!!!");
		/*return "Your registration is complete.You will recieve an email shortly containing" +
				"your login credentials.Have a nice day";*/
		return null;
	}
	
	@PostMapping(value="/rest/createUser")
	public String createUser(@ModelAttribute UCFUser ucfUser)
	{
		ucfUserDao.saveUCFUser(ucfUser);
		//logger.info("User Registered Successfully!!!!!!");
		return "Your registration is complete.You will recieve an email shortly containing" +
				"your login credentials.Have a nice day";
	}
	
}
