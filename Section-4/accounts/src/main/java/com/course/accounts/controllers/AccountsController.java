package com.course.accounts.controllers;

import org.springframework.beans.factory.annotation.Value;
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

import com.course.accounts.constants.AccountConstants;
import com.course.accounts.dto.AccountsDto;
import com.course.accounts.dto.CustomerDto;
import com.course.accounts.dto.ResponseDto;
import com.course.accounts.service.interfaces.IAccountsService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(path = "/api/accounts")
@RequiredArgsConstructor
public class AccountsController {
  @Value("${spring.api.version}")
  private String buildVersion;

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
  public ResponseEntity<ResponseDto> fetchAccount(@RequestParam final Long accountNo,
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
  public ResponseEntity<ResponseDto> updateAccount(@RequestParam Long accountNo,
      @Valid @RequestBody AccountsDto accountsDto) {
    accountsService.updateAccount(accountNo, accountsDto);

    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(new ResponseDto(
            AccountConstants.SUCCESS,
            AccountConstants.ACCOUNT_UPDATED,
            null));

  }

  @DeleteMapping("/delete")
  public ResponseEntity<ResponseDto> deleteAccount(@RequestParam Long accountNo) {
    accountsService.deleteAccount(accountNo);
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(new ResponseDto(
            AccountConstants.SUCCESS,
            AccountConstants.ACCOUNT_DELETED,
            null));

  }

  @GetMapping
  public ResponseEntity<ResponseDto> getBuildVersion() {
    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDto(AccountConstants.SUCCESS, "200", buildVersion));

  }

}
