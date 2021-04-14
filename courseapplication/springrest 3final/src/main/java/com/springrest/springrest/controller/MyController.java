package com.springrest.springrest.controller;
import java.util.List;

import com.springrest.springrest.clients.UserClient;
import com.springrest.springrest.dao.BaseWebResponse;
import com.springrest.springrest.dao.Employee;
import com.springrest.springrest.exception.ApiRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




// Feign Fallback



//*
// Use lombok
// Logging
// Exception Handling
// Error Handler Controller
// Custom Exception

@RestController
public class MyController {

    @Autowired
    private CourseService courseService;

    @Autowired
	private UserClient userClient;

    Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/home")
    public String home() {
		//logger.info("home here");
    	return "Welcome to courses application";
    }

	@GetMapping("/feign")
	public List<Employee> getall(){
		//logger.error("feign dead now");
		return userClient.getAllEmployee();

	}


	@GetMapping("/courses")
	public List<Course> getCourses(){
		logger.info("get all courses here");
		logger.info("using Exception handling here");
    	throw new ApiRequestException("Oops cannont get all Courses");


		//return courseService.getCourses();
	}

	@GetMapping("/courses/{courseId}")
	public BaseWebResponse<Course> getCourse(@PathVariable String courseId) {
		logger.info("using Error Handle Controller here in serviceImpl");
		//throw new CustomException();
		return courseService.getCourse(Long.parseLong(courseId));

	}


	@PostMapping(path="/courses")
	public Course addCourse(@RequestBody Course course) {
		//logger.info("course insertion");
		return courseService.addCourse(course);
	}

	@PutMapping("/courses")
	public Course updateCourse(@RequestBody Course course) throws CustomException
	{
		logger.info("modify course here");
		logger.info("using custom exception here");
		//return courseService.updateCourse(course);
		throw new CustomException();

	}

	@DeleteMapping("/courses/{id}")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable("id") String id){
    	try {
			//logger.error("no such value exist");
			this.courseService.deleteCourse(Long.parseLong(id));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e){
			//logger.info("catching exception here");
    		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}


