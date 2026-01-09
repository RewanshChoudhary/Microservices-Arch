package com.example.Udemy.exceptions;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import com.example.Udemy.constants.AccountConstants;
import com.example.Udemy.dto.ErrorResponseDto;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler{

  @ExceptionHandler(CustomerAlreadyExistsException.class)
  public ResponseEntity<ErrorResponseDto> handleCustomerException(CustomerAlreadyExistsException ex,HttpServletRequest  request){

  
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
    .body(new ErrorResponseDto(ex.getMessage(),AccountConstants.ACCOUNT_ALREADY_EXISTS,request.getRequestURI(),LocalDateTime.now()));


  }

  


}
