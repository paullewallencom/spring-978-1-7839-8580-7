package com.spring_cookbook.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring_cookbook.domain.User;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	public List<User> findAll() {
		String sql = "select * from user";
		List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));
		return userList;
	}
}
