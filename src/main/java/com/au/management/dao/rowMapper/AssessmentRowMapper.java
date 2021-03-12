package com.au.management.dao.rowMapper;

import com.au.management.model.Assessment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class AssessmentRowMapper implements RowMapper<Assessment> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Assessment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Assessment assessment = new Assessment();
        assessment.setId(rs.getInt("assessment_id"));
        assessment.setName(rs.getString("name"));
        // type
        assessment.setDescription(rs.getString("description"));
        // course
        assessment.setCreatorId(rs.getInt("creator_id"));
        assessment.setMaxMarks(rs.getInt("max_marks"));
        assessment.setVersion(rs.getInt("version"));
        // tags
        // date created
        assessment.setDateModified(rs.getTimestamp("date_modified"));
        // prereqsistes

        // type
        this.

        return assessment;
    }
}
