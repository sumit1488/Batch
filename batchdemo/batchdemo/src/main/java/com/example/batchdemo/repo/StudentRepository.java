package com.example.batchdemo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.batchdemo.model.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{

	
}
