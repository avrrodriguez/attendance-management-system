package com.myapp.faculty;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.token.Token;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Faculty implements UserDetails {

  @Id
  @SequenceGenerator(name = "faculty_id_sequence", sequenceName = "faculty_id_sequence", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "faculty_id_sequence")

  private Integer id;
  private String name;
  private Integer age;
  private String gender;
  private String subjectTeacher;
  private String email;
  private String password;

  public Faculty(Integer id,
      String name,
      Integer age,
      String gender,
      String subjectTeacher,
      String email,
      String password) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.subjectTeacher = subjectTeacher;
    this.email = email;
    this.password = password;
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

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  // authentication

  @Enumerated(EnumType.STRING)
  private Role role;

  @OneToMany(mappedBy = "faculty")
  private List<Token> tokens;

  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(role.name()));
  }

  public String getUsername() {
    return this.email;
  }

  public String getPassword() {
    return this.password;
  }

  public boolean isAccountNonExpired() {
    return true;
  }

  public boolean isAccountNonLocked() {
    return true;
  }

  public boolean isCredentialsNonExpired() {
    return true;
  }

  public boolean isEnabled() {
    return true;
  }

}
