package com.example.Udemy.service;

import com.example.Udemy.dto.CustomerDto;
import com.example.Udemy.exceptions.CustomerAlreadyExistsException;

import com.example.Udemy.model.Accounts;
import com.example.Udemy.repository.AccountsRepository;
import com.example.Udemy.repository.CustomerRepository;

import com.example.Udemy.service.interfaces.IAccountsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor

public class AccountsService implements IAccountsService {
  private final CustomerRepository customerRepository;
  private final CustomerService customerService;

  private final AccountsRepository accountsRepository;



  public void createAccount(CustomerDto dto) throws CustomerAlreadyExistsException {
    Optional<Boolean>  present=customerRepository.findByEmail(dto.email());

    if (!present.isPresent()) {
      customerService.createCustomer(dto, false);
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

}
