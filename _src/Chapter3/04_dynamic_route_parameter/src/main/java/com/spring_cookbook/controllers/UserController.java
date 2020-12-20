package com.spring_cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping("/user/{id}/{field}")
	@ResponseBody
	public String showUserField(@PathVariable("id") Long userId, @PathVariable("field") String field) {
		return "UserController.showUserField(), userId=" + userId + ", field=" + field;		
	}

	// example: /user/123/name
}
