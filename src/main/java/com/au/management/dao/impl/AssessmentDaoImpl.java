package com.au.management.dao.impl;

import com.au.management.dao.AssessmentDao;
import com.au.management.dao.SkillDao;
import com.au.management.dao.TagDao;
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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private TagDao tagDao;

    @Autowired
    private SkillDao skillDao;

    // Sql queries
    private final String GET_ALL_ASSESSMENTS = "select a.assessment_id, a.name, a.type_id, at.name as course_type_name, description, a.course_id, c.name as course_name,c.trainer_id,creator_id,max_marks,date_created,date_modified from assessment a inner join assessment_type at on a.type_id = at.type_id inner join course c on c.course_id = a.course_id";

    private final String ADD_ASSESSMENT = "insert into assessment (name, type_id, description, course_id, creator_id, max_marks, date_modified, date_created)values (?, ?, ?, ?, ?, ?, ?, ?)";

    private final String ADD_TAG = "insert into assessment_tags (assessment_id, tag_id) values (?, ?)";

    private final String ADD_PREREQUISITE_SKILL = "insert into assessment_prerequisite_skills (assessment_id, skill_id) values (?, ?)";

    private final String GET_RESULT_BY_ID = "select * from assessment_result where assessment_id = ?";

    private final String DELETE_ASSESSMENT_BY_ID = "delete from assessment where assessment_id = ?";

    private final String DELETE_SKILLS_BY_ASSESSMENT_ID = "delete from assessment_prerequisite_skills where assessment_id = ?";

    private final String DELETE_TAGS_BY_ASSESSMENT_ID = "delete from assessment_tags where assessment_id = ?";

    private final String DELETE_RESULT_BY_ASSESSMENT_ID = "delete from assessment_result where assessment_id = ?";

    private final String UPDATE_ASSESSMENT_BY_ID = "update assessment set name = ?, type_id = ?, description = ?, course_id = ?, max_marks = ?, date_modified = ? where assessment_id = ?";

    // Row mappers
    @Autowired
    private AssessmentRowMapper assessmentRowMapper;

    @Autowired
    private AssessmentResultRowMapper assessmentResultRowMapper;

    @Override
    public Assessment selectAssessmentById(int id) {
        return null;
    }

    @Override
    public List<Assessment> selectAllAssessment() {
        // get assessment list
        return jdbcTemplate.query(GET_ALL_ASSESSMENTS, assessmentRowMapper);
    }

    @Override
    public OperationStatus insertNewAssessment(Assessment assessment) {
        // add assessment to database
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con -> {
            PreparedStatement ps = con.prepareStatement(ADD_ASSESSMENT, new String[]{"assessment_id"});
            ps.setString(1, assessment.getName());
            ps.setInt(2, assessment.getType().getType());
            ps.setString(3, assessment.getDescription());
            ps.setInt(4, assessment.getCourse().getId());
            ps.setInt(5, assessment.getCreatorId());
            ps.setInt(6, assessment.getMaxMarks());
            ps.setDate(7, new java.sql.Date(assessment.getDateModified().getTime()));
            ps.setDate(8, new java.sql.Date(assessment.getDateCreated().getTime()));
            return ps;
        }, keyHolder);

        assessment.setId(keyHolder.getKey().intValue());

        // add tags to database
        assessment.getTags().forEach(tag -> {
            jdbcTemplate.update(ADD_TAG, assessment.getId(), tag.getId());
        });

        // add prerequisites to database
        assessment.getPrerequisite().forEach(skill -> {
            jdbcTemplate.update(ADD_PREREQUISITE_SKILL, assessment.getId(), skill.getId());
        });

        // add dummy result data
        candidateService.takeDummyAssessment(assessment);

        return new OperationStatus(true, "Assessment added successfully.");
    }

    @Override
    public OperationStatus updateAssessment(int id, Assessment assessment) {
        // upadate assessment details
        jdbcTemplate.update(UPDATE_ASSESSMENT_BY_ID, assessment.getName(), assessment.getType().getType(), assessment.getDescription(), assessment.getCourse().getId(), assessment.getMaxMarks(), assessment.getDateModified(), id);

        // update tag details
        // for each if it does not exists, add
        List<Tag> tagsInDB = tagDao.selectTagByAssessmentId(id);
        assessment.getTags().forEach(tag -> {
            tagsInDB.forEach(tagDB -> {

            });
        });

        // update skills details
        // for skill if it does not exists, add

        // update marks as they can be changed

        return new OperationStatus(true, "Assessment updated successfully.");
    }

    @Override
    public OperationStatus deleteAssessment(int id) {
        // delete results
        jdbcTemplate.update(DELETE_RESULT_BY_ASSESSMENT_ID, id);

        // delete tags
        jdbcTemplate.update(DELETE_TAGS_BY_ASSESSMENT_ID, id);

        // delete skills
        jdbcTemplate.update(DELETE_SKILLS_BY_ASSESSMENT_ID, id);

        // delete from assessment table
        jdbcTemplate.update(DELETE_ASSESSMENT_BY_ID, id);

        return new OperationStatus(true, "Assessment deleted successfully.");

    }

    @Override
    public List<AssessmentResult> selectAssesmentResultById(int id) {

        return jdbcTemplate.query(GET_RESULT_BY_ID, assessmentResultRowMapper, id);
    }
}
