package fr.ausy.banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ausy.banking.model.Client;

public interface IClientRepository extends JpaRepository<Client, Long>{

}
