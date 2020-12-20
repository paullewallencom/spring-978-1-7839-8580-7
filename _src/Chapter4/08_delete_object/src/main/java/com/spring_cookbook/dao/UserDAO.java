package com.spring_cookbook.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring_cookbook.domain.User;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	public void delete(User user) {
		String sql = "delete from user where id=?";
		jdbcTemplate.update(sql, user.getId());
	}

}
