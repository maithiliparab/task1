package com.jsp.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.rest.entity.Student;
import com.jsp.rest.repository.StudentRepository;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepository repo;

     //get all students
	@GetMapping("/students")
	public List<Student> getAllStudents(){
		List <Student> std=repo.findAll();
		return std;	
	}
	
	//get students by id
	@GetMapping("/students/{id}")
	public Student getStudent(@PathVariable int id) {
		
		Student student=repo.findById(id).get();
		return student;
	}
	
	//insert student
	@PostMapping("/student/add")
	public void createStudent(@RequestBody Student student) {
		repo.save(student);
	}
	
	@PutMapping("/student/update/{id}")
	public Student updateStudent(@PathVariable int id) {
		Student student=repo.findById(id).get();
		student.setAge(24);
		student.setName("manali");
		repo.save(student);
		return student;
		
	}
	
	@DeleteMapping("/student/delete/{id}")
	public void deleteStudent(@PathVariable int id) {
		repo.deleteById(id);
	}
	
}
