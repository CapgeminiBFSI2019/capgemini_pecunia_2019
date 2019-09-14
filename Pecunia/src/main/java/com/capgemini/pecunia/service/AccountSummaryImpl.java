package com.capgemini.pecunia.service;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.capgemini.pecunia.model.Transaction;

public class AccountSummaryImpl implements AccountService {



	public ArrayList<Transaction> getAccountSummary(String accountId, Date startDate, Date endDate)throws Exception
	{
		while(startDate.compareTo(endDate)<0)
		{
		   ArrayList<Transaction>l= new ArrayList<Transaction>();
		   l=AccountServiceImpl.updatePassbookOne(accountId);
		   Calendar c = Calendar.getInstance();
	        c.setTime(startDate);
	        c.add(Calendar.DATE, 1);
	        
			
		}
			return null;
		}

	@Override
	public String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
			String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity,
			String addressState, String addressCountry, String addressZipcode, String accountType, String accountStatus,
			double accountBalance, double accountInterest, Date lastUpdated) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean editAccount(String accountId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteAccount(String accountId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePassbook(String accountId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateAccountId(String accountId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateAccountName(String accountName) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateTransAmt(Double transAmt) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateChequeNum(Integer ChequeNum) {
		// TODO Auto-generated method stub
		return false;
	}

	}


