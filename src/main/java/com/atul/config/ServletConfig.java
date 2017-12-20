package com.atul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {
	
	 @Bean
	  public SimpleCorsFilter simpleCorsFilter() {
	        return new SimpleCorsFilter();
	 }

}
