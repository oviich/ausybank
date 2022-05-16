package fr.ausy.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.ausy.banking.exception.NoSuchAccountFoundException;
import fr.ausy.banking.exception.NotEnoughFundsException;
import fr.ausy.banking.model.Account;
import fr.ausy.banking.service.IAccountOperations;

@RestController
@RequestMapping(path = "/account")
public class AccountController {
	
	
	@Autowired
	IAccountOperations accountOperations;
	
	@PostMapping(path= "/deposit", consumes = "application/json", produces = "application/json")
    public Account deposit(@RequestBody String accountId, @RequestBody Double amount ) throws NoSuchAccountFoundException 
    {
		Account account = accountOperations.deposit(accountId, amount);
         
		return account;
    }
	
	@PostMapping(path= "/withdraw", consumes = "application/json", produces = "application/json")
    public Account withdraw(@RequestBody String accountId, @RequestBody Double amount ) throws NoSuchAccountFoundException, NotEnoughFundsException 
    {
		Account account = accountOperations.withdraw(accountId, amount);
         
		return account;
    }
	
	@GetMapping(path= "/history", consumes = "application/json", produces = "application/json")
    public String history(@RequestBody String accountId) throws NoSuchAccountFoundException
    {
		return accountOperations.getHistory(accountId);
    }

}
