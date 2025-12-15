package com.jsp.studentcrud.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.studentcrud.Entity.StudentEntity;

import jakarta.persistence.Query;

import org.hibernate.Transaction;

import java.util.List;

//import jakarta.transaction.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@Repository
public class StudentDao {
	
	@Autowired
	SessionFactory factory;
	
	public String insertData(StudentEntity s) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		ss.persist(s);
		
		tr.commit();
		ss.close();
		return "Data is Inserted...";
	}
	
	public String deletedata(int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		StudentEntity s = ss.get(StudentEntity.class, id);
		ss.remove(s);
		
		tr.commit();
		ss.close();
		return "Data is Deleted...";
	}

	
	public String updatedata(StudentEntity s, int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		StudentEntity s1 = ss.get(StudentEntity.class,id);
		
	//	e1.setEmployee_id(e.getEmployee_id());
		s1.setName(s1.getName());
		s1.setId(s1.getId());
		s1.setAge(s1.getAge());
		
		ss.merge(s1);
		tr.commit();
		ss.close();
		return "Data is Updated";
		
	}
	
	public StudentEntity getSingleRecord(int id) {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		StudentEntity s1 = ss.get(StudentEntity.class,id);
		
		tr.commit();
		ss.close();
		return s1;
	}
	
	public List<StudentEntity> getAllRecord() {
		Session ss = factory.openSession();
		Transaction tr = ss.beginTransaction();
		String hql = "from StudentEntity";
		Query query = ss.createQuery(hql, StudentEntity.class);
		List<StudentEntity> list = query.getResultList();
		
		tr.commit();
		ss.close();
		return list;
	}
	
}


}
