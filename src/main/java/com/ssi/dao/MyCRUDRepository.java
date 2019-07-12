package com.ssi.dao;

import org.springframework.data.repository.CrudRepository;

import com.ssi.entity.Course;

public interface MyCRUDRepository extends CrudRepository<Course, Integer> {

}
