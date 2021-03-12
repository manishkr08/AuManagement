package com.au.management.dao.rowMapper;

import com.au.management.dao.SkillDao;
import com.au.management.dao.TagDao;
import com.au.management.model.Assessment;
import com.au.management.model.Course;
import com.au.management.model.enums.AssessmentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class AssessmentRowMapper implements RowMapper<Assessment> {

    @Autowired
    private TagDao tagDao;

    @Autowired
    private SkillDao skillDao;

    @Override
    public Assessment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Assessment assessment = new Assessment();
        assessment.setId(rs.getInt("assessment_id"));
        assessment.setName(rs.getString("name"));
        assessment.setType(AssessmentType.valueOf(rs.getString("course_type_name")));
        assessment.setDescription(rs.getString("description"));

        // course
        Course course = new Course();
        course.setId(rs.getInt("course_id"));
        course.setName(rs.getString("course_name"));
        course.setTrainerId(rs.getInt("trainer_id"));
        assessment.setCourse(course);

        assessment.setCreatorId(rs.getInt("creator_id"));
        assessment.setMaxMarks(rs.getInt("max_marks"));

        // tags
        assessment.setTags(tagDao.selectTagByAssessmentId(assessment.getId()));

        assessment.setDateCreated(rs.getTimestamp("date_created"));
        assessment.setDateModified(rs.getTimestamp("date_modified"));
        // prereqsistes
        assessment.setPrerequisite(skillDao.selectSkillByAssessmentId(assessment.getId()));

        return assessment;
    }
}
