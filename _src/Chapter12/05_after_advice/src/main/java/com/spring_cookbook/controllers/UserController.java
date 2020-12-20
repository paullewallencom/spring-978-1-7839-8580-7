package com.spring_cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@RequestMapping("user_list")
	@ResponseBody
	public String userList() {
		return "method returning normally";
	}
	
	@RequestMapping("user_list2")
	@ResponseBody
	public String userList2() throws Exception  {
		throw new Exception("just a test");
	}
}
