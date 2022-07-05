package com.smruti.demo1.endponit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.smruti.demo1.model.Student;

@CrossOrigin("*")
@RestController
public class StudentEndPoint {
	private List<Student> students = new ArrayList<>();

	@PostMapping("/student")
	Student addStudent(@RequestBody Student s) {
		students.add(s);
		return s;
	}

	@GetMapping("/students")
	private List<Student> getAllStudents() {
		return students;
	}

	@GetMapping("/student/{roll}")
	private Student getSingleStudents(@PathVariable int roll) {
		Student find = null;
		for (Student k : students)
			if (k.getRoll() == roll)
				find = k;
		return find != null ? find : new Student();
	}

	@PutMapping("/student")
	private Student updateStudent(@RequestBody Student s) {
		for (int i = 0; i < students.size(); i++) {
			Student st = students.get(i);
			if (st.getRoll() == s.getRoll()) {
				students.set(i, s);
			}
		}
		return s;
	}
	
	@DeleteMapping("/student/{roll}")
	private Student DeleteSingleStudents(@PathVariable int roll) {
		for (int i = 0; i < students.size(); i++) {
			Student st = students.get(i);
			if (st.getRoll() == roll) {
				students.remove(i);
			}
		}
		return new Student();
	}
}
