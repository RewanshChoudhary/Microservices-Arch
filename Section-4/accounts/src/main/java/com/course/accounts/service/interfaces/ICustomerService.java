package com.course.accounts.service.interfaces;

import org.springframework.stereotype.Service;

import com.course.accounts.dto.CustomerDto;

@Service
public interface ICustomerService {
  void createCustomer(CustomerDto dto);

  CustomerDto fetchCustomer(String email);

  void updateCustomer(String email, CustomerDto customerDto);

  void deleteCustomer(String email);

}
