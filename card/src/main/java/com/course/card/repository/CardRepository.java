package com.course.card.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.card.model.Cards;

@Repository
public interface CardRepository extends JpaRepository<Cards, Integer> {
  Optional<Cards> findByMobileNumber(String mobileNumber);

}
