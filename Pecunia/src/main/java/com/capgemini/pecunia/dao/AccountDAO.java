package com.capgemini.pecunia.dao;

import java.util.Date;

public interface AccountDAO {
	public boolean deleteAccount(String accountId);
	public boolean updatePassbook(String accountId);
	public boolean validateAccountId(String accountId);
	public boolean validateAccountName(String accountName);
	public boolean validateTransAmt(Double transAmt);
	public boolean validateChequeNum(Integer ChequeNum);
	public boolean updateCustomerName(String accountId, String newName);
	public boolean updateCustomerContact(String accountId, String newContact);
	public boolean updateCustomerAddress(String accountId, String addressLine1, String addressLine2, String addressCity, 
			String addressState, String addressCountry, String addressZipcode);
	
	public String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
			String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity,
			String addressState, String addressCountry, String addressZipcode, String accountType,
			double accountBalance, double accountInterest, Date lastUpdated, String accountBranchId);
}
