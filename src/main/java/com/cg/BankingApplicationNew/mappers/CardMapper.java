package com.cg.BankingApplicationNew.mappers;

import com.cg.BankingApplicationNew.dtos.CardDto;
import com.cg.BankingApplicationNew.entities.Cards;

public class CardMapper {

	public static Cards mapToCard(CardDto cardDto) {
		Cards card = new Cards();
		card.setCardId(cardDto.getCardId());
		card.setCardNumber(cardDto.getCardNumber());
		card.setCardType(cardDto.getCardType());
		card.setExpiryDate(cardDto.getExpiryDate());
		return card;
	}

	public static CardDto mapToCardDto(Cards card) {
		CardDto cardDto = new CardDto();
		cardDto.setCardId(card.getCardId());
		cardDto.setCardNumber(card.getCardNumber());
		cardDto.setCardType(card.getCardType());
		cardDto.setExpiryDate(card.getExpiryDate());
		return cardDto;
	}

}
