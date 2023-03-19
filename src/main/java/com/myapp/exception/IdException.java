package com.myapp.exception;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

public class IdException {
  private final String message;
  private final Throwable throwable;
  private final HttpStatus httpStatus;
  private final ZonedDateTime timestamp;

  public IdException(String message,
      Throwable throwable,
      HttpStatus httpStatus,
      ZonedDateTime timestamp) {

    this.message = message;
    this.throwable = throwable;
    this.httpStatus = httpStatus;
    this.timestamp = timestamp;

  }

  // getters

  public String getMessage() {
    return message;
  }

  public Throwable getThrowable() {
    return throwable;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public ZonedDateTime getZonedDateTime() {
    return timestamp;
  }
}
