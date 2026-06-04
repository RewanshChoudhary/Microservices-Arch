package com.example.Microservices.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder

@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

  @NotBlank(message = "Name must not be blank")
  private String name;

  @NotBlank(message = "Email must not be blank")
  @Email(message = "Email must be a valid email address")
  private String email;

  @NotBlank(message = "Mobile number must not be blank")
  private String mobileNumber;
  private List<AccountsDto> accounts;

}
