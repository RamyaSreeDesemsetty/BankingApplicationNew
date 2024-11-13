package com.cg.BankingApplicationNew.services;

import java.util.List;

import com.cg.BankingApplicationNew.dtos.CardDto;
import com.cg.BankingApplicationNew.entities.Cards;

public interface CardService {

	CardDto createCardDetails(CardDto cardDto);

	List<Cards> getallcardsDetails();

	CardDto getCardDetailsById(Long id);

	CardDto updateCardDetailsById(Long id, CardDto cardDto);

	String deleteCardDetailsById(Long id);

	CardDto findCardDetailsByNumber(String number);

}
