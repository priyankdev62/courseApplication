package com.springrest.springrest.dao;


import com.springrest.springrest.entities.Course;
//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface CourseDao extends MongoRepository<Course,Long> {
}
