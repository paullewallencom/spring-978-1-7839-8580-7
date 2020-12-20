package com.spring_cookbook.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring_cookbook.domain.User;

@Repository
public class UserDAO {

	@Autowired
	SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Transactional
	public void add(User user) {
		getSession().saveOrUpdate(user);
	}


}
