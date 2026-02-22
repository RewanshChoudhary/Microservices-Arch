package com.example.Microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class ResponseDto<T> {

  public ResponseDto(String statusCode, String statMess) {
    this.statusCode = statusCode;
    this.statMess = statMess;
  }

  private String statusCode;
  private String statMess;
  private T data;

}
