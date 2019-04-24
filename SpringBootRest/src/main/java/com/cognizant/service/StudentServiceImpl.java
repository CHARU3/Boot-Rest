package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cognizant.model.StudentModel;

@Service
public class StudentServiceImpl implements StudentService {

	static List<StudentModel> studentsList=new ArrayList<StudentModel>();
	static{
		
		StudentModel student1=new StudentModel();
		student1.setRollNo(1001);
		student1.setFirstName("charu");
		student1.setLastName("abc");
		student1.setAge(21);
		
		StudentModel student2=new StudentModel();
		student2.setRollNo(1002);
		student2.setFirstName("abc");
		student2.setLastName("xyz");
		student2.setAge(66);
		
		StudentModel student3=new StudentModel();
		student3.setRollNo(1003);
		student3.setFirstName("caa");
		student3.setLastName("aaa");
		student3.setAge(45);
		
		studentsList.add(student1);
		studentsList.add(student2);
		studentsList.add(student3);
		
	}
	
	
	public List<StudentModel> getAllStudents() {
		// TODO Auto-generated method stub
		return studentsList;
	}

	public StudentModel getStudentByRollNo(int rollNo) {
		// TODO Auto-generated method stub
		StudentModel studentByRollNo=new StudentModel();
		for(StudentModel student:studentsList){
			if(student.getRollNo()==rollNo){
				studentByRollNo=student;
			}
		}
		return studentByRollNo;
	}

	public boolean persistStudentModel(StudentModel student) {
		// TODO Auto-generated method stub
		return studentsList.add(student);
	}

	public boolean updateStudentModelAge(StudentModel newstudent) {
		// TODO Auto-generated method stub
		boolean result=false;
		Iterator<StudentModel> iterator
		for(StudentModel student:studentsList){
			if(student.getRollNo()==newstudent.getRollNo()){
				student.setAge(newstudent.getAge());
				result=true;
			}else
			{
				studentsList.add(newstudent);
			}
		}
		return result;
	}

	public boolean deleteStudentModel(int rollNo) {
		// TODO Auto-generated method stub
		return false;
	}

}
