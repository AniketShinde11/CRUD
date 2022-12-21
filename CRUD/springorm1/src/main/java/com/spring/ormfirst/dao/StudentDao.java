package com.spring.ormfirst.dao;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.ormfirst.entities.Student;

import antlr.collections.List;

public class StudentDao {

	
	private HibernateTemplate hibernateTemplate;
	
	// Create operation
	@Transactional
	public int insert(Student student)
	{
		Integer i=(Integer) this.hibernateTemplate.save(student);
		  return i;
	}

	// get single object
	public Student getStudent(int studentId)
	{
		Student student=this.hibernateTemplate.get(Student.class, studentId);
		return student;
	}
	
	// get all objects
	public java.util.List<Student> getAllStudent()
	{
		java.util.List<Student> students=this.hibernateTemplate.loadAll(Student.class);
		return students;
	}
	 
	 // Delete object
	  @Transactional
	 public void delete(int studentId)
	 {
		 Student student=this.hibernateTemplate.get(Student.class,studentId);
		 this.hibernateTemplate.delete(student);
	 }
	 
	 //Update Object
	  @Transactional
	 public void updateStudent(Student student)
	 {
		 
		 this.hibernateTemplate.update(student);
	 }
	
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	
	
	
	
}
