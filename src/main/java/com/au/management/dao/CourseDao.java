package com.au.management.dao;

import com.au.management.model.Course;

import java.util.List;

public interface CourseDao {

    List<Course> selectAllCourse();

    Course selectCourseById(int id);
}
