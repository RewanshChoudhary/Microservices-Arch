package com.course.card.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.course.card.constants.CardsConstants;
import com.course.card.dto.CardRequestDto;
import com.course.card.dto.ResponseDto;
import com.course.card.service.CardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
  private final CardService cardService;

  @PostMapping("/create")
  public ResponseEntity<ResponseDto> createCard(@RequestParam String mobileNumber) {
    cardService.createCard(mobileNumber);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));

  }

  @GetMapping("/detail")
  public ResponseEntity<ResponseDto> getCard(@RequestParam String mobileNumber) {
    cardService.getCard(mobileNumber);
    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));

  }

  @PutMapping("/update")
  public ResponseEntity<ResponseDto> updateCard(@RequestBody CardRequestDto cardRequestDto) {
    cardService.updateCard(cardRequestDto);

    return ResponseEntity.status(HttpStatus.CREATED)
        .body(new ResponseDto(CardsConstants.STATUS_200, CardsConstants.MESSAGE_200));

  }
}
