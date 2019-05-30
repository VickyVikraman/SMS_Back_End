package com.sms.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.payload.entry.UserSummary;
import com.sms.security.CurrentUser;
import com.sms.security.UserPrincipal;

@RestController
@RequestMapping("/student")
public class StudentController {
	
	
	@GetMapping("/me")
	@PreAuthorize("hasRole('STUDENT')")
    public UserSummary getStudentDetails(@CurrentUser UserPrincipal currentUser) {
    	System.out.println(currentUser.getName());
    	System.out.println(currentUser.getNewUser());
    	UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName(),currentUser.getEmail(),currentUser.getNewUser());
		return userSummary;
    }
	
	
}
