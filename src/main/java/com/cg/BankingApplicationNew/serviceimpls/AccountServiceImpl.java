package com.cg.BankingApplicationNew.serviceimpls;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.BankingApplicationNew.dtos.AccountDto;
import com.cg.BankingApplicationNew.entities.Accounts;
import com.cg.BankingApplicationNew.exceptions.AccountNotFoundException;
import com.cg.BankingApplicationNew.mappers.AccountMapper;
import com.cg.BankingApplicationNew.repositories.AccountRepository;
import com.cg.BankingApplicationNew.services.AccountService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accountRepository;
	/*
	 * @Override public AccountDto createAccountDetails(AccountDto accountDto) {
	 * Accounts account = AccountMapper.mapToAccount(accountDto, new Accounts());
	 * Accounts savedAccount = accountRepository.save(account); return
	 * AccountMapper.mapToAccountDto(savedAccount,accountDto); }
	 */

	@Override
	public AccountDto createAccountDetails(AccountDto accountDto) {
		Accounts account = AccountMapper.mapToAccount(accountDto);
		Accounts savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
	@Override
	public List<Accounts> getAllAccountsDetails() {

		return accountRepository.findAll();
	}

	@Override
	public AccountDto getAccountDetailsById(Long id) throws AccountNotFoundException {
		Optional<Accounts> accountExists = accountRepository.findById(id);
		if (accountExists.isEmpty()) {
			throw new AccountNotFoundException("Account Not Found By " + id);
}

		Accounts account = accountExists.get();
	
return AccountMapper.mapToAccountDto(account);
}

@Override
public AccountDto updateAccountDetailsById(Long id, AccountDto accountDto) {

	Optional<Accounts> accountExists = accountRepository.findById(id);
	if (accountExists.isEmpty()) {
		throw new AccountNotFoundException("Account Not Found By " + id);
	}
	Accounts account = accountExists.get();
	account.setAccountHolderName(accountDto.getAccountHolderName());
	account.setAccountNumber(accountDto.getAccountNumber());
	account.setAccountType(accountDto.getAccountType());
	account.setBalance(accountDto.getBalance());

	Accounts savedAccount = accountRepository.save(account);
	return AccountMapper.mapToAccountDto(savedAccount);
}

@Override
public String deleteAccountDetailsById(Long id) {

	Optional<Accounts> accountExists = accountRepository.findById(id);
	if (accountExists.isEmpty()) {
		throw new AccountNotFoundException("Account Not Found By " + id);
	}

	accountRepository.deleteById(id);
	return "Account with " + id + " deleted successfully";
}


	}



