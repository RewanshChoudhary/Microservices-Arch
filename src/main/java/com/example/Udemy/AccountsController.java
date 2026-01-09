package com.example.Udemy;

import org.springframework.web.bind.annotation.RestController;

import com.example.Udemy.constants.AccountConstants;
import com.example.Udemy.dto.CustomerDto;
import com.example.Udemy.dto.ResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping(path="/api/accounts")


public class AccountsController{

  public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto){
    return ResponseEntity
          .status(HttpStatus.CREATED)
          .body(new ResponseDto(AccountConstants.ACCOUNT_CREATED,AccountConstants.CREATED));


  }



	

}
