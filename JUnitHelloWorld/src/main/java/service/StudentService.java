package service;

import java.util.ArrayList;
import java.util.List;

import dao.StudentDao;
import model.Student;

public class StudentService {
	
	StudentDao service;
	
	public StudentService(StudentDao service) {
		this.service = service;
	}
	
	public List<String> getStudents(){
		List<Student> students = service.getStudents();
		List<String> names = new ArrayList<String>();
		
		for (Student student : students) {
			names.add(student.getName());
		}
		
		return names;		
	}
	
	public Student getStudentById(int id){
		
		Student student = service.getStudentById(id);
		
		return student;
				
	}
	
}
