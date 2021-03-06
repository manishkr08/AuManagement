package com.au.management.dao.impl;

import com.au.management.dao.CandidateDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CandidateDaoImpl implements CandidateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    //SQl queirs
    private final String INSERT_RESULT_DATA = "insert into assessment_result (candidate_id, assessment_id, marks_obtained, feedback) values (?, ?, ?, ?)";

    @Override
    public void insertDummyData(int candidate, int assessmentId, int marks, String feedback) {
        jdbcTemplate.update(INSERT_RESULT_DATA, candidate, assessmentId, marks, feedback);
    }
}
