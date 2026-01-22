package com.example.Microservices.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Accounts extends BaseEntity {
  @Column(name = "customer_id", nullable = false)
  private Long customerId;

  @Id
  @Column(name = "account_number")
  private Long accountNumber;

  @Column(name = "account_type")

  private String accountType;

  @Column(name = "branch_address")
  private String branchAddress;

}
