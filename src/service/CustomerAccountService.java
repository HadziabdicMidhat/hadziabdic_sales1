package service;

import java.sql.Connection;

import domain.Customer;
import domain.CustomerAccountException;
import persistence.CustomerAccountRepository;

public class CustomerAccountService {
	
	private Connection con;
	private CustomerAccountRepository bankAccountRep;
	
	public CustomerAccountService( Connection con ) {
		this.con = con;
		this.bankAccountRep = new CustomerAccountRepository();
	}
	
	public void getBankAccounts( Customer bank ) throws CustomerAccountException {
		bank.clear();
		bank.addAll( ((CustomerAccountRepository) bankAccountRep).selectAll( con ));
	}
}
