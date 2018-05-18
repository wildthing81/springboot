package com.ram.microservice.security.configuration;

import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfig {

	/*@Autowired
	private EntityManagerFactory entityManagerFactory;

	@Bean
	public SessionFactory getSessionFactory() {
	    if (entityManagerFactory.unwrap(SessionFactory.class) == null) {
	        throw new NullPointerException("factory is not a hibernate factory");
	    }
	    return entityManagerFactory.unwrap(SessionFactory.class);
	}*/
}
