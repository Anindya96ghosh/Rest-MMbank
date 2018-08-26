package com.rest.bank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.bank.pojo.BankAccount;
import com.rest.bank.pojo.PaymentGateway;
import com.rest.bank.repo.BankRepository;

@Component
public class ServiceImpl implements Service {
	@Autowired
	BankRepository bankRepository;

/*	@Autowired
	CustomerRepository customerRepository;
*/
	@Override
	public void addBankAccount(BankAccount bankAccount) {
		System.out.println(bankAccount);
		bankRepository.save(bankAccount);
	}

	@Override
	public List<BankAccount> viewAllAccounts() {
		return bankRepository.findAll();
	}

	@Override
	public boolean FundTransfer(int senderAccNo, int recieverAccNo, int amount) {
		return PaymentGateway.transfer(bankRepository.findById(senderAccNo).get(), bankRepository.findById(recieverAccNo).get(), amount);
	}

/*	@Override
	public Customer addCustomer(Customer customer) {
		Customer cust=customerRepository.save(customer);
		return cust;
	}
*/
/*	@Override
	public List<Customer> viewAllCustomers() {

		return customerRepository.findAll();
	}*/

	@Override
	public BankAccount searchAccountById(int num) {

		return bankRepository.findById(num).get();
	}

	public String withdraw(int accNo, double amount) {
		String bank=	bankRepository.findById(accNo).get().withdraw(amount);
		bankRepository.save(bankRepository.findById(accNo).get());
		return bank;
	}

	public void deposit(int accNo, double amount) {
		bankRepository.findById(accNo).get().deposit(amount);
		bankRepository.save(bankRepository.findById(accNo).get());
		}

	/*
	 * public void updateAccount(BankAccount bankAcc) {
	 * 
	 * 
	 * }
	 * 
	 * 
	 * public void deleteAccount(int accNo) {
	 * 
	 * }
	 */
}