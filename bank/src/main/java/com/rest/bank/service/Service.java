package com.rest.bank.service;

import java.util.List;

import com.rest.bank.pojo.BankAccount;

public interface Service {

	void addBankAccount(BankAccount bankAccount);
	//Customer addCustomer(Customer customer);
	List<BankAccount> viewAllAccounts();
//	List<Customer> viewAllCustomers();
	BankAccount searchAccountById(int num);
	boolean FundTransfer(int senderAccNo, int recieverAccNo, int amount);
	

}