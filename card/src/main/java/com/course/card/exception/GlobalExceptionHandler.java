package com.course.card.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jspecify.annotations.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    // key : field value : error
    Map<String, String> validationError = new HashMap<>();
    List<ObjectError> errorList = ex.getBindingResult().getAllErrors();

    errorList.forEach(error -> {
      String field = ((FieldError) error).getField();
      String message = error.getDefaultMessage();
      validationError.put(field, message);

    });
    return new ResponseEntity<>(validationError, HttpStatus.BAD_REQUEST);

  }



}
