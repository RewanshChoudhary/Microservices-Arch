package com.example.Microservices.service.interfaces;

import com.example.Microservices.dto.CustomerDto;
import com.example.Microservices.exceptions.CustomerAlreadyExistsException;

public interface IAccountsService {
  void createAccount(CustomerDto customerDto) throws CustomerAlreadyExistsException;

  CustomerDto fetchAccount(String mobileNumber);

}
