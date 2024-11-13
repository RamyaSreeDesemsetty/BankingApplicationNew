package com.cg.BankingApplicationNew.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardDto {

	private Long cardId;
	private String cardNumber;
	private String cardType;
	private String expiryDate;

}
