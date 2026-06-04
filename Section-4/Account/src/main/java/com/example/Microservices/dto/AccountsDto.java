package com.example.Microservices.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountsDto {
  @NotNull(message = "Account Number should not be empty")
  private Long accountNumber;
  @NotBlank(message = "Branch address should not be empty")
  private String branchAddress;

  private String accountType;
}
