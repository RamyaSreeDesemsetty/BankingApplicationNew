package com.cg.BankingApplicationNew.exceptions;


public class CardNotFoundException extends RuntimeException {
	public CardNotFoundException(String message) {
		super(message);
	}
}
