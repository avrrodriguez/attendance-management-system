package com.myapp.faculty;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

  Optional<Faculty> findByEmail(String email);
}
