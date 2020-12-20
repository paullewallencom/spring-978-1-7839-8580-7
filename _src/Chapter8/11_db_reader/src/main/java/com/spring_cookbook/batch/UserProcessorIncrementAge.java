package com.spring_cookbook.batch;

import org.springframework.batch.item.ItemProcessor;

import com.spring_cookbook.domain.User;

public class UserProcessorIncrementAge implements ItemProcessor<User, User> {
	 
	public User process(User user) throws Exception {
		System.out.println("processing user " + user.getFirstName());
		int age = user.getAge();
		age++;
		user.setAge(age);
	    return user;
	}
 
}
