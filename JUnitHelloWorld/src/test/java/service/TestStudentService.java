package service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import dao.StudentDao;
import model.Student;

public class TestStudentService {
	

    
	
	@Test
	public void test_getStudents() {
		
		// Mock data
		StudentDao dbService = Mockito.mock(StudentDao.class);
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student(1, "Toto"));
		studentList.add(new Student(2, "Popo"));
		Mockito.when(dbService.getStudents()).thenReturn(studentList);
		
		StudentService service = new StudentService(dbService);

		List<String> expected_result = new ArrayList<String>();
		expected_result.add("Toto");
		expected_result.add("Popo");
		
		List<String> result_students = service.getStudents();
		
		assertEquals(expected_result, result_students);
		
	}
	@Test
	public void test_getStudentById() {
		
		// Mock data
		StudentDao dbService = Mockito.mock(StudentDao.class);
		
		Student student = new Student(1, "Toto");
		
		Mockito.when(dbService.getStudentById(Mockito.anyInt())).thenReturn(student);
		
		StudentService service = new StudentService(dbService);

		Student expected_result = new Student(1,"Toto");
		
		Student result_student = service.getStudentById(1);
		
		assertEquals(expected_result.getName(), result_student.getName());
		
	}
}
