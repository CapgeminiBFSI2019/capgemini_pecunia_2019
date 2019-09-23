package com.capgemini.pecunia.service;

import java.util.ArrayList;
import java.util.Date;

import com.capgemini.pecunia.model.Transaction;

public interface AccountService {


public boolean deleteAccount(String accountId);
public boolean updatePassbook(String accountId);
public boolean updateCustomerName(String accountId, String newName);
public boolean updateCustomerContact(String accountId, String newContact);
public boolean updateCustomerAddress(String accountId, String addressLine1, String addressLine2, String addressCity, 
	String addressState, String addressCountry, String addressZipcode);
//
public String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
	String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity,
	String addressState, String addressCountry, String addressZipcode, String accountType,
	double accountBalance, double accountInterest, Date lastUpdated, String accountBranchId);
	
}
