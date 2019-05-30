package com.sms.controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sms.payload.entry.ChangePassword;
import com.sms.payload.entry.JwtAuthenticateResponse;
import com.sms.payload.entry.LoginRequest;
import com.sms.payload.entry.VerifyOtpRequest;
import com.sms.security.JwtTokenProvider;
import com.sms.service.LoginService;

@RestController
public class LoginController {
	
    @Autowired
    AuthenticationManager authenticationManager;
    
    @Autowired
    JwtTokenProvider tokenProvider;
    
    @Autowired
    private LoginService loginService;
	
	@PostMapping("/hod/signin")
    public ResponseEntity<?> authenticateHod(@Valid @RequestBody LoginRequest loginRequest) {
		
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticateResponse(jwt));
    }
	
	@PostMapping("/student/signin")
    public ResponseEntity<?> authenticateStudent(@Valid @RequestBody LoginRequest loginRequest) {
		
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticateResponse(jwt));
    }
	
	@GetMapping("/forgotPwd")
	public ResponseEntity<?> forgotPassword(@RequestParam("email") String email) throws IOException, ParseException{
		
		return loginService.findUserByMail(email);
		
	}
	
	@PostMapping("/verifyOtpReqst")
	public ResponseEntity<?> verifyOtp(@RequestBody VerifyOtpRequest verifyOtpRequest){
		
		return loginService.verifyOtpRequest(verifyOtpRequest);
	}
	
	@PostMapping("/reset")
	public ResponseEntity<?> setNewPassword(@RequestParam Map<String, String > request){
		
		return loginService.resetPassword(request);
	}
	
	@PostMapping("/changePwd")
	public ResponseEntity<?> changePassword(@RequestBody ChangePassword changePassword){
		return loginService.changePassword(changePassword);
	}
 
	
	
}
