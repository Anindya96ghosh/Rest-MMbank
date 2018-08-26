package com.rest.bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.rest.bank.account.pojo.MMCurrentAccount;
import com.rest.bank.account.pojo.MMSavingsAccount;
import com.rest.bank.service.ServiceImpl;

@SpringBootApplication
public class BankApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}
	//CustomerRepository cust;
	   @Bean
	    public CommandLineRunner initialLoadData(ServiceImpl repository) {
			return (args) -> {
				/*repository.addCustomer(new MMCustomer("Nyaah", 9844540, "nyaah@gmail.com", "22/5/1990"));
				repository.addCustomer(new MMCustomer("Myra", 986755, "myra@gmail.com", "2/8/1990"));
				repository.addCustomer(new MMCustomer("Riya", 9877765, "riya@gmail.com", "22/10/1990"));
				repository.addCustomer(new MMCustomer("Alia", 980065, "alia@gmail.com", "12/7/1990"));
				repository.addCustomer(new MMCustomer("Amyra", 9766434, "amyra@gmail.com", "6/5/1990"));
				repository.addCustomer(new MMCustomer("Ryan", 9843433, "ryan@gmail.com", "18/5/1990"));
				repository.addCustomer(new MMCustomer("John", 9807655, "john@gmail.com", "30/5/1990"));
				repository.addCustomer(new MMCustomer("Charlie", 9987665, "charlie@gmail.com", "1/1/1990"));
				*/
				
				repository.addBankAccount(new MMCurrentAccount("Anindya",150000, 1000));
				repository.addBankAccount(new MMCurrentAccount("Sayali", 150000, 1000));
				repository.addBankAccount(new MMCurrentAccount("Pooja", 150000,1000));
				repository.addBankAccount(new MMCurrentAccount("Nishad", 150000, 1000));
				repository.addBankAccount(new MMCurrentAccount("Mehek", 150000, 1000));
				repository.addBankAccount(new MMSavingsAccount("John", 150000, false));
				repository.addBankAccount(new MMSavingsAccount("Divya", 150000, true));
				repository.addBankAccount(new MMSavingsAccount("Lokesh", 150000, false));
				System.out.println("Database initially loaded");
			};
	    	
	    }
}
