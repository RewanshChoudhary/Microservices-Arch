package com.example.Udemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Udemy.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Long>{
    
}
