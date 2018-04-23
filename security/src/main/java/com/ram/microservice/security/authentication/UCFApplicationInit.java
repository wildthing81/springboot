package com.forum.authentication;

import org.springframework.core.annotation.Order;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Order(1)
public class UCFApplicationInit extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	
	@Override
	protected WebApplicationContext createRootApplicationContext() {
		// TODO Auto-generated method stub
		return new XmlWebApplicationContext();
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		 return new Class[] { UCFSecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
