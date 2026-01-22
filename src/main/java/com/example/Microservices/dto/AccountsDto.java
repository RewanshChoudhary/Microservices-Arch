package com.example.Microservices.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountsDto {

  private Long accountNumber;
  private String branchAddress;
  private String accountType;
}
