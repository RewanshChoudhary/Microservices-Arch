package com.course.card.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CardRequestDto {

  private String cardNumber;
  private String cardType;

  private int amountUsed;
  private int availableAmount;
  private int totalLimit;
  private String mobileNumber;

}
