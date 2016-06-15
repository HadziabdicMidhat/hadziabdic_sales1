package test;

import connection.OracleConnection;
import domain.Customer;
import domain.CustomerAccountException;
import service.CustomerAccountService;

public class B_TestSelect {

	public static void main(String[] args) {
		try {
			// create domain
			Customer bank = new Customer();
			
			// create oracle connection
			OracleConnection oracon = new OracleConnection();
			
			// create service layer
			CustomerAccountService bankAccountServ = new CustomerAccountService( oracon.getConnection() );
			
			// call service methods ...
			bankAccountServ.getBankAccounts( bank );
			
			// verify
			System.out.println( bank );
			
			oracon.close();
		} catch ( CustomerAccountException e ) {
			System.out.println( e.getMessage() );
		}
	}
}
