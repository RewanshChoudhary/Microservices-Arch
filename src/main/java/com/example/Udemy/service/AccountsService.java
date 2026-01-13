package com.example.Udemy.service;

import org.springframework.stereotype.Service;

import com.example.Udemy.dto.CustomerDto;
import com.example.Udemy.repository.CustomerRepository;
import com.example.Udemy.service.interfaces.IAccountsService;

@Service
public class AccountsService implements IAccountsService {
  private final CustomerRepository customerRepository;

  public void createAccount(CustomerDto dto) {
    if (!customerRepository.findByEmail(dto)) {
      customerService.createCustomer(dto);

    }

  }

  public AccountsService(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

}
