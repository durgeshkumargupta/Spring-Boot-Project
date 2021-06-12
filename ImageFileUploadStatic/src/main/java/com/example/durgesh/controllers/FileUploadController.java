package com.example.durgesh.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.durgesh.helper.FileUploadHelper;

@RestController
public class FileUploadController
{
	@Autowired
	private FileUploadHelper fileUploadHelper;
	
	@PostMapping("/upload-file")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file)
	{
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getSize());
		System.out.println(file.getContentType());
		System.out.println(file.getName());
		
		try 
		{
			if(file.isEmpty())
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("File is Not select");
			if(!file.getContentType().equalsIgnoreCase("image/jpeg"))
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only image and JPEG file are allowed");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			
		boolean f=fileUploadHelper.uploadFile(file); 
		if(f)
			return ResponseEntity.ok("File Upload successfully");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Some went wrong ! try again");
	}

}
