package com.rest.bank.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class BankAccount {
	@Id
	private final int accountNumber;
	// private int customerId;
	private String accountHolderName;
	private double accountBalance;
	private boolean salary;
	private int odLimit;
//	private double minBal;
	// private int odLimit;
	// private boolean
	/*
	 * public BankAccount(int odLimit) { super(); this.setOdLimit(odLimit); }
	 */

	/*
	 * private boolean salary; public BankAccount(boolean salary) { super();
	 * this.setSalary(salary); }
	 */

	// maintains the next accountNumber
	private static int accountId;

	

	

	// gets invoked whenever a class is loaded
	static {
		accountId = 100;
	}

	{
		this.accountNumber = ++accountId;
	}

	public BankAccount(String accHolderName, double accountBalance, int odLimit) {
		this.accountHolderName = accHolderName;
		this.accountBalance = accountBalance;
		this.odLimit = odLimit;
	}

	public BankAccount(String accHolderName, double accountBalance, boolean salary) {
		this.accountHolderName = accHolderName;
		this.accountBalance = accountBalance;
		this.salary = salary;
		//this.MINIMUM_BALANCE=MINIMUMBALANCE;
	}

	
	/*
	 * public BankAccount(Customer accountHolder) { this.accountHolder =
	 * accountHolder; }
	 */

	public BankAccount() {
		// TODO Auto-generated constructor stub
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	/*
	 * public Customer getCustomer() { return accountHolder; } public void
	 * setAccountHolder(Customer accountHolder) { this.accountHolder =
	 * accountHolder; }
	 */
	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public static int getNextAccountNumber() {
		return accountId + 1;
	}

	/*
	 * public int getCustomerId() { return customerId; }
	 * 
	 * public void setCustomerId(int customerId) { this.customerId = customerId; }
	 */

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public void deposit(double amount) {
		if (amount > 0)
			this.accountBalance += amount;
	}

	public String FundTransfer(BankAccount account, double amount) {
		String result;
		if (PaymentGateway.transfer(this, account, amount))
			result = "Transaction Successful";
		else
			result = "Transaction Failed";
		return result;
	}

	public abstract String withdraw(double amount);

	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolderName
				+ ", accountBalance=" + accountBalance + "]";
	}

	/*
	 * public int getOdLimit() { return odLimit; }
	 * 
	 * public void setOdLimit(int odLimit) { this.odLimit = odLimit; }
	 * 
	 * public boolean isSalary() { return salary; }
	 * 
	 * public void setSalary(boolean salary) { this.salary = salary; }
	 */

}