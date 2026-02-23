package com.course.card.mapper;

import com.course.card.dto.CardRequestDto;
import com.course.card.model.Cards;

public class CardsMapper {

  public static CardRequestDto mapToCardsDto(Cards cards, CardRequestDto cardsDto) {
    cardsDto.setCardNumber(cards.getCardNumber());
    cardsDto.setCardType(cards.getCardType());
    cardsDto.setMobileNumber(cards.getMobileNumber());
    cardsDto.setTotalLimit(cards.getTotalLimit());
    cardsDto.setAvailableAmount(cards.getAvailableAmount());
    cardsDto.setAmountUsed(cards.getAmountUsed());
    return cardsDto;
  }

  public static Cards mapToCards(CardRequestDto cardsDto, Cards cards) {
    cards.setCardNumber(cardsDto.getCardNumber());
    cards.setCardType(cardsDto.getCardType());
    cards.setMobileNumber(cardsDto.getMobileNumber());
    cards.setTotalLimit(cardsDto.getTotalLimit());
    cards.setAvailableAmount(cardsDto.getAvailableAmount());
    cards.setAmountUsed(cardsDto.getAmountUsed());
    return cards;
  }

}
