package com.sms.payload.entry;

public class VerifyOtpRequest {
	
	private String email;
	
	private Long otp;

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getOtp() {
		return otp;
	}

	public void setOtp(Long otp) {
		this.otp = otp;
	}
	
	
}
