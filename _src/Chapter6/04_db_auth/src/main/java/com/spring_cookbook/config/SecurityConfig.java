package com.spring_cookbook.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired 
	public void configure(AuthenticationManagerBuilder auth) throws Exception { 
	    auth.jdbcAuthentication() 
	            .dataSource(dataSource()) 
	            .usersByUsernameQuery( 
	                    "select username,password,enabled from users where username=?") 
	            .authoritiesByUsernameQuery( 
	                    "select username,authority from authorities where username=?"); 
	} 

	@Bean 
	public DataSource dataSource() { 
	        DriverManagerDataSource dataSource = new DriverManagerDataSource(); 
	         
	        dataSource.setDriverClassName("com.mysql.jdbc.Driver"); 
	        dataSource.setUrl("jdbc:mysql://localhost:3306/db1"); 
	        dataSource.setUsername("root"); 
	        dataSource.setPassword("123"); 
	          
	        return dataSource; 
	}

	@Bean 
	public DataSourceTransactionManager transactionManager() { 
	    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager(); 
	    transactionManager.setDataSource(dataSource()); 
	    return transactionManager; 
	}
	
}

