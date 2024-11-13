package com.cg.BankingApplicationNew.globalexceptionalhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.BankingApplicationNew.exceptions.AccountNotFoundException;
import com.cg.BankingApplicationNew.exceptions.CardNotFoundException;
import com.cg.BankingApplicationNew.httpstatus.HttpStatusConstants;

@RestControllerAdvice
public class GlobalExceptionalHandler {

	@ExceptionHandler(AccountNotFoundException.class)
	public ResponseEntity<String> handlesAccountNotFoundException(AccountNotFoundException ex) {
		return ResponseEntity.status(HttpStatusConstants.NOT_FOUND).body(ex.getMessage());
	}

	@ExceptionHandler(CardNotFoundException.class)
	public ResponseEntity<String> handleCardNotFoundException(CardNotFoundException ex) {
		return ResponseEntity.status(HttpStatusConstants.NOT_FOUND).body(ex.getMessage());
	}


}
