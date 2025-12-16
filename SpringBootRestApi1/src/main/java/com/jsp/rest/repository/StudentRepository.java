package com.jsp.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.rest.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findAll();

}
