package com.example.batchdemo.step1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.batchdemo.model.Student;

@Component
public class Processor2 implements ItemProcessor<Student, Student> {

	static List<Student> updateList = new ArrayList<>();
	static List<Student> deleteList = new ArrayList<>();

	@Override
	public Student process(Student item) throws Exception {
		if ("update".equalsIgnoreCase(item.getOp())) {
			item.setFirstName("Updated : "+ item.getFirstName());
			updateList.add(item);

		} else if ("delete".equalsIgnoreCase(item.getOp())) {
			deleteList.add(item);

		}
		return item;
	}

}
