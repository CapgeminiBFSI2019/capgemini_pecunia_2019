package com.capgemini.pecunia.service;

import java.util.Date;

public interface AccountService {
	public String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
			String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity, String addressState,
			String addressCountry, String addressZipcode, String accountType, String accountStatus, double accountBalance,
			double accountInterest, Date lastUpdated);
	
	public boolean editAccount(String accountId);
	public boolean deleteAccount(String accountId);
}
