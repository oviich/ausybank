package fr.ausy.banking.service;

import org.springframework.stereotype.Service;

import fr.ausy.banking.exception.NoSuchAccountFoundException;
import fr.ausy.banking.exception.NotEnoughFundsException;
import fr.ausy.banking.model.Account;

@Service
public interface IAccountOperations {
	
	Account deposit (String accountId, Double amount) throws NoSuchAccountFoundException ;
	Account withdraw(String accountId, Double amount) throws NotEnoughFundsException,NoSuchAccountFoundException;
	String getHistory(String accountId) throws NoSuchAccountFoundException;

}
