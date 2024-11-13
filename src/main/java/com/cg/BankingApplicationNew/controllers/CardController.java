package com.cg.BankingApplicationNew.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.BankingApplicationNew.dtos.CardDto;
import com.cg.BankingApplicationNew.entities.Cards;
import com.cg.BankingApplicationNew.httpstatus.HttpStatusConstants;
import com.cg.BankingApplicationNew.services.CardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/card")
public class CardController {

	private CardService cardService;

	// create card
	@PostMapping("/createcard")
	public ResponseEntity<CardDto> createCard(@RequestBody CardDto cardDto) {
		return new ResponseEntity<CardDto>(cardService.createCardDetails(cardDto), HttpStatus.CREATED);
	}

	// Get all cards
	@GetMapping("/getallcards")
	public ResponseEntity<List<Cards>> getAllCards() {
		return ResponseEntity.status(HttpStatusConstants.OK).body(cardService.getallcardsDetails());
	}

	// Get card By id
	@GetMapping("/getcardbyid/{id}")
	public ResponseEntity<CardDto> getCardById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatusConstants.OK).body(cardService.getCardDetailsById(id));
	}

	// Update card details by id
	@PutMapping("/updatecardbyid/{id}")
	public ResponseEntity<CardDto> updateCardById(@PathVariable Long id, @RequestBody CardDto cardDto) {
		return ResponseEntity.status(HttpStatusConstants.OK).body(cardService.updateCardDetailsById(id, cardDto));
	}

	// Delete card by id
	@DeleteMapping("/deletecardbyid/{id}")
	public ResponseEntity<String> deleteCardById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatusConstants.OK).body(cardService.deleteCardDetailsById(id));
	}

	// find card by number
	@GetMapping("/findcardbynumber/{number}")
	public ResponseEntity<CardDto> findCardByNumber(@PathVariable String number) {
		return ResponseEntity.status(HttpStatusConstants.OK).body(cardService.findCardDetailsByNumber(number));
	}
}
