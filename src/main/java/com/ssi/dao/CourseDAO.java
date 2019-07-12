package com.ssi.dao;

import java.util.List;

import javax.persistence.EntityManager;


import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ssi.entity.Course;

@Component
public class CourseDAO {
	
	@Autowired
	private EntityManager entityManager;
	
	public List<Course> getAllCourses(){
		//Session session=entityManager.unwrap(Session.class);
		Query query=entityManager.createQuery("from Course");
		//Query query=session.createQuery("from Course");
		List<Course> courses=query.getResultList();
		return courses;
	}
	
	private Course AddCourse(Course course){
		entityManager.persist(course); 
		return course;
	}
}
