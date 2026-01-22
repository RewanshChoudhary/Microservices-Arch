package com.example.Microservices.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Microservices.dto.CustomerDto;
import com.example.Microservices.exceptions.CustomerAlreadyExistsException;
import com.example.Microservices.mapper.CustomerMapper;
import com.example.Microservices.model.Customer;
import com.example.Microservices.repository.CustomerRepository;
import com.example.Microservices.service.interfaces.ICustomerService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerService implements ICustomerService {
  private final CustomerRepository customerRepository;

  @Override
  public void createCustomer(CustomerDto dto, boolean check) throws CustomerAlreadyExistsException {
    if (check) {
      Optional<Boolean> present = customerRepository.findByEmail(dto.getEmail());

      if (present.isPresent()) {
        throw new CustomerAlreadyExistsException("Customer already exists :  While creating a user");

      }
    }

    Customer customer = CustomerMapper.toEntity(dto);

    customerRepository.save(customer);

  }

}
