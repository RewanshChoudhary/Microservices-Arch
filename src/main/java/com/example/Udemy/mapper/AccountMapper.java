package com.example.Udemy.mapper;

import com.example.Udemy.dto.AccountsDto;
import com.example.Udemy.model.Accounts;

public class AccountMapper {

public Accounts mapToAccount(AccountsDto dto) {
    Accounts acc = new Accounts();
    acc.setAccountNumber(dto.accountNumber());
    acc.setAccountType(dto.accountType());
    acc.setBranchAddress(dto.branchAddress());
    return acc;
}

  public AccountsDto  mapToAccountDto(Accounts acc){
    AccountsDto accDto=new AccountsDto(acc.getAccountNumber(),acc.getAccountType(),acc.getBranchAddress());

    return accDto;

    

  }
  
}
