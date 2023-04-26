package com.myapp.auth;

import com.myapp.faculty.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

  private String name;
  private Integer age;
  private String gender;
  private String subjectTeacher;
  private String email;
  private String password;
  private Role role;
}
