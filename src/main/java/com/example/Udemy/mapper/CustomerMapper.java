package com.example.Udemy.mapper;

import com.example.Udemy.dto.CustomerDto;
import com.example.Udemy.model.Customer;

public class CustomerMapper{

  public CustomerDto getDto(Customer cust){
    CustomerDto dto=new CustomerDto(cust.getName(), cust.getEmail(), cust.getMobileNumber());
    return dto;

  }
  public Customer getCustomer(CustomerDto dto){
    Customer cust=new Customer();
    cust.setName(dto.name());
    cust.setEmail(dto.email());
    cust.setMobileNumber(dto.mobileNumber());
    return cust;

  }

}
