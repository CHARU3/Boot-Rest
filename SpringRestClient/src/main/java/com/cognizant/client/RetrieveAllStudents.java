package com.cognizant.client;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.cognizant.model.StudentModel;

public class RetrieveAllStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestTemplate template=new RestTemplate();
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<List<StudentModel>> request=new HttpEntity<List<StudentModel>>(headers);
		
		String url="http://localhost:8082/student/allstudents";
		
		ResponseEntity<StudentModel[]>  response=
				template.exchange(url,HttpMethod.GET,request,StudentModel[].class);
		
		StudentModel students[]=response.getBody();
		for(StudentModel student:students){
			System.out.println(student);
		}
		
	}

}
