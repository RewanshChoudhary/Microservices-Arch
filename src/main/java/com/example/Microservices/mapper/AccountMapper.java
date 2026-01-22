package com.example.Microservices.mapper;

import com.example.Microservices.dto.AccountsDto;
import com.example.Microservices.model.Accounts;

public class AccountMapper {

  public static Accounts toEntity(AccountsDto dto) {
    if (dto == null) {
      return null;
    }

    Accounts acc = new Accounts();
    acc.setAccountNumber(dto.getAccountNumber());
    acc.setAccountType(dto.getAccountType());
    acc.setBranchAddress(dto.getBranchAddress());
    return acc;
  }

  public static AccountsDto toDto(Accounts acc) {
    if (acc == null) {
      return null;
    }

    return AccountsDto.builder()
        .accountNumber(acc.getAccountNumber())
        .accountType(acc.getAccountType())
        .branchAddress(acc.getBranchAddress())
        .build();
  }
}
