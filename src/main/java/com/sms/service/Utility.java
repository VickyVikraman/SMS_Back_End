package com.sms.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.model.S3Object;
import com.sms.model.Login;

@Service
public class Utility {
	
	public List<Login> readDataFromS3File(S3Object s3object) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(s3object.getObjectContent()));
	    
	    
	    String line = reader.readLine();
	    List<Login> studenLoginList  = new ArrayList<>(); 
	    while((line = reader.readLine()) != null) {
            String[] attributes = line.split(",");
	    	Login studentLogin = new Login();
	    	studentLogin.setUsername(attributes[0]);
	    	studentLogin.setName(attributes[1]);
	    	studentLogin.setPassword(attributes[2]);
	    	studentLogin.setEmail(attributes[3]);
	    	studenLoginList.add(studentLogin);
	    }
	    return studenLoginList;
	}
}
