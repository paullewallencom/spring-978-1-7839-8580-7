package com.spring_cookbook.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring_cookbook.domain.User;

@Repository
public class UserDAO {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;

	public void add(User user) {
		String sql = "insert into user (first_name, age) values (?, ?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getAge());
	}

}
