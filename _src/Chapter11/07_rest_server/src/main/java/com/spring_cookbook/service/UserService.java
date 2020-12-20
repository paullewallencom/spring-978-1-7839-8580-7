package com.spring_cookbook.service;

import java.util.LinkedList;
import java.util.List;

import com.spring_cookbook.domain.User;

public class UserService {

	List<User> userList = new LinkedList<User>();

	public UserService() {
		User user1 = new User(1L, "Merlin", 777);
		userList.add(user1);
		
		User user2 = new User(2L, "Arthur", 123);
		userList.add(user2);
	}
	
	public List<User> findAll() {
		return userList;
	}
	
	public User findUser(Long id) {
		for (User user : userList) {
			if(user.getId().equals(id)) {
				return user;
			}
		}
		return null;
	}
	
}
