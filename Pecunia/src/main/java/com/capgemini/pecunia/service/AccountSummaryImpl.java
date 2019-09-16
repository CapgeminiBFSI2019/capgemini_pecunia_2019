package com.capgemini.pecunia.service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

import com.capgemini.pecunia.model.Transaction;

public class AccountSummaryImpl implements AccountService {



	public ArrayList<Transaction> getAccountSummary(String accountId, Date startDate, Date endDate)throws Exception
	{
		String[] arrTrans = new String[10];
		ArrayList<Transaction> l= new ArrayList<Transaction>();
		String line;
		Calendar c = Calendar.getInstance();
        c.setTime(startDate);
		File file = new File("Transaction.csv");
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    while((line = br.readLine())!= null)
        {
	    	arrTrans = line.split(",");
	    	double amount = Integer.parseInt(arrTrans[4]);
            double closeBal = Integer.parseInt(arrTrans[9]);
            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(arrTrans[5]); 
    	   Transaction t = new Transaction(arrTrans[0],arrTrans[1],arrTrans[2],arrTrans[3],amount,
    			   				date1, arrTrans[6],arrTrans[7],arrTrans[8],closeBal);
    	   if(t.getTransDate()==startDate) {
    		   while(t.getTransDate().compareTo(endDate)<0) {
    			   l.add(t);
        		   c.add(Calendar.DATE, 1);
    		   }
    	   }
        }
	    br.close();
		
		return l;
		}

	public String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
			String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity,
			String addressState, String addressCountry, String addressZipcode, String accountType, String accountStatus,
			double accountBalance, double accountInterest, Date lastUpdated) {
		// TODO Auto-generated method stub
		return null;
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

	@Override
	public String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
			String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity,
			String addressState, String addressCountry, String addressZipcode, String accountType,
			double accountBalance, double accountInterest, java.sql.Date lastUpdated, String accountBranchId) {
		// TODO Auto-generated method stub
		return null;
	}

}

	

	
