package com.cg.BankingApplicationNew.services;

import java.util.List;

import com.cg.BankingApplicationNew.dtos.AccountDto;
import com.cg.BankingApplicationNew.entities.Accounts;

public interface AccountService {

	AccountDto createAccountDetails(AccountDto accountDto);

	List<Accounts> getAllAccountsDetails();

	AccountDto getAccountDetailsById(Long id);

	AccountDto updateAccountDetailsById(Long id, AccountDto accountDto);

	String deleteAccountDetailsById(Long id);
}
