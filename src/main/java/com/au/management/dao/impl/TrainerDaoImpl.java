package com.au.management.dao.impl;

import com.au.management.dao.TrainerDao;
import com.au.management.dao.rowMapper.TrainerRowMapper;
import com.au.management.model.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TrainerDaoImpl implements TrainerDao {

    // SQL queries
    private final String GET_ALL_TRAINERS = "SELECT * FROM trainer_details";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Row mappers
    private TrainerRowMapper trainerRowMapper = new TrainerRowMapper();

    @Override
    public List<Trainer> selectAllTrainers() {
        return jdbcTemplate.query(GET_ALL_TRAINERS, trainerRowMapper);
    }
}
