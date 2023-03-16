package com.myapp;

// import com.myapp.Student;
// import com.myapp.StudentRepository;

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
@RequestMapping("")
public class Main {

	private final StudentRepository studentRepository;

	public Main(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@GetMapping
	public List<Student> getStudents(Student students) {
		return studentRepository.findAll();
	}

	@GetMapping
	public Optional<Student> getStudent(@PathVariable("studentId") Integer id) {
		return studentRepository.findById(id);
	}

}
