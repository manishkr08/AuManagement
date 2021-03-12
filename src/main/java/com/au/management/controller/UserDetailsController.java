package com.au.management.controller;

import com.au.management.model.OperationStatus;
import com.au.management.model.UserDetails;
import com.au.management.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RequestMapping("/api/user")
public class UserDetailsController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/{id}")
    public UserDetails getUserDetails(@PathVariable int id) {
        return userDetailsService.getUserDetails(id);
    }

    @GetMapping("/credentials/{email}")
    public UserDetails getUserCredentials(@PathVariable String email) {
        return userDetailsService.getUserCredentials(email);
    }

    @PostMapping("/register")
    public OperationStatus registerUser(@RequestBody UserDetails userDetails) {
        return userDetailsService.registerUser(userDetails);
    }

}
