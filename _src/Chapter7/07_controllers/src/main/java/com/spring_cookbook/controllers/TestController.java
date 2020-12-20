package com.spring_cookbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {
	
	@RequestMapping("concat")
	public String concat(@RequestParam String a, @RequestParam String b, Model model) {
		String result = a + b;
		model.addAttribute("result", result);
		return "concat";
	}
}
