package com.capgemini.pecunia.service;

import java.util.Date;

import com.capgemini.pecunia.dao.AccountDAOImpl;

public class AccountServiceImpl implements AccountService {

	@Override
	public boolean deleteAccount(String accountId) {
		// TODO Auto-generated method stub
		AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
		accountDAOImpl.deleteAccount(accountId);
		return false;
	}

	@Override
	public boolean updatePassbook(String accountId) {
		// TODO Auto-generated method stub
		AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
		accountDAOImpl.updatePassbookOne(accountId);
		return false;
	}

	@Override
	public boolean updateCustomerName(String accountId, String newName) {
		// TODO Auto-generated method stub
		AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
		accountDAOImpl.updateCustomerName(accountId, newName);
		return false;
	}

	@Override
	public boolean updateCustomerContact(String accountId, String newContact) {
		// TODO Auto-generated method stub
		AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
		accountDAOImpl.updateCustomerContact(accountId, newContact);
		return false;
	}

	@Override
	public boolean updateCustomerAddress(String accountId, String addressLine1, String addressLine2, String addressCity,
			String addressState, String addressCountry, String addressZipcode) {
		// TODO Auto-generated method stub
		AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
		accountDAOImpl.updateCustomerAddress(accountId, addressLine1, addressLine2, addressCity, addressState, addressCountry, addressZipcode);
		return false;
	}

	@Override
	public String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
			String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity,
			String addressState, String addressCountry, String addressZipcode, String accountType,
			double accountBalance, double accountInterest, Date lastUpdated, String accountBranchId) {
		// TODO Auto-generated method stub
		AccountDAOImpl accountDAOImpl = new AccountDAOImpl();
		accountDAOImpl.addAccount(customerName, customerAadhar, customerPan, customerContact, customerGender, customerDob, addressLine1, addressLine2, addressCity, addressState, addressCountry, addressZipcode, accountType, accountBalance, accountInterest, lastUpdated, accountBranchId);
		return null;
	}

	

}


