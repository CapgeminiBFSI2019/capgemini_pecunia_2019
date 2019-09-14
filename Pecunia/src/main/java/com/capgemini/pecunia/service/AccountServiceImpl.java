package com.capgemini.pecunia.service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.model.Transaction;

public class AccountServiceImpl implements AccountService {

	public static ArrayList<Transaction> updatePassbookOne(String accountId) throws Exception 
	{
	
		 File file = new File("Transaction.csv");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String line;
	      
	        ArrayList<Transaction> transactionList= new ArrayList<Transaction>();
	        while((line = br.readLine())!= null)
	        {
	        	String arr[] = line.split(",");
	            String updatedDate1= updateCurrentDate(accountId);
	        	boolean ans = Utility.getUpdatedTrans(arr[1], updatedDate1);
	        	if(arr[0].equals(accountId) && ans==true )
	        	{
	        		Date date1=new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(arr[1]);
	            double amount = Integer.parseInt(arr[4]);
	            double closeBal = Integer.parseInt(arr[5]);
	    		Transaction t=new Transaction(arr[0],date1,arr[2],arr[3],amount,closeBal);
	    		transactionList.add(t);
	        	}
	        }
	        br.close();
	        return transactionList;
	}
	
	public static String updateCurrentDate(String accountId) throws Exception
	{
		    File file = new File("Account.csv");
	        BufferedReader br1 = new BufferedReader(new FileReader(file));
	        String line1;
	        while((line1 = br1.readLine())!= null)
	        {
	        	String arr1[] = line1.split(",");
	        	if(arr1[0].equals(accountId))
	        	{
	        		return arr1[7];
	        	}
	        }	
	        br1.close();
	        return "Account Id not found";
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
