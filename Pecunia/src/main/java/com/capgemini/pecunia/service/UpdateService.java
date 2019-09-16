package com.capgemini.pecunia.service;


public interface UpdateService {
	
	public boolean updateCustomerName(String accountId, String newName);
	public boolean updateCustomerContact(String accountId, String newContact);
	public boolean updateCustomerAddress(String accountId, String addressLine1, String addressLine2, String addressCity, 
			String addressState, String addressCountry, String addressZipcode);

}
