package com.rest.bank.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.bank.pojo.BankAccount;

public interface BankRepository extends JpaRepository<BankAccount, Integer> {

}
