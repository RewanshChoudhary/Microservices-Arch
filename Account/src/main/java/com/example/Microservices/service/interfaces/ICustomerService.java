package com.example.Microservices.service.interfaces;

import org.springframework.stereotype.Service;

import com.example.Microservices.dto.CustomerDto;

@Service
public interface ICustomerService {
  void createCustomer(CustomerDto dto);

  CustomerDto fetchCustomer(String email);

  void updateCustomer(String email, CustomerDto customerDto);

  void deleteCustomer(String email);

}
