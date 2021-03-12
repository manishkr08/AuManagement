package com.au.management.dao.impl;

import com.au.management.dao.TagDao;
import com.au.management.dao.rowMapper.TagRowMapper;
import com.au.management.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagDaoImpl implements TagDao {

    private final String SELECT_ALL_TAGS = "select * from tags";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Row mappers
    private TagRowMapper tagRowMapper = new TagRowMapper();

    @Override
    public List<Tag> selectAllTags() {
        return jdbcTemplate.query(SELECT_ALL_TAGS, tagRowMapper);
    }
}
