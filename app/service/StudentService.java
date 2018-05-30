package service;

import java.util.List;

import models.StudentEntity;
import models.StudentModel;
import play.db.jpa.JPABase;

public class StudentService
{
	public void insert(StudentModel studentModel) {

		StudentEntity studentEntity = new StudentEntity();
		studentEntity.setStudentName(studentModel.getStudentName());
		studentEntity.setStudentCity(studentModel.getStudentCity());
		System.out.println(studentEntity);
		studentEntity.save();
	}
	public StudentEntity update(StudentModel studentModel) 
	{	
		StudentEntity studentEntity = StudentEntity.find("id=?", Long.valueOf(String.valueOf(studentModel.getSid()))).first();
		studentEntity.setStudentName(studentModel.getStudentName());
		studentEntity.setStudentCity(studentModel.getStudentCity());
		return studentEntity.save();
	}
}
