package com.spring_cookbook.dao;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

@Service
public class UserDAO {

	@Secured("ADMIN")
	public void test() {
		System.out.println("secured method");
	}	
}
