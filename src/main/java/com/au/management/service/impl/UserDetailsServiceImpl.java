package com.au.management.service.impl;

import com.au.management.dao.UserDetailsDao;
import com.au.management.model.OperationStatus;
import com.au.management.model.UserDetails;
import com.au.management.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserDetailsDao userDetailsDao;

    @Override
    public UserDetails getUserDetails(int id) {
        return userDetailsDao.selectUserDetails(id);
    }

    @Override
    public UserDetails getUserCredentials(String email) {
        return userDetailsDao.selectUserCredentials(email);
    }

    @Override
    public OperationStatus registerUser(UserDetails userDetails) {
        return userDetailsDao.registerUser(userDetails);
    }
}
