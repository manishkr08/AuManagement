package com.au.management.dao.impl;

import com.au.management.dao.CourseDao;
import com.au.management.dao.rowMapper.CourseRowMapper;
import com.au.management.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao {

    // Sql queries
    private final String GET_ALL_COURSE = "select * from course";
    private final String GET_COURSE_BY_ID = "select * from course where course_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Row mappers
    @Autowired
    private CourseRowMapper courseRowMapper;

    @Override
    public List<Course> selectAllCourse() {
        return jdbcTemplate.query(GET_ALL_COURSE, courseRowMapper);
    }

    @Override
    public Course selectCourseById(int id) {
        return jdbcTemplate.queryForObject(GET_COURSE_BY_ID, courseRowMapper, id);
    }
}
