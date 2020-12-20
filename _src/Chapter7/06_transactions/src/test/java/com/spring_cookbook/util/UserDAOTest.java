package com.spring_cookbook.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

import com.spring_cookbook.config.AppConfig;
import com.spring_cookbook.dao.UserDAO;
import com.spring_cookbook.domain.User;

@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class UserDAOTest extends AbstractTransactionalTestNGSpringContextTests  {
	@Autowired
	private UserDAO userDAO;
	
	@Test
	public void testListUsers() {
		List<User> users = userDAO.findAll();
		for (User user : users) {
			System.out.println(user);
		}
	}
}
