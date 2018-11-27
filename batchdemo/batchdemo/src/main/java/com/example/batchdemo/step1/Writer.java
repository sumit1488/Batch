package com.example.batchdemo.step1;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.batchdemo.model.Student;
import com.example.batchdemo.repo.StudentRepository;

@Component
public class Writer implements ItemWriter<Student> {

	@Autowired
	StudentRepository repo;

	@Override
	public void write(List<? extends Student> items) throws Exception {
		repo.saveAll(items);
			}

}
