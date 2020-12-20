package com.spring_cookbook.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.spring_cookbook.config.AppConfig;

@ContextConfiguration(classes = {AppConfig.class})
@WebAppConfiguration
public class TestControllerTest extends AbstractTestNGSpringContextTests {
	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@BeforeMethod
	public void setup() {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	
	@Test
	public void concat() throws Exception {
	    this.mockMvc.perform(post("/concat").param("a", "red").param("b", "apple"))
	    .andExpect(status().isOk())
	    .andExpect(model().attribute("result", "redapple"))
	    .andExpect(forwardedUrl("/WEB-INF/jsp/concat.jsp"));
	}
}
