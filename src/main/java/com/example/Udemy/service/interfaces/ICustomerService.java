package com.example.Udemy.service.interfaces;

import com.example.Udemy.dto.CustomerDto;
import com.example.Udemy.exceptions.CustomerAlreadyExistsException;

public interface ICustomerService{
  void createCustomer(CustomerDto dto , boolean check) throws CustomerAlreadyExistsException;

}
