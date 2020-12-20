package com.spring_cookbook.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring_cookbook.domain.User;

@Repository
public class UserDAO {
	public List<User> findAll() {
		List<User> userList = new LinkedList<User>();
		
		User user1 = new User();
		user1.setFirstName("Scott");
		user1.setLastName("Summers");
		userList.add(user1);
		
		User user2 = new User();
		user2.setFirstName("Alex");
		user2.setLastName("Summers");
		userList.add(user2);

		return userList;
	}
}
