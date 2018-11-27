package com.example.batcwwhdemo.batch;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;

import com.example.batchdemo.model.Student;
import com.example.batchdemo.step1.Processor;
import com.example.batchdemo.step1.Processor2;
import com.example.batchdemo.step1.Reader;
import com.example.batchdemo.step1.Writer;
import com.example.batchdemo.step1.Writer2;

@Configuration
@EnableBatchProcessing
public class JobConfiguration extends JobExecutionListenerSupport {

	@Autowired
	JobBuilderFactory jbf;

	@Autowired
	StepBuilderFactory sbf;

	@Autowired
	Writer writer;
	
	@Autowired
	Writer2 writer2;

	@Autowired
	Processor processor;
	
	@Autowired
	Processor2 processor2;

	@Value("${input.file}")
	Resource resource;

	@Bean("job1")
	@Lazy(true)
	public Job studentDataJob() {

		Step step = sbf.get("step-1").<Student, Student>chunk(5).reader(new Reader(resource)).processor(processor)
				.writer(writer).build();

		Job job = jbf.get("job-1").incrementer(new RunIdIncrementer())
				.listener(this).start(step).build();

		return job;
	
	}
	@Bean("job2")
	@Lazy(true)
	public Job studentDataJob2() {

		Step step = sbf.get("step-2").<Student, Student>chunk(5).reader(new Reader(resource)).processor(processor2)
				.writer(writer2).build();

		Job job = jbf.get("job-2").incrementer(new RunIdIncrementer())
				.listener(this).start(step).build();

		return job;
	}	
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		}
	}
}
