package com.telusko.SpringJDBCEx.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telusko.SpringJDBCEx.model.Student;
import com.telusko.SpringJDBCEx.repo.StudentRepo;

@Service
public class StudentService {

	
	private StudentRepo repo;
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		repo.save(s);
	}
	public StudentRepo getRepo() {
		return repo;
	}
	
	@Autowired
	public void setRepo(StudentRepo repo) {
		this.repo = repo;
	}
	public List<Student> getStudents() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	
	
}
