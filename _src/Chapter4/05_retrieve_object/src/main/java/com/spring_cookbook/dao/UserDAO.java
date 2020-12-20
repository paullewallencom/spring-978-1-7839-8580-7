package com.spring_cookbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.spring_cookbook.domain.User;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	public User findById(Long id) {
		String sql = "select * from user where id=?";
		User user = jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserMapper());
		return user;
	}

	private class UserMapper implements RowMapper<User> {
		public User mapRow(ResultSet row, int rowNum) throws SQLException {
			User user = new User();

			user.setId(row.getLong("id"));
			user.setFirstName(row.getString("first_name"));
			user.setAge(row.getInt("age"));
			
			return user;
		}
	}

}
