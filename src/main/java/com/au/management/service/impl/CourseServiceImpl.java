package com.au.management.service.impl;

import com.au.management.dao.CourseDao;
import com.au.management.model.Course;
import com.au.management.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Override
    public List<Course> getAllCourses() {
        return courseDao.selectAllCourse();
    }

    @Override
    public Course getCourseById(int id) {
        return courseDao.selectCourseById(id);
    }
}
