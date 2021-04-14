package com.springrest.springrest.services.ServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.springrest.springrest.controller.ErrorHandleController;
import com.springrest.springrest.dao.BaseWebResponse;
import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.exception.ErrorCode;
import com.springrest.springrest.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CourseServiceImpl implements CourseService {


    Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);


    @Autowired
    private CourseDao courseDao;
    private BaseWebResponse<Course> baseWebResponse= new BaseWebResponse<Course>();

    ErrorHandleController errorHandleController = new ErrorHandleController();


    //List<Course> list;
    public CourseServiceImpl() {
//        list = new ArrayList<>();
//        list.add(new Course(145,"Java Core Course","this course contains basics of java"));
//        list.add(new Course(4343,"springboot","creating rest api using springboot"));
    }

    @Override
    public List<Course> getCourses(){
        Iterable<Course> courseIterable=courseDao.findAll();
        List<Course> courseList=new ArrayList<>();
        logger.info("courselist here");
        logger.info("using Exception Handling here");
        courseIterable.forEach(courseList::add);
        return  courseList;
    }

    @Override
    public BaseWebResponse<Course> getCourse(long courseId) {

//        Course c=null;
//        for(Course course:list) {
//            if(course.getId()==courseId) {
//                c=course;
//                break;
//            }
//        }
//          return courseDao.f;

       Optional<Course> course = courseDao.findById(courseId);
       logger.info("get course by courseID");
       logger.info("using error handle controller here");

       if (course.isPresent()){
           return baseWebResponse.successWithData(course.get());
       }else {

           return baseWebResponse.error(ErrorCode.ENTITY_NOT_FOUND);
     }
    }
    @Override
    public Course addCourse(Course course) {
//        // TODO Auto-generated method stub
//        list.add(course);

        logger.info("ADD COURSES HERE");
        courseDao.save(course);
        return course;
    }
    @Override
    public Course updateCourse(Course course) {
//        // TODO Auto-generated method stub
//        list.forEach(e -> {
//            if(e.getId() == course.getId()) {
//                e.setTitle(course.getTitle());
//                e.setDescription(course.getDescription());
//            }
//        });

        logger.info("UPDATE COURSE METHOD");
        logger.info("using custom exception in mycontroller");
        courseDao.save(course);
        return  course;
    }
    @Override
    public void deleteCourse(long courseId) {
////        list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
//        Course entity =courseDao.getOne(parseLong);

        logger.info("DELETE COURSES METHOD");
        courseDao.deleteById(courseId);
    }

}
