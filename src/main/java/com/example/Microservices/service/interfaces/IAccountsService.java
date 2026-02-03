package com.example.Microservices.service.interfaces;

import com.example.Microservices.dto.CustomerDto;

public interface IAccountsService {
  CustomerDto fetchAccount(String accountNumber, String mobileNumber);

  void createAccount(CustomerDto customer);

}
