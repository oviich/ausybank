package fr.ausy.banking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.ausy.banking.Repository.IAccountRepository;
import fr.ausy.banking.exception.NoSuchAccountFoundException;
import fr.ausy.banking.exception.NotEnoughFundsException;
import fr.ausy.banking.model.Account;
import fr.ausy.banking.model.Operation;
import fr.ausy.banking.model.TypeOperation;

@Service
public class AccountOperationsImpl implements IAccountOperations{

	@Autowired
	IAccountRepository accountRepository;
	
	@Override
	public Account deposit(String accountId, Double amount) throws NoSuchAccountFoundException {
		Optional<Account> OptionnalAccount = accountRepository.findById(accountId);
		Account account = OptionnalAccount.get();

		if(account != null) {
			Operation op = new Operation(TypeOperation.Deposit, amount);
			account.setBalance(account.getBalance()+amount);
			account.getOperations().add(op);
			return account;
		}else {
			throw new NoSuchAccountFoundException();
		}
		
		
	}

	@Override
	public Account withdraw(String accountId, Double amount) throws NotEnoughFundsException,NoSuchAccountFoundException {
		
		Optional<Account> OptionnalAccount = accountRepository.findById(accountId);
		Account account = OptionnalAccount.get();

		if(account != null) {
			Operation op = new Operation(TypeOperation.Withdrawal, amount);
			if(account.getBalance() > amount) {
				account.setBalance(account.getBalance()-amount);
				account.getOperations().add(op);
				return account;
			}else {
				throw new NotEnoughFundsException();
			}
		}else {
			throw new NoSuchAccountFoundException();
		}
		
	}

	@Override
	public String getHistory(String accountId) throws NoSuchAccountFoundException{
		Optional<Account> OptionnalAccount = accountRepository.findById(accountId);
		Account account = OptionnalAccount.get();

		if(account != null) {
			return (displayHistory(account.getOperations()));
		}else {
			throw new NoSuchAccountFoundException();
		}
	}
	
	private String displayHistory(List<Operation> operations) {
		
		if(operations != null) {
			StringBuilder history = new StringBuilder();
			for(Operation op : operations) {
				
				history.append("Date : " +		op.getDateOperation());
				history.append(System.getProperty("line.separator"));
				history.append("Operation : " + op.getOperation());
				history.append(System.getProperty("line.separator"));
				history.append("Amount : " + 	op.getAmount());
				history.append(System.getProperty("line.separator"));
				history.append("--------");
			}
			return history.toString();
		}
		else {
			return "There is no operation";
		}
		
	}

}
