package persistence;

import domain.CustomerAccount;
import domain.CustomerAccountException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerAccountRepository {
	
	// attention: end of line use a space
	private final static String SQL_SELECT_ALL =
			"SELECT CUSTOMER_ID, " +
		    "       FIRST_NAME, " +
		    "       CREDIT " +
		    "FROM   CUSTOMER";
	
	private PreparedStatement selectAllStatement;

	// SELECT ALL -------------------------------------------------------------
	public List<CustomerAccount> selectAll( Connection con ) throws CustomerAccountException {
		try {
			// prepare statement if not prepared before
			if ( selectAllStatement == null ) {
				selectAllStatement = con.prepareStatement( SQL_SELECT_ALL );
			}
			//selectAllStatement.executeUpdate();    UPDATES data returns number of rows
			//selectAllStatement.executeQuery();     SELECT returns data
			ResultSet resultSet = selectAllStatement.executeQuery();
			if ( resultSet != null )
			{	
				List<CustomerAccount> accounts = new ArrayList<>();
				while( resultSet.next() )
				{	
					Long customer_id = resultSet.getLong( 1 );
					String first_name = resultSet.getString( 2 );				
					Double credit = resultSet.getDouble( 5 );
					accounts.add( new CustomerAccount( customer_id, first_name, credit ));					
				}
				return accounts;
			}
			else {
				throw new CustomerAccountException( "Could not read data from database" );
			}
			
		} catch ( SQLException e ) {
			throw new CustomerAccountException( "Could not execute SQL statement" );
		}
	}

}