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

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // SQL queries
    private final String SELECT_ALL_TAGS = "select * from tags";

    private final String GET_TAGS_BY_ID = "select at.tag_id, t.name from assessment_tags at inner join tags t on at.tag_id = t.tag_id where assessment_id = ?";

    // Row mappers
    @Autowired
    private TagRowMapper tagRowMapper;

    @Override
    public List<Tag> selectAllTags() {
        return jdbcTemplate.query(SELECT_ALL_TAGS, tagRowMapper);
    }

    @Override
    public List<Tag> selectTagByAssessmentId(int id) {
        return jdbcTemplate.query(GET_TAGS_BY_ID, tagRowMapper, id);
    }
}
