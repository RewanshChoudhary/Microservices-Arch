package com.example.Microservices.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Microservices.constants.AccountConstants;
import com.example.Microservices.dto.AccountsDto;
import com.example.Microservices.dto.CustomerDto;
import com.example.Microservices.dto.ResponseDto;
import com.example.Microservices.service.interfaces.IAccountsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/accounts")
@RequiredArgsConstructor
public class AccountsController {

  private final IAccountsService accountsService;

  @PostMapping("/create")
  public ResponseEntity<ResponseDto> createAccount(
      @Valid @RequestBody final CustomerDto customerDto) {

    accountsService.createAccount(customerDto);

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(new ResponseDto(
            AccountConstants.CREATED,
            AccountConstants.ACCOUNT_CREATED));
  }

  @GetMapping("/fetch")
  public ResponseEntity<ResponseDto> fetchAccount(@RequestParam final String accountNo,
      @RequestParam final String mobileNumber) {
    final CustomerDto customer = accountsService.fetchAccount(accountNo, mobileNumber);

    final ResponseEntity<ResponseDto> responseEntity = ResponseEntity
        .status(HttpStatus.OK)
        .body(new ResponseDto(
            AccountConstants.SUCCESS,
            AccountConstants.ACCOUNT_FETCHED,
            customer));

    return responseEntity;
  }

  @PutMapping("/update")
  public ResponseEntity<ResponseDto> updateAccount(@RequestParam String accountNo,
      @Valid @RequestBody AccountsDto accountsDto) {
    accountsService.updateAccount(accountNo, accountsDto);

    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(new ResponseDto(
            AccountConstants.SUCCESS,
            AccountConstants.ACCOUNT_UPDATED,
            null));

  }

  @DeleteMapping("/delete")
  public ResponseEntity<ResponseDto> deleteAccount(@RequestParam String accountNo) {
    accountsService.deleteAccount(accountNo);
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(new ResponseDto(
            AccountConstants.SUCCESS,
            AccountConstants.ACCOUNT_DELETED,
            null));

  }

}
