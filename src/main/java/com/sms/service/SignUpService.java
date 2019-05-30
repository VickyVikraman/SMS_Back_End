package com.sms.service;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sms.exception.AlreadyExistException;
import com.sms.exception.AppException;
import com.sms.model.Login;
import com.sms.model.Role;
import com.sms.model.RoleName;
import com.sms.payload.entry.ApiResponse;
import com.sms.payload.entry.SignUpRequest;
import com.sms.repository.LoginRepository;
import com.sms.repository.RoleRepository;

@Service
public class SignUpService {
	
	@Autowired
	LoginRepository loginRepository;
	
	@Autowired
    PasswordEncoder passwordEncoder;
		
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
    private static final Logger logger = LoggerFactory.getLogger(SignUpService.class);


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ResponseEntity<?> addHods(SignUpRequest signUpRequest) {
		
		if(loginRepository.existsByUsername(signUpRequest.getUsername())) {
			
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        Login user = new Login(signUpRequest.getName(), signUpRequest.getUsername(),
        		signUpRequest.getPassword(),signUpRequest.getEmail(), signUpRequest.getNewUser());

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        Role userRole = roleRepository.findByName(RoleName.ROLE_ADMIN).orElseThrow(() -> new AppException("User Role Not set"));

        user.setRoles(Collections.singleton(userRole));

        Login result = loginRepository.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/api/users/{username}")
                .buildAndExpand(result.getUsername()).toUri();
        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
	}
	
	public ResponseEntity<?> addStudents(@Valid List<Login> studentLoginDetails) throws AlreadyExistException {
		
		List<String> existsRollNo =  new ArrayList<String>();
		
		String rollNo;
        List<String> emailList = new ArrayList<String>();
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setSubject("SMS Account");
        msg.setText("Your Account is Ready! ");
        
		try {
			for (Login studentLogin : studentLoginDetails) {
					rollNo = studentLogin.getUsername();
					if(loginRepository.existsByUsername(rollNo)) {
						existsRollNo.add(rollNo);
						continue;
			        }
			        Login student = new Login();
			        student.setUsername(studentLogin.getUsername());
			        student.setName(studentLogin.getName());
			        student.setEmail(studentLogin.getEmail());
			        emailList.add(studentLogin.getEmail());
			        student.setPassword(passwordEncoder.encode(studentLogin.getPassword()));
			        
			        Role userRole = roleRepository.findByName(RoleName.ROLE_STUDENT).orElseThrow(() -> new AppException("User Role Not set"));

			        student.setRoles(Collections.singleton(userRole));
			        
			        loginRepository.save(student);
			}
	        msg.setTo(emailList.toArray(new String[0]));
	        javaMailSender.send(msg);
			if(existsRollNo.size()!=0) {
				throw new AlreadyExistException(existsRollNo.toString(),"This RollNo are already Exists");
			}
		}
		catch(AlreadyExistException ex) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ApiResponse(false,"This RollNo are already Exists"+existsRollNo.toString()));
		}
		catch(Exception ex) {
			logger.error(ex.toString());
		}
		
		return ResponseEntity.ok(new ApiResponse(true,"Successfully Registered for Students"));
	}
	
	
}
