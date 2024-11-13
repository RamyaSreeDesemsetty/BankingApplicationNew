package com.cg.BankingApplicationNew.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.BankingApplicationNew.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
