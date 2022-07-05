package com.smruti.demo1.endponit;

// import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smruti.demo1.model.Student;
import com.smruti.demo1.service.StudentService;

@CrossOrigin("*")
@RestController
public class StudentEndPoint {
	//private List<Student> students = new ArrayList<>();
	private StudentService studentService;
	 
	public StudentEndPoint(StudentService studentService) {
		this.studentService = studentService;
	}

	@PostMapping("/student")
	ResponseEntity<Student> addStudent(@RequestBody Student s) {
		Student s1 = studentService.addOrUpdateStudent(s);
		return  ResponseEntity.ok(s1);
		
	}

	@GetMapping("/students")
	private List<Student> getAllStudents() {
		return studentService.getStudents();
	}

	@GetMapping("/student/{roll}")
	private ResponseEntity<Object> getSingleStudents(@PathVariable int roll) {
		Optional<Student> ops = studentService.getStudent(roll);
		return  ops.isPresent() ? ResponseEntity.ok(ops.get()) : 
		ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
	}

	@PutMapping("/student")
	private Student updateStudent(@RequestBody Student s) {
		
		return studentService.addOrUpdateStudent(s);
	}
	
	@DeleteMapping("/student/{roll}")
	private void DeleteSingleStudents(@PathVariable int roll) {
		studentService.deleteStudent(roll);
	}
}
