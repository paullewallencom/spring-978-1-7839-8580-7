package com.spring_cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.spring_cookbook.domain.User;

@Controller
public class UserController {

	@RequestMapping("user2")
	@ResponseBody
	public void user2() {
        String url = "http://localhost:8080/rest_server/users/2";

        RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject(url, User.class);
        
		System.out.println("User " + user.getAge() + " is " + user.getAge() + " years old");        
	}
	
	@RequestMapping("user_list")
	@ResponseBody
	public void userList() {
		String url = "http://localhost:8080/rest_server/users";
		
		RestTemplate restTemplate = new RestTemplate();
		User[] userList = restTemplate.getForObject(url, User[].class);
		
		for (User user : userList) {
			System.out.println("User " + user.getAge() + " is " + user.getAge() + " years old");
		}
	}
}
