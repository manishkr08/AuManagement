package com.au.management.dao.impl;

import com.au.management.dao.SkillDao;
import com.au.management.dao.rowMapper.SkillRowMapper;
import com.au.management.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SkillDaoImpl  implements SkillDao {

    // SQL queries
    private final String SELECT_ALL_SKILLS = "select * from skills";

    private final String SELECT_SKILL_BY_ASSESSMENT_ID = "select aps.skill_id, s.name from assessment_prerequisite_skills aps inner join skills s on aps.skill_id = s.skill_id where assessment_id = ?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Row mappers
    @Autowired
    private SkillRowMapper skillRowMapper;

    @Override
    public List<Skill> selectAllSkill() {
        return jdbcTemplate.query(SELECT_ALL_SKILLS, skillRowMapper);
    }

    @Override
    public List<Skill> selectSkillByAssessmentId(int id) {
        return jdbcTemplate.query(SELECT_SKILL_BY_ASSESSMENT_ID, skillRowMapper, id);
    }
}
