package com.myapp;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
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
}
