package com.myapp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Faculty {

  @Id
  @SequenceGenerator(name = "faculty_id_sequence", sequenceName = "faculty_id_sequence")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faculty_id_sequence")

  private Integer id;
  private String name;
  private Integer age;
  private String gender;
  private Boolean admin;
  private String subjectTeacher;

  public Faculty(Integer id,
      String name,
      Integer age,
      String gender,
      String subjectTeacher,
      Boolean admin) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.subjectTeacher = subjectTeacher;
    this.admin = admin;
  }

  public Faculty() {
  }

  // getters and setters

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getId() {
    return this.id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Integer getAge() {
    return this.age;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getGender() {
    return this.gender;
  }

  public void setSubjectTeacher(String subjectTeacher) {
    this.subjectTeacher = subjectTeacher;
  }

  public String getSubjectTeacher() {
    return this.subjectTeacher;
  }

  public void setAdmin(Boolean admin) {
    this.admin = admin;
  }

  public Boolean getAdmin() {
    return this.admin;
  }

}
