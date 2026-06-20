package com.course.accounts.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.course.accounts.dto.CustomerDto;
import com.course.accounts.exceptions.ResourceNotFoundException;
import com.course.accounts.mapper.CustomerMapper;
import com.course.accounts.model.Customer;
import com.course.accounts.repository.CustomerRepository;
import com.course.accounts.service.interfaces.ICustomerService;

import jakarta.transaction.Transactional;
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

  @Transactional
  public void updateCustomer(String email, CustomerDto customerDto) {

    Optional<Customer> cust = customerRepository.findByEmail(email);
    if (!cust.isPresent()) {
      throw new ResourceNotFoundException("User", "Email", email);

    }

    Customer user = cust.get();

    user.setMobileNumber(customerDto.getMobileNumber());
    user.setName(customerDto.getName());

  }

  @Override
  public void deleteCustomer(String email) {
    Optional<Customer> cust = customerRepository.findByEmail(email);
    if (!cust.isPresent())
      throw new ResourceNotFoundException("user", "email", email);

    customerRepository.delete(cust.get());


  }

}
