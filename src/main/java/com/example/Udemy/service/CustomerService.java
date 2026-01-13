package com.example.Udemy.service;

import com.example.Udemy.dto.CustomerDto;
import com.example.Udemy.exceptions.CustomerAlreadyExistsException;
import com.example.Udemy.mapper.CustomerMapper;
import com.example.Udemy.model.Customer;
import com.example.Udemy.repository.CustomerRepository;
import com.example.Udemy.service.interfaces.ICustomerService;

public class CustomerService implements ICustomerService {
  private final CustomerRepository customerRepository;

  public CustomerService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  @Override
  public void createCustomer(CustomerDto dto, boolean check) throws Exception {
    if (check) {
      if (customerRepository.findByEmail(dto.email())) {
        throw new CustomerAlreadyExistsException("Customer already exists :  While creating a user");

      }
      CustomerMapper cust = new CustomerMapper();
      Customer customer = cust.getCustomer(dto);
     
    }

  }

}
