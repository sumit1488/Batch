package com.example.batchdemo;

import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ComponentScan({"com.example"})
public class BatchdemoApplication {

	
	
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		SpringApplication.run(BatchdemoApplication.class, args);
		
		System.out.println("======================= Application Context created ... Now starting JOB ==================");
	}
	
	/*@Scheduled(cron = "0 *1 * * * ?")
    public void perform() throws Exception
    {	
		
        JobParameters params = new JobParametersBuilder()
                .addString("JobID", String.valueOf(System.currentTimeMillis()))
                .toJobParameters();
        jobLaunch.run(job1, params);
        
    
        jobLaunch.run(job2, params);
    }*/
}
