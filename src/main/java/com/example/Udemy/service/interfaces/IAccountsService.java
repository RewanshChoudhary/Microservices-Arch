package com.example.Udemy.service.interfaces;




import com.example.Udemy.dto.CustomerDto;
import com.example.Udemy.exceptions.CustomerAlreadyExistsException;

public interface IAccountsService{
  void createAccount(CustomerDto customerDto) throws CustomerAlreadyExistsException ;

}
