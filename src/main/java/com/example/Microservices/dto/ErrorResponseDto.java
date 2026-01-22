package com.example.Microservices.dto;

import java.time.LocalDateTime;

public record ErrorResponseDto(
    String errorMsg,
    String errorCode,
    String apiPath,
    LocalDateTime errorTime

) {

}
