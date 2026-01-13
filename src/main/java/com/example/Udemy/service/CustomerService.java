package com.example.Udemy.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Udemy.dto.CustomerDto;
import com.example.Udemy.exceptions.CustomerAlreadyExistsException;
import com.example.Udemy.mapper.CustomerMapper;
import com.example.Udemy.model.Customer;
import com.example.Udemy.repository.CustomerRepository;
import com.example.Udemy.service.interfaces.ICustomerService;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
  private final CustomerRepository customerRepository;

  @Override
  public void createCustomer(CustomerDto dto, boolean check) throws CustomerAlreadyExistsException{
    if (check) {
      Optional<Boolean> present=customerRepository.findByEmail(dto.email());

      if (present.isPresent()){
        throw new CustomerAlreadyExistsException("Customer already exists :  While creating a user");

      }}
      CustomerMapper cust = new CustomerMapper();
      Customer customer = cust.getCustomer(dto);

      customerRepository.save(customer);


  }

}
