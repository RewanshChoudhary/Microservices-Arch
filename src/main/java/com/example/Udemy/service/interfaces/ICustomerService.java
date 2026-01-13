package com.example.Udemy.service.interfaces;

import com.example.Udemy.dto.CustomerDto;

public interface ICustomerService{
  void createCustomer(CustomerDto dto , boolean check) throws Exception ;

}
