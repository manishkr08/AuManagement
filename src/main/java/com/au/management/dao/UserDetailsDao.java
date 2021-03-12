package com.au.management.dao;

import com.au.management.model.OperationStatus;
import com.au.management.model.UserDetails;

public interface UserDetailsDao {

    UserDetails selectUserDetails(int id);

    UserDetails selectUserCredentials(String email);

    OperationStatus registerUser(UserDetails userDetails);
}
