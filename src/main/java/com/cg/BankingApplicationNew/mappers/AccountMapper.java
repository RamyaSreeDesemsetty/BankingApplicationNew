package com.cg.BankingApplicationNew.mappers;

import com.cg.BankingApplicationNew.dtos.AccountDto;
import com.cg.BankingApplicationNew.entities.Accounts;

public class AccountMapper {
	/*
	 * public static Accounts mapToAccount(AccountDto accountDto, Accounts account)
	 * { account.setAccountHolderName(accountDto.getAccountHolderName());
	 * account.setAccountNumber(accountDto.getAccountNumber());
	 * account.setAccountType(accountDto.getAccountType());
	 * account.setBalance(accountDto.getBalance()); return account;
	 * 
	 * }
	 * 
	 * public static AccountDto mapToAccountDto(Accounts account, AccountDto
	 * accountdto) {
	 * accountdto.setAccountHolderName(account.getAccountHolderName());
	 * accountdto.setAccountNumber(account.getAccountNumber());
	 * accountdto.setAccountType(account.getAccountType());
	 * accountdto.setBalance(account.getBalance()); return accountdto; }
	 */

	public static Accounts mapToAccount(AccountDto accountDto) {
		Accounts account = new Accounts();
		account.setId(accountDto.getId());
		account.setAccountHolderName(accountDto.getAccountHolderName());
		account.setAccountNumber(accountDto.getAccountNumber());
		account.setAccountType(accountDto.getAccountType());
		account.setBalance(accountDto.getBalance());
		return account;
	}

	public static AccountDto mapToAccountDto(Accounts account) {
		AccountDto accountDto = new AccountDto();
		accountDto.setId(account.getId());
		accountDto.setAccountHolderName(account.getAccountHolderName());
		accountDto.setAccountNumber(account.getAccountNumber());
		accountDto.setAccountType(account.getAccountType());
		accountDto.setBalance(account.getBalance());
		return accountDto;
	}
}
