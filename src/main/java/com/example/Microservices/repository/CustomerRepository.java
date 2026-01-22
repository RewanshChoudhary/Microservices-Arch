package com.example.Microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Microservices.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
  Optional<Boolean> findByEmail(String email);

  Optional<Customer> findByMobileNumber(String mobileNumber);

}
