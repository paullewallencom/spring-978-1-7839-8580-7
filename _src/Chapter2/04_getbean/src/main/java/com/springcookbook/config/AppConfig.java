package com.springcookbook.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.springcookbook.controller", "com.springcookbook.service"})
public class AppConfig {	
}
