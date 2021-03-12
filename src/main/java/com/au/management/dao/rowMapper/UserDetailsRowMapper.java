package com.au.management.dao.rowMapper;

import com.au.management.model.UserDetails;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserDetailsRowMapper implements RowMapper<UserDetails> {
    @Override
    public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
        UserDetails userDetails = new UserDetails();
        userDetails.setId(rs.getInt("user_id"));
        userDetails.setFirstName(rs.getString("first_name"));
        userDetails.setLastName(rs.getString("last_name"));
        userDetails.setEmail(rs.getString("email"));
        userDetails.setPassword(rs.getString("password"));
        return userDetails;
    }
}
