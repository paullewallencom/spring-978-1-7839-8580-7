package com.spring_cookbook.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring_cookbook.domain.User;

@Controller
public class UserController {
	
	@RequestMapping("/user_list")
	public void userList() {
	}

	@RequestMapping("addUser")
	public String addUser() {
		return "addUser";
	}
	
	@RequestMapping(value="addUser", method=RequestMethod.POST)
	public String addUser(@ModelAttribute User user) {
		System.out.println(user.getFirstName());
		String[] languages = user.getLanguages();
		for (int i = 0; i < languages.length; i++) {
			System.out.println(languages[i]);
		}
		return "redirect:/user_list";
	}
	
	@ModelAttribute("defaultUser")
	public User defaultUser() {
		User user = new User();

		user.setFirstName("Joe");
		
		String[] defaultLanguages = {"English", "French"};
		user.setLanguages(defaultLanguages);

		return user;
	}
	
	@ModelAttribute("languages")
	public Map<String, String>languages() {
		Map<String, String> m = new HashMap<String, String>();
		m.put("en", "English");
		m.put("fr", "French");
		m.put("de", "German");
		m.put("it", "Italian");
		return m;
	}

}
