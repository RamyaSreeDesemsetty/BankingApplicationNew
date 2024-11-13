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

import com.cg.BankingApplicationNew.dtos.AccountDto;
import com.cg.BankingApplicationNew.entities.Accounts;
import com.cg.BankingApplicationNew.httpstatus.HttpStatusConstants;
import com.cg.BankingApplicationNew.services.AccountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountController {

	private AccountService accountService;

	@PostMapping("/create")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {
		return new ResponseEntity<>(accountService.createAccountDetails(accountDto), HttpStatus.CREATED);
	}

	@GetMapping("/getallaccounts")
	public ResponseEntity<List<Accounts>> getAllAccounts(){
		return ResponseEntity.status(HttpStatusConstants.OK).body(accountService.getAllAccountsDetails());
	}

	@GetMapping("/getaccountbyid/{id}")
	public ResponseEntity<AccountDto> getAccountById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatusConstants.OK).body(accountService.getAccountDetailsById(id));
	}

	@PutMapping("/updateaccountbyid/{id}")
	public ResponseEntity<AccountDto> updateAccountById(@PathVariable Long id, @RequestBody AccountDto accountDto) {
		return ResponseEntity.status(HttpStatusConstants.OK)
				.body(accountService.updateAccountDetailsById(id, accountDto));

	}

	@DeleteMapping("/deleteaccountbyid/{id}")
	public ResponseEntity<String> deleteAccountById(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatusConstants.OK).body(accountService.deleteAccountDetailsById(id));
	}
}
