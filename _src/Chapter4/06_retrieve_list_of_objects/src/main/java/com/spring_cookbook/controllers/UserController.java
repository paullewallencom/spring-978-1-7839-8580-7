package com.spring_cookbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring_cookbook.dao.UserDAO;
import com.spring_cookbook.domain.User;

@Controller
public class UserController {
	@Autowired
	private UserDAO userDAO;

	@RequestMapping("user_list")
	public void userList() {
		List<User> userList = userDAO.findAll();
		for (User user : userList) {
			System.out.println(user.getFirstName());
			System.out.println(user.getAge());			
		}
	}

}
