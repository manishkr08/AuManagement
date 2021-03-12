package com.au.management.dao.impl;

import com.au.management.dao.AssessmentDao;
import com.au.management.dao.rowMapper.AssessmentResultRowMapper;
import com.au.management.dao.rowMapper.AssessmentRowMapper;
import com.au.management.model.*;
import com.au.management.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;

@Repository
public class AssessmentDaoImpl implements AssessmentDao {

    // Sql queries

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CandidateService candidateService;

    // Row mappers
    private AssessmentRowMapper assessmentRowMapper = new AssessmentRowMapper();
    private AssessmentResultRowMapper assessmentResultRowMapper = new AssessmentResultRowMapper();

    @Override
    public Assessment selectAssessmentById(int id) {
        return null;
    }

    @Override
    public List<Assessment> selectAllAssessment() {
        // get assessment list
        String GET_ALL_ASSESSMENTS = "select * from assessment";
        return jdbcTemplate.query(GET_ALL_ASSESSMENTS, assessmentRowMapper);
    }

    @Override
    public OperationStatus insertNewAssessment(Assessment assessment) {
        // add assessment to database
        String ADD_ASSESSMENT = "insert into assessment (name, type_id, description, course_id, creator_id, max_marks, version, date_modified)values (?, ?, ?, ?, ?, ?, ?, ?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(ADD_ASSESSMENT, new String[]{"assessment_id"});
            ps.setString(1, assessment.getName());
            ps.setInt(2, assessment.getType().getType());
            ps.setString(3, assessment.getDescription());
            ps.setInt(4, assessment.getCourse().getId());
            ps.setInt(5, assessment.getCreatorId());
            ps.setInt(6, assessment.getMaxMarks());
            ps.setInt(7, assessment.getVersion());
            ps.setDate(8, new java.sql.Date(assessment.getDateModified().getTime()));
            return ps;
        }, keyHolder);

        assessment.setId(keyHolder.getKey().intValue());

        // add created-latest version to database
        String ADD_LATEST_VERSION = "insert into assessment_latest_version (assessment_id, latest_version, date_created) values (?, ?, ?);";

        jdbcTemplate.update(ADD_LATEST_VERSION, assessment.getId(), assessment.getVersion(), assessment.getDateCreated());

        // add tags to database
        String ADD_TAG = "insert into assessment_tags (assessment_id, tag_id) values (?, ?)";
        for (Tag tag : assessment.getTags()) {
            jdbcTemplate.update(ADD_TAG, assessment.getId(), tag
                    .getId());
        }

        // add prerequisites to database
        String ADD_PREREQUISITE_SKILL = "insert into assessment_prerequisite_skills (assessment_id, skill_id) values (?, ?)";
        for (Skill skill : assessment.getPrerequisite()) {
            jdbcTemplate.update(ADD_PREREQUISITE_SKILL, assessment.getId(), skill
                    .getId());
        }

        // add test data
        candidateService.takeDummyAssessment(assessment);

        return new OperationStatus(true, "Assessment added successfully.");
    }

    @Override
    public OperationStatus updateAssessment(int id, Assessment assessment) {
        return null;
    }

    @Override
    public OperationStatus deleteAssessment(int id) {

        return new OperationStatus(true, "Assessment deleted successfully.");

    }

    @Override
    public List<AssessmentResult> selectAssesmentResultById(int id) {
        String GET_RESULT_BY_ID = "select * from assessment_result where assessment_id = ?";
        return jdbcTemplate.query(GET_RESULT_BY_ID, assessmentResultRowMapper, id);
    }
}
