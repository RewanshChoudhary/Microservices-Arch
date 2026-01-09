package com.example.Udemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Udemy.model.Accounts;


public interface AccountsRepository extends JpaRepository<Accounts,Long>{
    
}

