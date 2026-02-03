package com.example.Microservices.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Microservices.constants.CustomerConstants;
import com.example.Microservices.dto.CustomerDto;
import com.example.Microservices.dto.ResponseDto;
import com.example.Microservices.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
  private final CustomerService customerService;

  public ResponseEntity<ResponseDto> fetchCustomer(@RequestParam String email) {

    CustomerDto cust = customerService.fetchCustomer(email);

    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDto(CustomerConstants.SUCCESS,
      CustomerConstants.CUSTOMER_FETCHED,
            cust));

  }

}
