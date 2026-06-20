package com.course.accounts.service.interfaces;

import org.springframework.stereotype.Service;

import com.course.accounts.dto.AccountsDto;
import com.course.accounts.dto.CustomerDto;

@Service
public interface IAccountsService {
  CustomerDto fetchAccount(Long accountNumber, String mobileNumber);

  void createAccount(CustomerDto customer);

  void updateAccount(Long accountNo, AccountsDto accountsDto);
  void deleteAccount(Long accountNo);
   
}
