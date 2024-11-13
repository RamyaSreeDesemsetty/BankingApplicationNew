package com.cg.BankingApplicationNew.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {

	private Long id;
	private String accountNumber;
	private String accountHolderName;
	private String accountType;

	private double balance;
}
