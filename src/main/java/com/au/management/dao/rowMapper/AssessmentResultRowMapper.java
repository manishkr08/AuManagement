package com.au.management.dao.rowMapper;

import com.au.management.model.AssessmentResult;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AssessmentResultRowMapper implements RowMapper<AssessmentResult> {
    @Override
    public AssessmentResult mapRow(ResultSet rs, int rowNum) throws SQLException {
        AssessmentResult result = new AssessmentResult();
        result.setCandidateId(rs.getInt("candidate_id"));
        result.setId(rs.getInt("result_id"));
        result.setMarks(rs.getInt("marks_obtained"));
        result.setFeedback(rs.getString("feedback"));
        return result;
    }
}
