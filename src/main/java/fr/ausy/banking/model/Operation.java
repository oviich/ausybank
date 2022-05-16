package fr.ausy.banking.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Operation")
public class Operation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "operation")
	private TypeOperation operation;
	@Column(name = "dateOperation")
	private LocalDateTime dateOperation;
	@Column(name = "amount")
	private Double amount;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public TypeOperation getOperation() {
		return operation;
	}
	public void setOperation(TypeOperation operation) {
		this.operation = operation;
	}
	public LocalDateTime getDateOperation() {
		return dateOperation;
	}
	public void setDateOperation(LocalDateTime dateOperation) {
		this.dateOperation = dateOperation;
	}
	public Double getAmount() {
		return amount;
	}
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public Operation(TypeOperation typeOperation, Double amount) {
		this.dateOperation = LocalDateTime.now();	
		this.operation = typeOperation;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Operation [id=" + id + ", operation=" + operation + ", dateOperation=" + dateOperation + ", amount="
				+ amount + "]";
	}
	
}
