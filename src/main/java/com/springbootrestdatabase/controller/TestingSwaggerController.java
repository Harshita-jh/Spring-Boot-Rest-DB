package com.springbootrestdatabase.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrestdatabase.entity.Student;
import com.springbootrestdatabase.repository.StudentRepository;

@RestController
@RequestMapping("/hello")
public class TestingSwaggerController {
	
	@Autowired
	StudentRepository studentRepository;

	@GetMapping("/say")
	public String sayHello() {
		return "Hello Swagger";
	}
	
	//Get all the Student
	//localhost:8081/students
	@GetMapping("/students")
	public List<Student> getAllStuednt() {
		List<Student> students = studentRepository.findAll();
		return students;
	}
	
	//id passed as pathvariable
	@GetMapping("/student/{id}")
	public Student getStudent(@PathVariable int id) {
		Student student = studentRepository.findById(id).get();
		return student;
		
	}
	
	@PostMapping("/student/add")
	@ResponseStatus(code = HttpStatus.CREATED)
	public void createStudent(@RequestBody Student student) {
		studentRepository.save(student);
		
	}
	
	@PutMapping("/student/update/{id}")
	public Student updateStudents(@PathVariable int id) {
		Student student = studentRepository.findById(id).get();
		student.setName("qqq");
		student.setPercentage(92);
		studentRepository.save(student);
		return student;
	}
	
	@DeleteMapping("/student/delete/{id}")
	public void removeStudent(@PathVariable int id) {
		Student student = studentRepository.findById(id).get();
		studentRepository.delete(student);
	}
	
}
