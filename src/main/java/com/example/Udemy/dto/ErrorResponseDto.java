package com.example.Udemy.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;


public record ErrorResponseDto(
String errorMsg,
String errorCode,
String apiPath,
LocalDateTime errorTime

){

}
