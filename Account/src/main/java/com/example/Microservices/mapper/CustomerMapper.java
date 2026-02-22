package com.example.Microservices.mapper;

import com.example.Microservices.dto.CustomerDto;
import com.example.Microservices.model.Customer;

public class CustomerMapper {

  public static CustomerDto toDto(Customer customer) {
    if (customer == null) {
      return null;
    }

    return CustomerDto.builder()
        .name(customer.getName())
        .email(customer.getEmail())
        .mobileNumber(customer.getMobileNumber())
        .build();
  }

  public static Customer toEntity(CustomerDto dto) {
    if (dto == null) {
      return null;
    }

    Customer customer = new Customer();
    customer.setName(dto.getName());
    customer.setEmail(dto.getEmail());
    customer.setMobileNumber(dto.getMobileNumber());
    return customer;
  }
}
