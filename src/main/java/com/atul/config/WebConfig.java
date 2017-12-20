package com.atul.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan({ "com.atul.controller","com.atul.web"})
@EnableWebMvc
public class WebConfig {

}
