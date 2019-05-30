package com.sms.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sms.exception.AlreadyExistException;
import com.sms.payload.entry.UserSummary;
import com.sms.security.CurrentUser;
import com.sms.security.UserPrincipal;
import com.sms.service.AmazonClient;

@RestController
@RequestMapping("/hod")
public class HodController {
	
	@Autowired
    private AmazonClient amazonClient;
	
	
	
    private static final Logger logger = LoggerFactory.getLogger(HodController.class);
 
    
    @GetMapping("/me")
    @PreAuthorize("hasRole('ADMIN')")
    public UserSummary getHodDetails(@CurrentUser UserPrincipal currentUser) {
    	logger.info(currentUser.getName());
    	UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName(),currentUser.getEmail(),currentUser.getNewUser());
		return userSummary;
    }

    @Autowired
    HodController(AmazonClient amazonClient) {
        this.amazonClient = amazonClient;
    }

    @PostMapping("/uploadFile")
    public ResponseEntity<?> uploadFile(@CurrentUser UserPrincipal currentUser, @RequestPart(value = "file") MultipartFile file) throws IOException, AlreadyExistException {
    	logger.info(file.getOriginalFilename());
        return amazonClient.uploadFile(file);
    }
    
//    @PostMapping("/sendMail")
//    public void sendMail()
//    {
//    	 SimpleMailMessage msg = new SimpleMailMessage();
//         msg.setTo("vigramanmoorthy@gmail.com");
//
//         msg.setSubject("Testing from Spring Boot");
//         msg.setText("Hello World \n Spring Boot Email");
//
//         javaMailSender.send(msg);
//    }
//    
//    @PostMapping("/readFile")
//    public ResponseEntity<?> readS3File(@RequestParam String s3Url) throws IOException
//    {
//    	System.out.println(s3Url);
//    	return this.amazonClient.reads3FileByUrl(s3Url);
//    }
    
	
}
