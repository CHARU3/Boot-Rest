package com.cognizant.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.model.StudentModel;
import com.cognizant.service.StudentService;

@RestController
@RequestMapping("student")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("allstudents")
	public ResponseEntity<List<StudentModel>> getAllStudents(){
		
		List<StudentModel> students=studentService.getAllStudents();
		ResponseEntity<List<StudentModel>> response=new ResponseEntity<List<StudentModel>>(students,HttpStatus.OK);
		
		return response;
		
	}
	
	@GetMapping("studentByRollNo/{rollNo}")
	public ResponseEntity<StudentModel> getStudent(@PathVariable("rollNo")int rollNo){
		StudentModel student=studentService.getStudentByRollNo(rollNo);
		ResponseEntity<StudentModel> response=null;
		
		if(student.getRollNo()==0){
			StudentModel studentNotFound=new StudentModel();
			response=new ResponseEntity<StudentModel>(studentNotFound,HttpStatus.NOT_FOUND);
		}else
		{
			response=new ResponseEntity<StudentModel>(student,HttpStatus.OK);
		}
		
		return response;
		
	}
	
	@PostMapping("persiststudent")
	public ResponseEntity<Void> persistStudent(@RequestBody StudentModel student ){
		
		ResponseEntity<Void> response=null;
		boolean result=studentService.persistStudentModel(student);
		if(result)
		{
			response=new ResponseEntity<Void>(HttpStatus.CREATED);
			
		}else
		{
			response=new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		return response;
	}
	
	@PutMapping("updatestudent")
	public ResponseEntity<Void> updateStudent(@RequestBody StudentModel student ){
		
		ResponseEntity<Void> response=null;
		boolean result=studentService.updateStudentModelAge(student);
		if(result)
		{
			response=new ResponseEntity<Void>(HttpStatus.OK);
			
		}else
		{
			response=new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
	@DeleteMapping("deletestudent")
public ResponseEntity<Void> deleteStudent(@RequestBody StudentModel student ){
		
		ResponseEntity<Void> response=null;
		boolean result=studentService.deleteStudentModel(student);
		if(result)
		{
			response=new ResponseEntity<Void>(HttpStatus.OK);
			
		}else
		{
			response=new ResponseEntity<Void>(HttpStatus.CREATED);
		}
		return response;
	}
	
	
}
