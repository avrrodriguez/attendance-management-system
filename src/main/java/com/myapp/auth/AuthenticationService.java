package com.myapp.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myapp.faculty.Faculty;
import com.myapp.faculty.Role;
import com.myapp.faculty.FacultyRepository;
import com.myapp.security.JwtService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final FacultyRepository repository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(RegisterRequest request) {
    var user = Faculty.builder()
        .name(request.getName())
        .age(request.getAge())
        .gender(request.getGender())
        .subjectTeacher(request.getSubjectTeacher())
        .email(request.getEmail())
        .password(passwordEncoder.encode(request.getPassword()))
        .role(Role.FACULTY)
        .build();
    repository.save(user);
    var jwtToken = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
    var user = repository.findByEmail(request.getEmail())
        .orElseThrow();
    var jwtToken = jwtService.generateToken(user);

    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

}
