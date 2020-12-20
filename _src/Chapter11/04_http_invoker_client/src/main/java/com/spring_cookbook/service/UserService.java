package com.spring_cookbook.service;

import java.util.List;

import com.spring_cookbook.domain.User;

public interface UserService {

	public abstract List<User> findAll();

	public abstract void addUser(User user);

}