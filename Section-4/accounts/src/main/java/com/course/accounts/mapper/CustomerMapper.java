package com.course.accounts.mapper;

import com.course.accounts.dto.CustomerDto;
import com.course.accounts.model.Customer;

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
