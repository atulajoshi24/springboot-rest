package com.atul.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

import com.atul.config.JPAConfig;
import com.atul.config.SecurityConfig;
import com.atul.config.ServiceConfig;
import com.atul.config.ServletConfig;
import com.atul.config.WebConfig;



@SpringBootApplication
@Import({ // @formatter:off	
	WebConfig.class,
	JPAConfig.class,
	ServiceConfig.class,
	SecurityConfig.class,
	ServletConfig.class
})
public class App extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(App.class);
	}

}
