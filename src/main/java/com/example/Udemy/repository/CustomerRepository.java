package com.example.Udemy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Udemy.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
   Optional<Boolean> findByEmail(String email);
 
}
