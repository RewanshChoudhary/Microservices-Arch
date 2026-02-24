package com.course.Loans.controller;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.Loans.constants.LoansConstants;
import com.course.Loans.dto.LoansDto;
import com.course.Loans.dto.ResponseDto;
import com.course.Loans.service.LoansService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/loans")
public class LoansController {
  private final LoansService loansService;

  @GetMapping("/fetch")
  public ResponseEntity<ResponseDto<LoansDto>> fetchLoanDetails(@RequestParam String mobileNumber,
      @RequestParam String loadNumber) {
    LoansDto loan = loansService.fetchLoanDetails(mobileNumber, loadNumber);
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(new ResponseDto<LoansDto>(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200, loan));

  }

  @PostMapping("/create")
  public ResponseEntity<ResponseDto<LoansDto>> createLoan(@RequestBody LoansDto loansDto) {
    loansService.createLoan(loansDto);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto<LoansDto>(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200, null));

  }

  @PutMapping("/update")
  public ResponseEntity<ResponseDto<LoansDto>> updateLoan(@RequestBody LoansDto loansDto) {
    loansService.updateLoan(loansDto);

    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(new ResponseDto<LoansDto>(LoansConstants.STATUS_200, LoansConstants.MESSAGE_200, null));

  }

  @DeleteMapping("/delete")
  public ResponseEntity<ResponseDto<LoansDto>> deleteLoan(@RequestParam String mobileNumber,
      @RequestParam String loadNumber) {
    loansService.deleteLoan(mobileNumber, loadNumber);
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(new ResponseDto<LoansDto>(LoansConstants.STATUS_417, LoansConstants.MESSAGE_417_DELETE, null));

  }
}
