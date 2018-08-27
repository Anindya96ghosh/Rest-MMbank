package com.rest.bank.account.pojo;

import javax.persistence.Entity;

import com.rest.bank.pojo.CurrentAccount;

@Entity
public class MMCurrentAccount extends CurrentAccount {
	
	public MMCurrentAccount()
	{
		super();
	}
//	static CustomerRepository customerRepository;

	public MMCurrentAccount(String accHolderName, double accountBalance, int odLimit) {
		super(accHolderName, accountBalance, odLimit);
		
	}
	@Override
	public String withdraw(double amount){
		String denominations;
		if(amount <= (this.getAccountBalance() + getOdLimit())) {
			this.setAccountBalance(this.getAccountBalance()- amount);
				int thousand = (int)amount/1000;
				amount = amount%1000;
				int fiveHundred = (int)amount/500;
				amount = amount%500;
				int hundred = (int)amount/100;
				amount = amount%100;
				int fifty = (int)amount/50;
				amount = amount%50;
				denominations = "No of thousand notes "+ thousand +"\nNo of five hundred notes "+fiveHundred+"\nNo of Hundred notes"+ hundred +
						"\n No of fifty notes "+ fifty + ".";
		}
		else
		{
			denominations = "Exceeds OD Limit";
		}
		return denominations;
	}
	public void deposit(double amount) {
		super.deposit(amount);
	}
	
	
}
