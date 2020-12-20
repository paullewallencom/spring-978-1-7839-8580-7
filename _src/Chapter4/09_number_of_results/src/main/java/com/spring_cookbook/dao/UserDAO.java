package com.spring_cookbook.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	public long countMinorUsers() {
		String sql = "select count(*) from age < 18";
		return jdbcTemplate.queryForObject(sql, Long.class);
	}

}
