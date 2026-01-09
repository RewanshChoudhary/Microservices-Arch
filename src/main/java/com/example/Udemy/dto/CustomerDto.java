package com.example.Udemy.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record CustomerDto(
 @NotBlank String name,
 @NotBlank @Email String email,
   @NotBlank String mobileNumber
  ){

}
