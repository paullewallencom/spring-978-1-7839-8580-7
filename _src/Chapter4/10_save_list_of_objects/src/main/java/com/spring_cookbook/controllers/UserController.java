package com.spring_cookbook.controllers;

import java.util.LinkedList;
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
		List<User> userList = new LinkedList<User>();

		User user1 = new User();
		user1.setFirstName("Merlin");
		userList.add(user1);

		User user2 = new User();
		user2.setFirstName("Arthur");
		userList.add(user2);

		userDAO.add(userList);
	}

}
