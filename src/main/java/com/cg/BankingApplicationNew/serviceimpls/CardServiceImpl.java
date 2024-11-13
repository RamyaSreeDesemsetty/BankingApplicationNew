package com.cg.BankingApplicationNew.serviceimpls;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.BankingApplicationNew.dtos.CardDto;
import com.cg.BankingApplicationNew.entities.Cards;
import com.cg.BankingApplicationNew.exceptions.CardNotFoundException;
import com.cg.BankingApplicationNew.mappers.CardMapper;
import com.cg.BankingApplicationNew.repositories.CardRepository;
import com.cg.BankingApplicationNew.services.CardService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CardServiceImpl implements CardService {

	private CardRepository cardRepository;

//create card
	@Override
	public CardDto createCardDetails(CardDto cardDto) {
		Cards card = CardMapper.mapToCard(cardDto);
		Cards savedCard = cardRepository.save(card);

		return CardMapper.mapToCardDto(savedCard);
	}

//Get all cards
	@Override
	public List<Cards> getallcardsDetails() {
		return cardRepository.findAll();
	}

//Get card By id
	@Override
	public CardDto getCardDetailsById(Long id) {
		Optional<Cards> cardExists = cardRepository.findById(id);
		if (cardExists.isEmpty()) {
			throw new CardNotFoundException("Card Not found With Id " + id);
		}
		Cards card = cardExists.get();
		return CardMapper.mapToCardDto(card);
	}

//Update card details by id
	@Override
	public CardDto updateCardDetailsById(Long id, CardDto cardDto) {

		Optional<Cards> cardExists = cardRepository.findById(id);
		if (cardExists.isEmpty()) {
			throw new CardNotFoundException("Card Not found With Id " + id);
		}
		Cards card = cardExists.get();

		card.setCardNumber(cardDto.getCardNumber());
		card.setCardType(cardDto.getCardType());
		card.setExpiryDate(cardDto.getExpiryDate());

		Cards savedCard = cardRepository.save(card);
		return CardMapper.mapToCardDto(savedCard);
	}

//Delete card by id
	@Override
	public String deleteCardDetailsById(Long id) {

		Optional<Cards> cardExists = cardRepository.findById(id);
		if (cardExists.isEmpty()) {
			throw new CardNotFoundException("Card Not found With Id " + id);
		}
		cardRepository.deleteById(id);
		return "Card With " + id + " Deleted successfully ";
	}

	@Override
	public CardDto findCardDetailsByNumber(String number) {
		Optional<Cards> numberExists = Optional.of(cardRepository.findByCardNumber(number));
		if (numberExists.isEmpty()) {
			throw new CardNotFoundException("Card Not Found with " + number);
		}
		Cards card = numberExists.get();
		return CardMapper.mapToCardDto(card);
	}

}
