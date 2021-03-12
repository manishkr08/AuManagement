package com.au.management.dao.rowMapper;

import com.au.management.model.Tag;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TagRowMapper implements RowMapper<Tag> {
    @Override
    public Tag mapRow(ResultSet rs, int rowNum) throws SQLException {
        Tag tag = new Tag();
        tag.setId(rs.getInt("tag_id"));
        tag.setName(rs.getString("name"));
        return tag;
    }
}
