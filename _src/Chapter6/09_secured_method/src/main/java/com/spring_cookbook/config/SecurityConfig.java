package com.spring_cookbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
    public void configureUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
			.withUser("user1").password("pwd").roles("USER")
			.and()
			.withUser("admin").password("admin_pwd").roles("USER", "ADMIN");
    }

}

