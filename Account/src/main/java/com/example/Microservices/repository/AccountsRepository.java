package com.example.Microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Microservices.model.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

  Optional<Accounts> findByAccountNumber(String accountNo);


}
