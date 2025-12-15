package com.jsp.studentcrud.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.studentcrud.Entity.StudentEntity;
import com.jsp.studentcrud.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	@PostMapping("/saveinfo")
	public String insertData(@RequestBody StudentEntity s) {
	String msg = service.insertdata(s);
	return msg;
	}
	
	@DeleteMapping("/deleteinfo/{id}")
	public String deletedata(@PathVariable int id) {
	String msg = service.deletedata(id);
	return msg;
	}
	
	@PutMapping("/updateinfo/{id}")
	public String updatedata(@RequestBody StudentEntity s, @PathVariable int id) {
	String msg = service.updatedata(s, id);
	return msg;
	}
	
	@GetMapping("/getSingleRecord/{Employee_id}")
	public StudentEntity getSingleRecore(@PathVariable int id) {
	StudentEntity s1 = service.getSingleRecord(id);
	return s1;
	}
	
	@GetMapping("/getAllRecords")
	public List<StudentEntity> getAllRecords(){
	List<StudentEntity> list = service.getAllRecords();
	return list;
	
}
}
