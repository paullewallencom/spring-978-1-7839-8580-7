package com.spring_cookbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_cookbook.dao.UserDAO;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@RequestMapping("user_list")
	public void userList() {
		System.out.println(userDAO.countMinorUsers());
	}

}
