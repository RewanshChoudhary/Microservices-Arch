package com.course.card.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@AllArgsConstructor

@NoArgsConstructor
@Builder
@Entity
@Table(name = "cards")
public class Cards {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "card_id")
  private Integer cardId;

  @Column(name = "mobile_number", nullable = false)
  private String mobileNumber;

  @Column(name = "card_number", unique = true, nullable = false)
  private String cardNumber;

  @Column(name = "card_type")
  private String cardType;

  @Column(name = "total_limit")
  private Integer totalLimit;

  @Column(name = "amount_used")
  private Integer amountUsed;

  @Column(name = "available_amount")
  private Integer availableAmount;

  @Column(name = "created_at", updatable = false)
  @CreationTimestamp
  private LocalDateTime createdAt;

  @Column(name = "created_by")
  @CreatedBy
  private String createdBy;

  @Column(name = "updated_by")
  private String updatedBy;

  @Column(name = "updated_at")
  @LastModifiedDate

  private LocalDateTime updatedAt;
}
