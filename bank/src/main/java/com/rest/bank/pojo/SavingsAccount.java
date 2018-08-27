package com.rest.bank.pojo;


public abstract class SavingsAccount extends BankAccount {
	private boolean salary;
	private double minBal;

	public SavingsAccount(String accHolderName, double accountBalance, boolean salary) {
		super(accHolderName, accountBalance,salary);
		this.salary = salary;
		//this.MINIMUM_BALANCE = 10000;
	}


	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean isSalary() {
		return salary;
	}


	public void setSalary(boolean salary) {
		this.salary = salary;
		if(salary)
			this.minBal =0;
		else
			this.minBal = 10000;
	}
//	public double getMinBal() {
//		return minBal;
//	}

	
	
	public abstract String withdraw(double amount);
	@Override
	public String toString() {
		return "SavingsAccount [salary=" + salary + ", toString()=" + super.toString() + "]";
	}
}
