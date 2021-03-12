package com.au.management.dao.rowMapper;

import com.au.management.model.Skill;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SkillRowMapper implements RowMapper<Skill> {
    @Override
    public Skill mapRow(ResultSet rs, int rowNum) throws SQLException {
        Skill skill = new Skill();
        skill.setId(rs.getInt("skill_id"));
        skill.setName(rs.getString("name"));
        return skill;
    }
}
