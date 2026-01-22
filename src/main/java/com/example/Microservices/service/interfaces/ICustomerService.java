package com.example.Microservices.service.interfaces;

import com.example.Microservices.dto.CustomerDto;
import com.example.Microservices.exceptions.CustomerAlreadyExistsException;

public interface ICustomerService {
  void createCustomer(CustomerDto dto, boolean check) throws CustomerAlreadyExistsException;

}
