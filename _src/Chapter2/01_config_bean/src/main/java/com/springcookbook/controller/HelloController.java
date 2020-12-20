package com.springcookbook.controller;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@Autowired
	DataSource dataSource;
	
	@RequestMapping("hi")
	@ResponseBody
	public String hi() {
		return dataSource.toString();
	}
}
