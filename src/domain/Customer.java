package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {
	private List<CustomerAccount> accounts;
	
	public Customer() {
		accounts = new ArrayList<>();
	}	
		
	public void add(CustomerAccount a) {
		accounts.add(a);
	}
	
	public void clear() {
		accounts.clear();
	}

	public void remove(CustomerAccount a) {
		accounts.remove(a);
	}

	public void remove(CustomerAccount... acc) {
		for (CustomerAccount a: acc) {
			remove(a);
		}
	}

	public void add(CustomerAccount... acc) {
		for (CustomerAccount a: acc) {
			add(a);
		}
	}
	
	public void addAll( List<CustomerAccount> accountList ) {
		accounts.addAll( accountList );
	}
	
	public List<CustomerAccount> getAccounts(){
		return Collections.unmodifiableList( accounts );
	}

	@Override
	public String toString() {
		return "Bank [accounts=" + accounts + "]";
	}
}
