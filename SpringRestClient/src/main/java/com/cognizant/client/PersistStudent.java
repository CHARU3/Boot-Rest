package com.cognizant.client;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.cognizant.model.StudentModel;

public class PersistStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RestTemplate template=new RestTemplate();
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		StudentModel studentmodel=new StudentModel();
		studentmodel.setRollNo(1005);
		studentmodel.setFirstName("abc");
		studentmodel.setLastName("aaa");
		studentmodel.setAge(22);
		
		HttpEntity<StudentModel> request=new HttpEntity<StudentModel>(headers);
		
		String url="http://localhost:8082/student/persiststudent";
		template.postForLocation(url,request,HttpMethod.POST);                                                         
		
	}

}
