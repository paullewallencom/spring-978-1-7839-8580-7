package com.spring_cookbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_cookbook.dao.UserDAO;
import com.spring_cookbook.domain.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@RequestMapping("user_add")
	@ResponseBody
	public String userList() {
		User user = new User();
		user.setFirstName("Merlin");
		user.setAge(372);
		
		userDAO.add(user);
		
		return "User was successfully added";
	}

}
