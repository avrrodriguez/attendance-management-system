package com.myapp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Student {

  @Id
  @SequenceGenerator(name = "student_id_sequence", sequenceName = "student_id_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_sequence")

  private Integer id;
  private String name;
  private Integer age;
  private String gender;
  private Integer classYear;
  private Boolean present;

  public Student(Integer id,
      String name,
      Integer age,
      String gender,
      Integer classYear,
      Boolean present) {

    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.classYear = classYear;
    this.present = present;
  }

  public Student() {
  }

  // setters and getters

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

  public void setClassYear(Integer classYear) {
    this.classYear = classYear;
  }

  public Integer getClassYear() {
    return this.classYear;
  }

  public void setPresent(Boolean present) {
    this.present = present;
  }

  public Boolean getPresent() {
    return this.present;
  }
}
