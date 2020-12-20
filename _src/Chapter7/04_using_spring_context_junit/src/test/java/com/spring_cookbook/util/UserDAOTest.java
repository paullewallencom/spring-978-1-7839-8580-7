package com.spring_cookbook.util;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.spring_cookbook.config.AppConfig;
import com.spring_cookbook.dao.UserDAO;
import com.spring_cookbook.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class UserDAOTest {
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
