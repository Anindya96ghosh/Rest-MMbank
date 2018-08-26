package com.rest.bank.pojo;


public class PaymentGateway {
	
	public static boolean transfer(BankAccount sender, BankAccount reciever, double amount) {
	
		boolean status;
		if (sender.getAccountBalance() >= amount) {
			sender.withdraw(amount);
			reciever.deposit(amount);
			status = true;
		} else {
			status = false;
		}
		return status;
	}
}