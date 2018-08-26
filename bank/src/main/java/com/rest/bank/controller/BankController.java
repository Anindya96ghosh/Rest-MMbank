package com.rest.bank.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.bank.pojo.BankAccount;
import com.rest.bank.service.ServiceImpl;

@RestController
public class BankController {
	
	@Autowired
	private ServiceImpl service; 
	
	
	
	@RequestMapping(value="/bank/addAccount", method=RequestMethod.POST, consumes="application/json")
	public void addBankAccount(@RequestBody BankAccount bankAcc) {
		System.out.println(service);
		service.addBankAccount(bankAcc);
	}
	
	/*@RequestMapping(value="/bank/addCustomer", method=RequestMethod.POST, consumes="application/json")
	public void addCustomer(@RequestBody Customer customer) {
		System.out.println(service);
		service.addCustomer(customer);
	}*/
	
	
	
	@RequestMapping(value="/viewAllAccounts", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public Collection<BankAccount> viewAllAccounts() {
		return service.viewAllAccounts();
		
	}
	
	
	/*@RequestMapping(value="/viewAllCustomer", method=RequestMethod.GET, produces=MediaType.ALL_VALUE)
	public Collection<Customer> viewAllCustomer() {
		return service.viewAllCustomers();
		
	}*/
	
	
	
	@RequestMapping(value="/withdraw/{accNo}/{amount}", method=RequestMethod.PUT)
	public BankAccount withdraw(@PathVariable int accNo, @PathVariable int amount) {
		service.withdraw(accNo, amount);
		return service.searchAccountById(accNo);
	}
	
	@RequestMapping(value="/deposit/{accNo}/{amount}", method=RequestMethod.PUT)
	public BankAccount deposit(@PathVariable int accNo, @PathVariable int amount) {
		service.deposit(accNo, amount);
		return service.searchAccountById(accNo);

	}
	@RequestMapping(value="/fundTransfer/{receiverAccNo}/{senderAccNo}/{amount}", method=RequestMethod.PUT)
	public void fundTransfer(@PathVariable int receiverAccNo, @PathVariable int senderAccNo, @PathVariable int amount) {
		
		
		service.FundTransfer(receiverAccNo,senderAccNo, amount);
		
	}
	
	/*@RequestMapping(value="/bank/update", method=RequestMethod.PUT, consumes="application/json")
	public void updateCustomer(@RequestBody BankAccount bankAcc) {
		service.updateAccount(bankAcc);
	}
	
	@RequestMapping(value="/bank/delete", method=RequestMethod.DELETE)
	public void deleteAccount(int accNo) {
		service.deleteAccount(accNo);
	}
	*/
/*	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/bank/{start}/{count}", method=RequestMethod.GET)
	public Resources getAccountsByPages(@PathVariable int start, @PathVariable int count) {
		List<BankAccount> tempAcc = service.viewAllAccounts();
		List<BankAccount> accounts = new ArrayList<>();
		for(int i = start; i<start+count; i++) {
			accounts.add(tempAcc.get(i));
		}
	
		Link nextLink = linkTo(methodOn(this.getClass()).getAccountsByPages(start+count, count)).withRel("Next Link");
		Link previousLink = linkTo(methodOn(this.getClass()).getAccountsByPages(start-count>=0?start-count:1, count)).withRel("Previous Link");
		
		return new Resources<>(accounts,nextLink,previousLink); 
		
	}*/
	
	/*@RequestMapping(value="/getById/{customerId}", method=RequestMethod.GET)
	public Resource<Customer> getById(@PathVariable int customerId){
		Resource<Customer> resource = null;
		for(Customer customer: service.viewAllCustomers()) {
			if(customer.getCustomerId() == customerId) {
				resource = new Resource<Customer>(customer);
			break;
			}
		}
		ControllerLinkBuilder link = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).viewAllCustomer());
		resource.add(link.withRel("All-Customers"));
		return resource;
		
	}*/
	
	@RequestMapping(value="/getByAccNo/{accNo}", method=RequestMethod.GET)
	public Resource<BankAccount> getByAccNo(@PathVariable int accNo){
		Resource<BankAccount> resource = null;
		for(BankAccount account: service.viewAllAccounts()) {
			if(account.getAccountNumber() == accNo) {
				resource = new Resource<BankAccount>(account);
			break;
			}
		}
		ControllerLinkBuilder link = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).viewAllAccounts());
		resource.add(link.withRel("All-Accounts"));
		return resource;
		
	}

	
	
	
	
}