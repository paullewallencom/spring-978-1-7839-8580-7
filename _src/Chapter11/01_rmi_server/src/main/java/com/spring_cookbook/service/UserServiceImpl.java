package com.spring_cookbook.service;

import java.util.LinkedList;
import java.util.List;

import com.spring_cookbook.domain.User;

public class UserServiceImpl implements UserService {

	List<User> userList = new LinkedList<User>();

	public UserServiceImpl() {
		User user1 = new User("Merlin", 777);
		userList.add(user1);
		
		User user2 = new User("Arthur", 123);
		userList.add(user2);
	}
	
	public List<User> findAll() {
		return userList;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}
	
}
