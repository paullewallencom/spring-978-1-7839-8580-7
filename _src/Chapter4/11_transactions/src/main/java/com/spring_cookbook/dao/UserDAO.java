package com.spring_cookbook.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring_cookbook.domain.User;

@Repository
@Transactional
public class UserDAO {
	
    @Autowired
    private JdbcTemplate jdbcTemplate;
	
	public void performSeveralQueries() {
		User user = new User();
		
		user.setFirstName("test1");
		user.setAge(15);
		this.add(user);
		
		if(true) {
			//throw new RuntimeException("A runtime exception");			
		}

		user.setFirstName("test2");
		user.setAge(18);
		this.add(user);

    }
    
	public void add(User user) {
		String sql = "insert into user (first_name, age) values (?, ?)";
		jdbcTemplate.update(sql, user.getFirstName(), user.getAge());
	}
}
