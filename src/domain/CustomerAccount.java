package domain;

public class CustomerAccount {
	private Long	   		customer_id;
	private String    		first_name;
	private Double    		credit;
	
	
	public CustomerAccount(Long customer_id, String first_name, Double credit) {
		// TODO Auto-generated constructor stub
	}
	
	
    
	public String toString() {
		return "Account [customer_id=" + customer_id + ", firstname=" + first_name + ", creditlimit=" + credit +"]\n";
	}


	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public Double getCredit() {
		return credit;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}


}
