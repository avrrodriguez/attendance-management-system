package com.myapp;

import java.util.List;

import com.myapp.exception.IdMissingException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

  private final FacultyRepository facultyRepository;

  public FacultyController(FacultyRepository facultyRepository) {
    this.facultyRepository = facultyRepository;
  }

  @GetMapping
  public List<Faculty> getAllFaculty() {
    return facultyRepository.findAll();
  }

  @GetMapping("{facultyId}")
  public Faculty getFaculty(@PathVariable("facultyId") Integer id) {
    if (facultyRepository.existsById(id) == false) {
      throw new IdMissingException("Faculty with that Id not found.");
    }
    Faculty faculty = facultyRepository.findById(id).get();

    return faculty;
  }

  record FacultyRequest(
      Integer id,
      String name,
      Integer age,
      String gender,
      Boolean admin,
      String subjectTeacher) {
  }

  @PostMapping
  public void addFaculty(@RequestBody FacultyRequest request) {
    Faculty faculty = new Faculty();

    faculty.setName(request.name());
    faculty.setAge(request.age());
    faculty.setGender(request.gender());
    faculty.setAdmin(request.admin());
    faculty.setSubjectTeacher(request.subjectTeacher());

    facultyRepository.save(faculty);

  }

  @PutMapping("{facultyId}")
  public Faculty updateFaculty(@PathVariable("facultyId") Integer id,
      @RequestBody FacultyRequest request) {

    if (facultyRepository.existsById(id) == false) {
      throw new IdMissingException("Faculty with that Id not found.");
    }

    Faculty faculty = facultyRepository.findById(id).get();

    String name = request.name() != null ? request.name() : faculty.getName();
    Integer age = request.age() != null ? request.age() : faculty.getAge();
    String gender = request.gender() != null ? request.gender() : faculty.getGender();
    Boolean admin = request.admin() != null ? request.admin() : faculty.getAdmin();
    String subjectTeacher = request.subjectTeacher() != null ? request.subjectTeacher() : faculty.getSubjectTeacher();

    faculty.setName(name);
    faculty.setAge(age);
    faculty.setGender(gender);
    faculty.setAdmin(admin);
    faculty.setSubjectTeacher(subjectTeacher);

    facultyRepository.save(faculty);

    return faculty;
  }

  @DeleteMapping("{facultyId}")
  public void deleteFaculty(@PathVariable("facultyId") Integer id) {
    if (facultyRepository.existsById(id) == false) {
      throw new IdMissingException("Faculty with that Id not found.");
    }

    facultyRepository.deleteById(id);
  }
}
