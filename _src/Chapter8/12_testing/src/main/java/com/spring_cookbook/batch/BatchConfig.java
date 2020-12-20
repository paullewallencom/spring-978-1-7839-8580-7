package com.spring_cookbook.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;
	
	@Bean
	public JobLauncherTestUtils jobLauncherTestUtils() {
		JobLauncherTestUtils jobLauncherTestUtils = new JobLauncherTestUtils();
		return jobLauncherTestUtils;
	}
	
    @Bean
    public Job job1(){
        return jobs.get("job1")
                .start(step1())
                .build();
    }
           
	@Bean
	public Step step1(){
	    return steps.get("step1")
	            .tasklet(new Task1())
	            .build();
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
	
}
   