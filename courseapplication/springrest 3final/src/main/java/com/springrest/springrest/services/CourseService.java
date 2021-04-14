package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.dao.BaseWebResponse;
import com.springrest.springrest.entities.Course;

public interface CourseService {
      public List<Course> getCourses();
      public BaseWebResponse<Course> getCourse(long courseId);
      public Course addCourse(Course courseId);
      public Course updateCourse(Course course);
      public void deleteCourse(long parseLong);



}

