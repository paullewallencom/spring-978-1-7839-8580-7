package com.spring_cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    
	@RequestMapping("test1")
	public void test1() {
		System.out.println("TestController.test1()");
	}
}
