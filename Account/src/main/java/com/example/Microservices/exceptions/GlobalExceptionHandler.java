package com.example.Microservices.exceptions;

import java.time.LocalDateTime;
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
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.Microservices.constants.AccountConstants;
import com.example.Microservices.dto.ErrorResponseDto;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @Override
  protected @Nullable ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
      HttpHeaders headers, HttpStatusCode status, WebRequest request) {
    // key : field value : message
    Map<String, String> validationErrors = new HashMap<>();

    // binds all the field errors found

    List<ObjectError> validErrorList = ex.getBindingResult().getAllErrors();
    validErrorList.forEach((error) -> {
      String fieldName = ((FieldError) error).getField();
      String validationMessage = error.getDefaultMessage();
      validationErrors.put(fieldName, validationMessage);

    });
    return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);

  }

  @ExceptionHandler(CustomerAlreadyExistsException.class)
  public ResponseEntity<ErrorResponseDto> handleCustomerException(CustomerAlreadyExistsException ex,
      HttpServletRequest request) {

    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(new ErrorResponseDto(ex.getMessage(), AccountConstants.ACCOUNT_ALREADY_EXISTS, request.getRequestURI(),
            LocalDateTime.now()));

  }

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResponseDto> handleResourceException(ResourceNotFoundException ex,
      HttpServletRequest req) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ErrorResponseDto(ex.getMessage(), AccountConstants.ACCOUNT_NOT_FOUND, req.getRequestURI(),
            LocalDateTime.now()));

  }

}
