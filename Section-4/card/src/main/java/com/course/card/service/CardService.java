package com.course.card.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.course.card.dto.CardRequestDto;
import com.course.card.exception.CardAlreadyExistsException;
import com.course.card.exception.ResourceNotFoundException;
import com.course.card.mapper.CardsMapper;
import com.course.card.model.Cards;
import com.course.card.repository.CardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardService {
  private final CardRepository cardRepository;

  public void createCard(String mobileNumber) {
    Optional<Cards> entry = cardRepository.findByMobileNumber(mobileNumber);
    if (entry.isPresent())
      throw new CardAlreadyExistsException("Card already exists for the given mobile number");

    Cards card = Cards.builder().mobileNumber(mobileNumber)
        .cardType("credit")
        .amountUsed(0)
        .availableAmount(5000)
        .totalLimit(5000)
        .build();
    cardRepository.save(card);

  }

  public CardRequestDto getCard(String mobileNumber) {
    Optional<Cards> entry = cardRepository.findByMobileNumber(mobileNumber);
    if (!entry.isPresent())
      throw new ResourceNotFoundException("Card ", "MobileNumber", mobileNumber);
    CardRequestDto card = new CardRequestDto();

    CardsMapper.mapToCardsDto(entry.get(), card);
    return card;

  }

  public void updateCard(CardRequestDto cardRequestDto) {
    Optional<Cards> entry = cardRepository.findByMobileNumber(cardRequestDto.getMobileNumber());
    if (!entry.isPresent())
      throw new ResourceNotFoundException("Card", "Mobile Number", cardRequestDto.getMobileNumber());
    Cards card = entry.get();
    card.setCardType(cardRequestDto.getCardType());
    card.setTotalLimit(cardRequestDto.getTotalLimit());

  }

  public void deleteCard(String mobileNumber, String cardNumber) {

    Optional<Cards> entry = cardRepository.findByCardNumber(cardNumber);
    if (!entry.isPresent())
      throw new ResourceNotFoundException("Card", "Card number ", cardNumber);
    cardRepository.delete(entry.get());

  }
}
