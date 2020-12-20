package com.spring_cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@RequestMapping("/list")
	@ResponseBody
	public String list() {
		return "UserController.list()";
	}

	@RequestMapping("/add")
	@ResponseBody
	public String add() {
		return "UserController.add()";
	}
}
