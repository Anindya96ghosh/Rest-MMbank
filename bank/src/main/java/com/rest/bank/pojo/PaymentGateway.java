package com.rest.bank.pojo;

import com.rest.bank.repo.BankRepository;

public class PaymentGateway {

	static BankRepository bankRepository;
	public static boolean transfer(BankAccount sender, BankAccount receiver, double amount) {


		boolean status;
		if (sender.getAccountBalance() >= amount) {
			sender.withdraw(amount);
			bankRepository.save(bankRepository.findById(sender.getAccountNumber()).get());
			receiver.deposit(amount);
			bankRepository.save(bankRepository.findById(receiver.getAccountNumber()).get());

			status = true;
		} else {
			status = false;
		}
		return status;
	}
}