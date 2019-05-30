package com.sms.service;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sms.model.Login;
import com.sms.payload.entry.ApiResponse;
import com.sms.payload.entry.ChangePassword;
import com.sms.payload.entry.VerifyOtpRequest;
import com.sms.repository.LoginRepository;

@Service
public class LoginService {
	
	
	@Autowired
    PasswordEncoder passwordEncoder;
	
	@Autowired
    private JavaMailSender javaMailSender;
	
	@Autowired
	private LoginRepository loginRepository;
	
	public ResponseEntity<?> findUserByMail(String email) throws IOException{
		
		Optional<Login> user = loginRepository.findByEmail(email);
		if(!user.isPresent()) {
			return ResponseEntity.ok(new ApiResponse(false,"We didn't find an account for that e-mail address."));
		}
		else {
			Login forgotPwd = user.get();
			forgotPwd.setResetToken(getRandomIntegerBetweenRange(100000,999999));
//			forgotPwd.setResetToken(UUID.randomUUID().toString());
			loginRepository.save(forgotPwd);
			
			return sendMail(forgotPwd);
		}
		
	}
	
	private Long getRandomIntegerBetweenRange(int min, int max) {
	    double x = (int)(Math.random()*((max-min)+1))+min;
		return ((long)x);
	}

	public ResponseEntity<?> sendMail(Login forgotPwd) throws IOException
	{
		SimpleMailMessage msg = new SimpleMailMessage();

        msg.setSubject("SMS Account");
        msg.setText("Your Reset Password OtP is : "+forgotPwd.getResetToken());
        msg.setTo(forgotPwd.getEmail());
        javaMailSender.send(msg);
		return ResponseEntity.ok(new ApiResponse(true,"Reset Password OTP sent to your mail id "));
	}

	public ResponseEntity<?> resetPassword(Map<String, String> request) {
		Optional<Login> user = loginRepository.findByResetToken(request.get("token"));
		if(user.isPresent()) {
			Login newPwd = user.get();
			newPwd.setPassword(passwordEncoder.encode(request.get("password")));
			newPwd.setResetToken(null);
			loginRepository.save(newPwd);
			return ResponseEntity.ok(new ApiResponse(true,"Your Password was successfuly reset"));

		}
		else {
			return ResponseEntity.ok(new ApiResponse(false,"Oops!  This is an invalid password reset link."));

		}
		
	}

	public ResponseEntity<?> changePassword(ChangePassword changePassword) {
		String oldOne = passwordEncoder.encode(changePassword.getOldPwd());
		Optional<Login> user = loginRepository.findByPasswordAndUsername(oldOne, changePassword.getRollNo());
		if(user.isPresent()) {
			Login newPwd = user.get();
			newPwd.setPassword(changePassword.getNewPwd());
			loginRepository.save(newPwd);
			return ResponseEntity.ok(new ApiResponse(true,"Your Password was successfuly reset"));
		}
		return ResponseEntity.ok(new ApiResponse(false,"Oops! Old password was not wrong"));
	}

	public ResponseEntity<?> verifyOtpRequest(VerifyOtpRequest verifyOtpRequest) {
		
		Optional<Login> verifyOtp = loginRepository.findByEmailAndResetToken(verifyOtpRequest.getEmail(), verifyOtpRequest.getOtp());
		if(verifyOtp.isPresent()) {
			return ResponseEntity.ok(new ApiResponse(true,"OTP is successfully verified"));
		}
		return ResponseEntity.ok(new ApiResponse(false,"OTP is not match what we send"));
	}
	
}
