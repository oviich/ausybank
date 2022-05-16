package fr.ausy.banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.ausy.banking.model.Operation;

public interface IOperationRepository extends JpaRepository<Operation, Long>{

}
