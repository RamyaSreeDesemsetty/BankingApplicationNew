package com.cg.BankingApplicationNew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BankingApplicationNew.entities.Cards;

public interface CardRepository extends JpaRepository<Cards, Long> {

	Cards findByCardNumber(String number);

}
