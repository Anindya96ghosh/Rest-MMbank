package com.rest.bank.account.pojo;

import javax.persistence.Entity;

import com.rest.bank.pojo.SavingsAccount;

@Entity
public class MMSavingsAccount extends SavingsAccount {

	public MMSavingsAccount()
	{
		super();
	}
	//public static CustomerRepository customerRepository;
	public MMSavingsAccount(String accHolderName, double accountBalance, boolean salary) {
		super(accHolderName, accountBalance, salary);
	}
	@Override
	public String withdraw(double amount) {
		String denominations;
		if(amount <= (this.getAccountBalance() - super.getMINIMUM_BALANCE())) {
			this.setAccountBalance(this.getAccountBalance() - amount);
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
			denominations = "Does not meet Minimum Balance Requirement";
		}
		return denominations;
	}
	public void deposit(double amount) {
		super.deposit(amount);
	}
}
