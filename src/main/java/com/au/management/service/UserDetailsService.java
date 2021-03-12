package com.au.management.service;

import com.au.management.model.OperationStatus;
import com.au.management.model.UserDetails;

public interface UserDetailsService {

    UserDetails getUserDetails(int id);

    UserDetails getUserCredentials(String email);

    OperationStatus registerUser(UserDetails userDetails);
}
