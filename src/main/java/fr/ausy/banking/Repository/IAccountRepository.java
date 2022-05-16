package fr.ausy.banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ausy.banking.model.Account;

public interface IAccountRepository extends JpaRepository<Account, String>{

}
