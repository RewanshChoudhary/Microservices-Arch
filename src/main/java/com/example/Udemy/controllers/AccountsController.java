package com.example.Udemy.controllers;

import com.example.Udemy.constants.AccountConstants;
import com.example.Udemy.dto.ResponseDto;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;





@RestController
@RequestMapping(path="/api/accounts")


public class AccountsController{

  public ResponseEntity<ResponseDto> createAccount(@RequestBody com.example.Udemy.dto.CustomerDto customerDto){
    return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(new ResponseDto(com.example.Udemy.constants.AccountConstants.ACCOUNT_CREATED, AccountConstants.CREATED));


  }



	

}
