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

import com.example.Microservices.constants.CustomerConstants;
import com.example.Microservices.dto.CustomerDto;
import com.example.Microservices.dto.ResponseDto;
import com.example.Microservices.repository.CustomerRepository;
import com.example.Microservices.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/customer")
public class CustomerController {
  private final CustomerService customerService;
  private final CustomerRepository customerRepository;

  @GetMapping("/fetch")
  public ResponseEntity<ResponseDto> fetchCustomer(@RequestParam String email) {

    CustomerDto cust = customerService.fetchCustomer(email);

    return ResponseEntity.status(HttpStatus.OK)
        .body(new ResponseDto(CustomerConstants.SUCCESS,
            CustomerConstants.CUSTOMER_FETCHED,
            cust));

  }

  @PostMapping("/create")
  public ResponseEntity<ResponseDto> createCustomer(@RequestBody CustomerDto customerDto) {
    customerService.createCustomer(customerDto);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto(CustomerConstants.CREATED,
            CustomerConstants.CUSTOMER_CREATED,
            null));

  }

  @PutMapping("/update")
  public ResponseEntity<ResponseDto> updateCustomer(@RequestParam String email, @RequestBody CustomerDto customerDto) {
    customerService.updateCustomer(email, customerDto);
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(
            new ResponseDto(HttpStatus.ACCEPTED.toString(),
                CustomerConstants.CUSTOMER_UPDATED,
                null));

  }

  @DeleteMapping("/delete")
  public ResponseEntity<ResponseDto> deleteCustomer(@RequestParam String email) {
    customerService.deleteCustomer(email);
    return ResponseEntity.status(HttpStatus.ACCEPTED)
        .body(
            new ResponseDto(HttpStatus.ACCEPTED.toString(),
                CustomerConstants.CUSTOMER_DELETED,
                null));

  }

}
