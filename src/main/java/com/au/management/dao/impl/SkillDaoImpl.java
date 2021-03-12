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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Row mappers
    private SkillRowMapper skillRowMapper = new SkillRowMapper();

    @Override
    public List<Skill> selectAllSkill() {
        return jdbcTemplate.query(SELECT_ALL_SKILLS, skillRowMapper);
    }
}
