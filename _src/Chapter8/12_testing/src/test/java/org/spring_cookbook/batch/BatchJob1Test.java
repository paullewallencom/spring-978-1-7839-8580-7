package org.spring_cookbook.batch;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring_cookbook.batch.BatchConfig;
import com.spring_cookbook.batch.Task1;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {BatchConfig.class})
public class BatchJob1Test {
	@Autowired
    private JobLauncherTestUtils jobLauncherTestUtils;


	@Test
	public void testJob() throws Exception {
		JobExecution jobExecution = jobLauncherTestUtils.launchJob();
        Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
        Assert.assertEquals(1, jobExecution.getStepExecutions().size());
	}

	@Test
	public void testStep() throws Exception {
        JobExecution jobExecution = jobLauncherTestUtils.launchStep("step1");
        Assert.assertEquals(ExitStatus.COMPLETED, jobExecution.getExitStatus());
	}
	
	@Test
	public void testTasklet() throws Exception {
		Task1 task1 = new Task1();
		Assert.assertEquals(RepeatStatus.FINISHED, task1.execute(null, null));	
	}

	
}
