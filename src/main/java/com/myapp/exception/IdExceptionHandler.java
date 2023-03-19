package com.myapp.exception;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // tells springboot that this class is for multiple exceptions
public class IdExceptionHandler {

  @ExceptionHandler(value = { IdMissingException.class }) // calls idmssingexception class when error appears
  public ResponseEntity<Object> handleIdMissingException(IdMissingException e) {
    // 1.create payload containing exception details
    HttpStatus bad_request = HttpStatus.BAD_REQUEST;
    IdException idException = new IdException(
        e.getMessage(),
        e,
        bad_request,
        ZonedDateTime.now(ZoneId.of("Z")));
    // 2. return response entity
    return new ResponseEntity<>(idException, bad_request);
  }
}
