package com.au.management.dao.impl;

import com.au.management.dao.UserDetailsDao;
import com.au.management.dao.rowMapper.UserDetailsRowMapper;
import com.au.management.model.OperationStatus;
import com.au.management.model.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

    // SQL queries
    private final String SELECT_USER_DETAILS = "SELECT user_id, first_name, last_name, email FROM user_details where user_id = ?";
    private final String GET_USER_CREDENTIALS_BY_EMAIL = "SELECT * FROM user_details where email = ?;";
    private final String COUNT_USER_BY_EMAIL = "SELECT COUNT(*) FROM user_details where email= ?";
    private final String ADD_USER = "insert into user_details (first_name, last_name, email, password) values (?, ?, ?, ?);";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Row mappers
    private UserDetailsRowMapper userDetailsRowMapper = new UserDetailsRowMapper();

    @Override
    public UserDetails selectUserDetails(int id) {
        return jdbcTemplate.queryForObject(SELECT_USER_DETAILS, userDetailsRowMapper, id);
    }

    private boolean checkEmailExists(String email) {
        int count = jdbcTemplate.queryForObject(COUNT_USER_BY_EMAIL,  Integer.class, email);
        return count > 0;
    }

    @Override
    public UserDetails selectUserCredentials(String email) {

        if (checkEmailExists(email)) {
            return jdbcTemplate.queryForObject(GET_USER_CREDENTIALS_BY_EMAIL, userDetailsRowMapper, email);
        } else return null;
    }

    @Override
    public OperationStatus registerUser(UserDetails userDetails) {
        if (checkEmailExists(userDetails.getEmail())) {
            return new OperationStatus(false, "User with same email already exists");
        }

        // else add user to database
        jdbcTemplate.update(ADD_USER, userDetails.getFirstName(), userDetails.getLastName(), userDetails.getEmail(), userDetails.getPassword());

        return new OperationStatus(true, "Registration Successful.");
    }
}
