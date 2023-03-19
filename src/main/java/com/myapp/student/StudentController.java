package com.myapp.student;

import com.myapp.exception.IdMissingException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@GetMapping
	public List<Student> getStudents(Student students) {
		return studentRepository.findAll();
	}

	@GetMapping("{studentId}")
	public Student getStudent(@PathVariable("studentId") Integer id) {

		if (studentRepository.existsById(id) == false) {
			throw new IdMissingException("Student with that Id not found.");
		}

		Student student = studentRepository.findById(id).get();

		return student;

	}

	record StudentRequest(
			String name,
			Integer age,
			String gender,
			Integer classYear,
			Boolean present) {
	}

	@PostMapping
	public void addStudent(@RequestBody StudentRequest request) {
		Student student = new Student();

		student.setName(request.name());
		student.setAge(request.age());
		student.setGender(request.gender());
		student.setClassYear(request.classYear());
		student.setPresent(request.present());

		studentRepository.save(student);
	}

	@PutMapping("{studentId}")
	public void updateStudent(@PathVariable("studentId") Integer id,
			@RequestBody StudentRequest request) {

		if (studentRepository.existsById(id) == false) {
			throw new IdMissingException("Student with that Id not found.");
		}

		Student student = studentRepository.findById(id).get();

		String name = request.name() != null ? request.name() : student.getName();
		Integer age = request.age() != null ? request.age() : student.getAge();
		String gender = request.gender() != null ? request.gender() : student.getGender();
		Integer classYear = request.classYear() != null ? request.classYear() : student.getClassYear();
		Boolean present = request.present() != null ? request.present() : student.getPresent();

		student.setName(name);
		student.setAge(age);
		student.setGender(gender);
		student.setClassYear(classYear);
		student.setPresent(present);

		studentRepository.save(student);
	}

	@DeleteMapping("{studentId}")
	public void deleteStudent(@PathVariable("studentId") Integer id) {
		if (studentRepository.existsById(id) == false) {
			throw new IdMissingException("Student with that Id not found.");
		}
		studentRepository.deleteById(id);
	}

}
