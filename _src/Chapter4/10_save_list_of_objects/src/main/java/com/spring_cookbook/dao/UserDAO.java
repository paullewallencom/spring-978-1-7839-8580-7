package com.spring_cookbook.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring_cookbook.domain.User;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	public void add(List<User> userList) {
		String sql = "insert into user (first_name, age) values (?, ?)";
		
		List<Object[]> userRows = new ArrayList<Object[]>();
		for (User user : userList) {
	        userRows.add(new Object[] {user.getFirstName(), user.getAge()});
		}
		
		jdbcTemplate.batchUpdate(sql, userRows);
	}

}
