package com.cg.BankingApplicationNew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.BankingApplicationNew.entities.Accounts;

@Repository
public interface AccountRepository extends JpaRepository<Accounts, Long> {

}
