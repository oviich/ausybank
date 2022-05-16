package fr.ausy.banking;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import fr.ausy.banking.exception.NoSuchAccountFoundException;
import fr.ausy.banking.exception.NotEnoughFundsException;
import fr.ausy.banking.service.IAccountOperations;

@SpringBootTest
@WebAppConfiguration
class AccountOperationsTest {
	
	@Autowired
	IAccountOperations accountOperations;

	@Test
	void depositWithGivenWrongAccountNumberThrowNoSuchAccountFoundException() {	
		double amount = 40000.0;
		Assertions.assertThrows(NoSuchAccountFoundException.class, () -> {
			accountOperations.deposit("-1", amount);
        });	
	}
	
	@Test
	void withdrawWithGivenWrongAccountNumberThrowNoSuchAccountFoundException() {	
		double amount = 40000.0;
		Assertions.assertThrows(NoSuchAccountFoundException.class, () -> {
			accountOperations.withdraw("-1", amount);
        });	
	}
	
	@Test
	void withdrawWithNotEnoughFundsThrowNotEnoughFundsException() {	
		double amount = 4000000000000000000000000000000000000000000000000000000000000000000000000.0;
		String accountId = "1";
		Assertions.assertThrows(NotEnoughFundsException.class, () -> {
			accountOperations.withdraw(accountId, amount);
        });	
	}
}
