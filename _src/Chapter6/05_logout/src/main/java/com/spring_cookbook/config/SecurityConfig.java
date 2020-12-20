package com.spring_cookbook.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
    public void configureUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
			.withUser("user1").password("pwd").roles("USER")
			.and()
			.withUser("admin").password("admin_pwd").roles("USER", "ADMIN");
    }
	
	protected void configure(HttpSecurity http) throws Exception { 
		super.configure(http);
		AntPathRequestMatcher pathRequestMatcher = new AntPathRequestMatcher("/logout");
		http.logout().logoutRequestMatcher(pathRequestMatcher);
	}
}

