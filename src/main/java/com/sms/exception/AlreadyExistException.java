package com.sms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sms.payload.entry.ApiResponse;

@ResponseStatus(HttpStatus.CONFLICT)
public class AlreadyExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5668790716457975907L;
	String value, message;
	public AlreadyExistException(String value, String message) {
		this.value=value;
		this.message=message;
	}
	
	public AlreadyExistException(ApiResponse apiResponse) {
		
	}
	
	public String toString() {
		return this.message+" " +this.value;
	}

}
