package com.au.management.dao.rowMapper;

import com.au.management.model.Trainer;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class TrainerRowMapper implements RowMapper<Trainer> {
    @Override
    public Trainer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Trainer trainer = new Trainer();
        trainer.setId(rs.getInt("trainer_id"));
        trainer.setFirstName(rs.getString("first_name"));
        trainer.setLastName(rs.getString("last_name"));
        return trainer;
    }
}
