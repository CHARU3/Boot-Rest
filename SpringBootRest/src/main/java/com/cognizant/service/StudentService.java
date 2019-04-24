package com.cognizant.service;

import java.util.List;

import com.cognizant.model.StudentModel;

public interface StudentService {

	List<StudentModel> getAllStudents();
	StudentModel getStudentByRollNo(int rollNo);
	boolean persistStudentModel(StudentModel student);
	boolean updateStudentModelAge(StudentModel student);
	boolean deleteStudentModel(StudentModel student);
}
