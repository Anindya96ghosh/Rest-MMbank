package com.rest.bank.pojo;



public abstract class CurrentAccount extends BankAccount {
	private double odLimit;


	public CurrentAccount(String accHolderName, double accountBalance, double odLimit) {
		super(accHolderName, accountBalance);
		this.odLimit = odLimit;
	}

	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getOdLimit() {
		return odLimit;
	}

	public void setOdLimit(double odLimit) {
		this.odLimit = odLimit;
	}

	public abstract String withdraw(double amount);
	
	@Override
	public String toString() {
		return "CurrentAccount [odLimit=" + odLimit + ", toString()=" + super.toString() + "]";
	}	
}
