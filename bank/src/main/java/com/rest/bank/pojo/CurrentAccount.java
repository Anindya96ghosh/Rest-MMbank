package com.rest.bank.pojo;



public abstract class CurrentAccount extends BankAccount {
	private int odLimit;


	public CurrentAccount(String accHolderName, double accountBalance, int odLimit) {
		super(accHolderName, accountBalance,odLimit);
		this.odLimit = odLimit;
	}

	public CurrentAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getOdLimit() {
		return odLimit;
	}

	public void setOdLimit(int odLimit) {
		this.odLimit = odLimit;
	}

	public abstract String withdraw(double amount);
	
	@Override
	public String toString() {
		return "CurrentAccount [odLimit=" + odLimit + ", toString()=" + super.toString() + "]";
	}	
}
