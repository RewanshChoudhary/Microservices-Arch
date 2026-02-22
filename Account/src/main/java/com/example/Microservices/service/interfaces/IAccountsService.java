package com.example.Microservices.service.interfaces;

import org.springframework.stereotype.Service;

import com.example.Microservices.dto.AccountsDto;
import com.example.Microservices.dto.CustomerDto;

@Service
public interface IAccountsService {
  CustomerDto fetchAccount(String accountNumber, String mobileNumber);

  void createAccount(CustomerDto customer);

  void updateAccount(String email, AccountsDto accountsDto);
  void deleteAccount(String accountNo);
   
}
