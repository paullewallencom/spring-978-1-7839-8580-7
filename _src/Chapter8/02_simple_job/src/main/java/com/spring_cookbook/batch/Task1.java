package com.spring_cookbook.batch;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
 
public class Task1 implements Tasklet {
	
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext)
            throws Exception {
        System.out.println("Starting job..");

        // ... your code
        
        System.out.println("Job done..");
        return RepeatStatus.FINISHED;
    }

}