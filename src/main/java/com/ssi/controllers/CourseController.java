package com.ssi.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssi.dao.CourseDAO;
import com.ssi.dao.MyCRUDRepository;
import com.ssi.entity.Course;

@RestController
@RequestMapping("apis")
public class CourseController {
	
	@Autowired
	private MyCRUDRepository repo;
	
	@Autowired
	private CourseDAO courseDAO;
	
	@RequestMapping("courses")
	public List<Course> showAllCourses(){
		return courseDAO.getAllCourses();
		//return (List<Course>) repo.findAll();
	}
	
	@PostMapping("course")
	public Course addNewCourse(@RequestBody Course course){
		repo.save(course);
		return course;
	}
	
	@PutMapping("course")
	public Course updateCourse(@RequestBody Course course){
		repo.save(course);
		return course;
	}
	
	@DeleteMapping("course/{id}")
	public String removeCourse(@PathVariable("id") int code){
		repo.deleteById(code);
		return "SUCCESS";
	}
	
	@GetMapping("course/{id}")
	public Optional<Course> singleCourse(@PathVariable("id") int code){
		Optional<Course> course=repo.findById(code);
		return course;
	}
	
	
}
