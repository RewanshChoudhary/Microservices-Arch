package com.example.Microservices.service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.example.Microservices.dto.AccountsDto;
import com.example.Microservices.dto.CustomerDto;
import com.example.Microservices.exceptions.ResourceNotFoundException;
import com.example.Microservices.mapper.AccountMapper;
import com.example.Microservices.mapper.CustomerMapper;
import com.example.Microservices.model.Accounts;
import com.example.Microservices.model.Customer;
import com.example.Microservices.repository.AccountsRepository;
import com.example.Microservices.repository.CustomerRepository;
import com.example.Microservices.service.interfaces.IAccountsService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class AccountsService implements IAccountsService {
  private final CustomerRepository customerRepository;

  private final AccountsRepository accountsRepository;

  public void createAccount(CustomerDto dto) {
    Optional<Customer> cust = customerRepository.findByEmail(dto.getEmail());

    if (!cust.isPresent()) {
      throw new ResourceNotFoundException("User", "Email", dto.getEmail());

    }
    Accounts acc = Accounts.builder()
        .branchAddress("Delhi")
        .accountType("SAVINGS")
        .accountNumber(next())
        .build();
    accountsRepository.save(acc);

  }

  private static long next() {
    long timePart = System.currentTimeMillis() % 1_000_000_000L;
    long randomDigit = ThreadLocalRandom.current().nextInt(0, 10);
    return timePart * 10 + randomDigit;
  }

  @Override
  public CustomerDto fetchAccount(String mobileNumber) throws ResourceNotFoundException {

    Customer customer = customerRepository.findByMobileNumber(mobileNumber)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Customer",
            "mobileNumber",
            mobileNumber));

    Accounts acc = accountsRepository.findByMobileNumber(mobileNumber)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Account",
            "mobileNumber",
            mobileNumber));
    CustomerDto custDto = CustomerMapper.toDto(customer);
    AccountsDto accDto = AccountMapper.toDto(acc);
    custDto.setAccountsDto(accDto);
    return custDto;

  }
}
