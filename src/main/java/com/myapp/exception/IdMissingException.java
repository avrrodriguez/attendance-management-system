package com.myapp.exception;

public class IdMissingException extends RuntimeException {

  public IdMissingException(String message) {
    super(message);
  }

  public IdMissingException(String message, Throwable cause) {
    super(message, cause);
  }
}
