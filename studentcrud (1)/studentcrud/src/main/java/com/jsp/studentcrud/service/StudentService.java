package com.jsp.studentcrud.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.studentcrud.Entity.StudentEntity;
import com.jsp.studentcrud.dao.StudentDao;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;
	
	public String insertdata(StudentEntity s) {
	String msg = dao.insertData(s);
	return msg;
	}
	
	public String deletedata(int id) {
	String msg = dao.deletedata(id);
	return msg;
	}
	
	public String updatedata(StudentEntity s, int id) {
	String msg = dao.updatedata(s, id);
	return msg;
	}
	
	public StudentEntity getSingleRecord(int id) {
	StudentEntity s1 = dao.getSingleRecord(id);
	return s1;
	}
	
	public List<StudentEntity> getAllRecords(){
	List<StudentEntity> list = dao.getAllRecord();
	return list;
	}
}


