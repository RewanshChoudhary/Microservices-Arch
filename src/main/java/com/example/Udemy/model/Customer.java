package com.example.Udemy.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer{
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long customerId;
  @Column(name="customer_name")

  private String name;
  @Column(name="customer_email")

  private String email;

  @Column(name="mobile_number")
  private String mobileNumber;



}
