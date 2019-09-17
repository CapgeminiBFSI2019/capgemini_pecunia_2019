package com.capgemini.pecunia.service;

import java.util.ArrayList;
import java.util.Date;

import com.capgemini.pecunia.model.Transaction;

public interface AccountService {
//	public String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
//			String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity, String addressState,
//			String addressCountry, String addressZipcode, double accountBalance,
//			double accountInterest, String accountType, Date lastUpdated, String accountBranchId);
	
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
			double accountBalance, double accountInterest, java.sql.Date lastUpdated, String accountBranchId);
	
}
