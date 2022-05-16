package fr.ausy.banking.service;

import org.springframework.stereotype.Service;

import fr.ausy.banking.model.Client;

@Service
public interface IClientOperations {

	//keeping it extensible so a client can have multiple account 
	//Here we can put client operations. ex : create/delete Account, beneficiary (for bank transfer), etc..
	
	Client getClient(int clientId);
	
}
