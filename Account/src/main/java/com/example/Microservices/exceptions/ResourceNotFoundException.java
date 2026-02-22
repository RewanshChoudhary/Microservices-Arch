package com.example.Microservices.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ResourceNotFoundException extends RuntimeException {

  public ResourceNotFoundException(String resource, String input, String inputValue) {
    super(String.format("%s not available for %s with the value %s ", resource, input, inputValue));

  }

}
