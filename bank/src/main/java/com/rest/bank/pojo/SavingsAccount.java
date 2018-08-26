package com.rest.bank.pojo;


public abstract class SavingsAccount extends BankAccount {
	private boolean salary;
	private double MINIMUM_BALANCE;

	public SavingsAccount(String accHolderName, double accountBalance, boolean salary) {
		super(accHolderName, accountBalance);
		this.salary = salary;
		this.MINIMUM_BALANCE = 10000;
	}


	public SavingsAccount() {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean isSalaryValue() {
		return salary;
	}
	public void setSalary(boolean salary) {
		this.salary = salary;
		if(salary)
			this.MINIMUM_BALANCE =0;
		else
			this.MINIMUM_BALANCE = 10000;
	}
	public double getMINIMUM_BALANCE() {
		return MINIMUM_BALANCE;
	}
	public void setMINIMUM_BALANCE(double mINIMUM_BALANCE) {
		MINIMUM_BALANCE = mINIMUM_BALANCE;
	}
	public abstract String withdraw(double amount);
	@Override
	public String toString() {
		return "SavingsAccount [salary=" + salary + ", toString()=" + super.toString() + "]";
	}
}
