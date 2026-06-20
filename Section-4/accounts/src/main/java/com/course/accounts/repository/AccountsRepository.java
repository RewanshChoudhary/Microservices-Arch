package com.course.accounts.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.accounts.model.Accounts;

public interface AccountsRepository extends JpaRepository<Accounts, Long> {

  Optional<Accounts> findByAccountNumber(Long accountNo);


}
