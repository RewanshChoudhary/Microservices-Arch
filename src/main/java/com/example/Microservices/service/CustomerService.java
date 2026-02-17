package com.example.Microservices.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Microservices.dto.CustomerDto;
import com.example.Microservices.exceptions.ResourceNotFoundException;
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
  public void createCustomer(CustomerDto dto) {
    Customer customer = Customer.builder().email(dto.getEmail())
        .name(dto.getName())
        .accounts(null)
        .mobileNumber(dto.getMobileNumber())
        .createdBy(dto.getEmail())
        .updatedBy(dto.getEmail())
        .build();

    customerRepository.save(customer);

  }

  @Override
  public CustomerDto fetchCustomer(String email) {
    Customer cust = customerRepository.findByEmail(email)
        .orElseThrow(() -> new ResourceNotFoundException("Customer", "email", email));
    CustomerDto dto = CustomerMapper.toDto(cust);
    return dto;

  }

  public void updateCustomer(String email, CustomerDto customerDto) {

    Optional<Customer> cust = customerRepository.findByEmail(email);
    if (!cust.isPresent()) {
      throw new ResourceNotFoundException("User", "Email", email);

    }

    Customer user = cust.get();
    user.setEmail(customerDto.getEmail());
    user.setMobileNumber(customerDto.getMobileNumber());
    user.setName(customerDto.getName());

  }
}
