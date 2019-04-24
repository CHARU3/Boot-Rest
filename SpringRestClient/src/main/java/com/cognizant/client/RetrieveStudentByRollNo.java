package com.cognizant.client;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cognizant.model.StudentModel;

public class RetrieveStudentByRollNo {

	public static void main(String[] args) {

RestTemplate template=new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<StudentModel> request=new HttpEntity<StudentModel>(headers);
		
		String url="http://localhost:8082/student/studentByRollNo/{rollNo}";
		
		ResponseEntity<StudentModel>  response=
				template.exchange(url,HttpMethod.GET,request,StudentModel.class,1001);
		
		StudentModel student=response.getBody();
		System.out.println(student);
		
		

	}

}
