package com.course.accounts.service;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

import com.course.accounts.dto.AccountsDto;
import com.course.accounts.dto.CustomerDto;
import com.course.accounts.exceptions.ResourceNotFoundException;
import com.course.accounts.mapper.AccountMapper;
import com.course.accounts.mapper.CustomerMapper;
import com.course.accounts.model.Accounts;
import com.course.accounts.model.Customer;
import com.course.accounts.repository.AccountsRepository;
import com.course.accounts.repository.CustomerRepository;
import com.course.accounts.service.interfaces.IAccountsService;

import jakarta.transaction.Transactional;
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
        .customer(cust.get())
        .createdBy(dto.getEmail())
        .updatedBy(null)

        .build();

    accountsRepository.save(acc);

  }

  private static long next() {
    long timePart = System.currentTimeMillis() % 1_000_000_000L;
    long randomDigit = ThreadLocalRandom.current().nextInt(0, 10);
    return timePart * 10 + randomDigit;
  }

  @Override
  public CustomerDto fetchAccount(Long accNo, String mobileNumber) throws ResourceNotFoundException {

    Customer customer = customerRepository.findByMobileNumber(mobileNumber)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Customer",
            "mobileNumber",
            mobileNumber));

    Accounts acc = accountsRepository.findByAccountNumber(accNo)
        .orElseThrow(() -> new ResourceNotFoundException(
            "Account",
            "Account Number ",
            String.valueOf(accNo)));
    CustomerDto custDto = CustomerMapper.toDto(customer);
    AccountsDto accDto = AccountMapper.toDto(acc);
    custDto.getAccounts().add(accDto);

    return custDto;

  }

  @Override
  @Transactional
  public void updateAccount(Long accountNo, AccountsDto accountsDto) {
    Optional<Accounts> acc = accountsRepository.findByAccountNumber(accountNo);

    if (!acc.isPresent()) {
      throw new ResourceNotFoundException("Account", "accountNo", String.valueOf(accountNo));

    }
    Accounts currAcc = acc.get();
    currAcc.setAccountType(accountsDto.getAccountType());
    currAcc.setBranchAddress(accountsDto.getBranchAddress());
    currAcc.setAccountNumber(accountsDto.getAccountNumber());

  }

  @Override
  public void deleteAccount(Long accountNo) {
    Optional<Accounts> acc = accountsRepository.findByAccountNumber(accountNo);
    if (!acc.isPresent())
      throw new ResourceNotFoundException("account", "accountnumbe", String.valueOf(accountNo));

    accountsRepository.delete(acc.get());
  }

}
