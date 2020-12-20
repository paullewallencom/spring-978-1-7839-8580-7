package com.spring_cookbook.controllers;

import java.util.Date;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;
    
	@RequestMapping("test1")
	public String test1() {
		System.out.println("TestController.test1()");
		try {
			JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
			jobParametersBuilder.addDate("d", new Date());			
			jobLauncher.run(job, jobParametersBuilder.toJobParameters());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("done with job");
		return "test";
	}
	
}
