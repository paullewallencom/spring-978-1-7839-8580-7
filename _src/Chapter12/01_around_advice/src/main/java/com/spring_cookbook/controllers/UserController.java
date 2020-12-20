package com.spring_cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	@RequestMapping("user_list")
	@ResponseBody
	public void userList() throws Exception {
		try {
		    Thread.sleep(2500);	// wait 2.5 seconds
		} catch(InterruptedException ex) {
		    Thread.currentThread().interrupt();
		}
	}
	
}
