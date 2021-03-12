package com.au.management.service;

import com.au.management.model.Course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(int id);
}
