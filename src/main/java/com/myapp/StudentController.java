package com.myapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(StudentController.class, args);
	}

	@GetMapping
	public List<Student> getStudents(Student students) {
		return studentRepository.findAll();
	}

	@GetMapping("{studentId}")
	public Optional<Student> getStudent(@PathVariable("studentId") Integer id) {
		return studentRepository.findById(id);
	}

}
