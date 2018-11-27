package com.example.batchdemo.step1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.batchdemo.model.Student;

@Component
public class Processor implements ItemProcessor<Student, Student> {

	
	@Override
	public Student process(Student item) throws Exception {
	
		return item;
	}

}
