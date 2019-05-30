package com.sms.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.sms.exception.AlreadyExistException;
import com.sms.model.Login;

@Service
public class AmazonClient {

    private AmazonS3 s3client;

    @Value("${amazonProperties.endpointUrl}")
    private String endpointUrl;
    
    @Value("${amazonProperties.bucketName}")
    private String bucketName;
    
    @Value("${amazonProperties.accessKey}")
    private String accessKey;
    
    @Value("${amazonProperties.secretKey}")
    private String secretKey;
    
    @Autowired
    private Utility utility;
    
    @Autowired
    private SignUpService signUpService;
    
    @SuppressWarnings("deprecation")
	@PostConstruct
    private void initializeAmazon() {
       AWSCredentials credentials = new BasicAWSCredentials(this.accessKey, this.secretKey);
       this.s3client = new AmazonS3Client(credentials);
    }
    
    public ResponseEntity<?> uploadFile(MultipartFile multipartFile) throws IOException, AlreadyExistException {

        String fileUrl = "";
        try {
            File file = convertMultiPartToFile(multipartFile);
            String fileName = generateFileName(multipartFile);
            fileUrl = "SMS/Files/StudentUpload/" + fileName;
            uploadFileTos3bucket(fileName, file);
//            file.delete();
        } catch (Exception e) {
           e.printStackTrace();
        }
        return reads3FileByUrl(fileUrl);
    }
    
    private File convertMultiPartToFile(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
    
    private String generateFileName(MultipartFile multiPart) {
        return new Date().getTime() + "-" + multiPart.getOriginalFilename().replace(" ", "_");
    }
    
    private void uploadFileTos3bucket(String fileName, File file) {
        s3client.putObject(new PutObjectRequest(bucketName+"/SMS/Files/StudentUpload", fileName, file)
                .withCannedAcl(CannedAccessControlList.PublicRead));
    }

	public ResponseEntity<?> reads3FileByUrl(String s3Url) throws IOException, AlreadyExistException {
				
		S3Object s3object = s3client.getObject(bucketName, s3Url);
	    
	    List<Login> studentLoginDetails= utility.readDataFromS3File(s3object);
	   
	    return signUpService.addStudents(studentLoginDetails);
	}
}