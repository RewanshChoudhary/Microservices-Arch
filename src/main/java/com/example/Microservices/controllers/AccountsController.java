package com.example.Microservices.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Microservices.constants.AccountConstants;
import com.example.Microservices.dto.CustomerDto;
import com.example.Microservices.dto.ResponseDto;
import com.example.Microservices.service.interfaces.IAccountsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/accounts")
@RequiredArgsConstructor
public class AccountsController {
  private IAccountsService iAccountsService;

  public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(new ResponseDto(AccountConstants.ACCOUNT_CREATED, AccountConstants.CREATED));

  }

  public ResponseEntity<CustomerDto> fetchAccount(@RequestParam String mobileNumber) {
    return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .body(iAccountsService.fetchAccount(mobileNumber));

  }

}
