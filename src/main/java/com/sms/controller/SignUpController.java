package com.sms.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sms.payload.entry.SignUpRequest;
import com.sms.service.SignUpService;

@RestController
public class SignUpController {
	
	
	@Autowired
	private SignUpService signUpService;
	
	@PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
		
		return signUpService.addHods(signUpRequest);   
    }
}
