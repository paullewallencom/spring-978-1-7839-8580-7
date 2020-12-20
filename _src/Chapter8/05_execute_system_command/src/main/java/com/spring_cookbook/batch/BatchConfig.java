package com.spring_cookbook.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.SystemCommandTasklet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobs;

	@Autowired
	private StepBuilderFactory steps;
    
    @Bean
    public Job job1(){
        return jobs.get("job1")
                .start(step1())
                .build();
    }
           
	@Bean
	public Step step1(){
	    return steps.get("step1")
	            .tasklet(task1())
	            .build();
	}
	
	@Bean
	public SystemCommandTasklet task1() {
		SystemCommandTasklet tasklet = new SystemCommandTasklet();

		tasklet.setCommand("touch test.txt");
		tasklet.setWorkingDirectory("/vagrant/src/08_batch/02_simple_job");
		tasklet.setTimeout(5000);
		
		return tasklet;
	}
	
}
   