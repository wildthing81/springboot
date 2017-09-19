package com.avaya.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableCaching
@SpringBootApplication
@RestController
public class DemoApplication extends SpringBootServletInitializer{
	
	@Autowired
	private DemoService demoService;
	
	@RequestMapping("/")
    public String home() {
        return "Hello Docker";
    }
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
