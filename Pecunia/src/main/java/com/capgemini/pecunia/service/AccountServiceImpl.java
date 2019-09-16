package com.capgemini.pecunia.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.model.Account;
import com.capgemini.pecunia.model.Address;
import com.capgemini.pecunia.model.Customer;
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
//	    		Transaction t=new Transaction(arr[0],date1,arr[2],arr[3],amount,closeBal);
//	    		transactionList.add(t);
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
   
	public String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
				String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity,
				String addressState, String addressCountry, String addressZipcode, String accountType,
				double accountBalance, double accountInterest, java.sql.Date lastUpdated, String accountBranchId) {

			try {	
				if( customerName== null || customerAadhar== null || customerPan== null || customerContact== null || customerGender== null
						|| customerDob==null ||addressLine1 == null || addressLine2 == null|| addressCity== null ||
								addressState == null || addressCountry== null || addressZipcode== null || accountType== null ||
								 lastUpdated== null ||accountBranchId == null)
				{
					throw new InvalidParameterException("All fields compulsory");
				}
				if(Pattern.matches("[0-9]", customerName))
				{
					throw new InvalidParameterException("Your name is a digit?");
				}		
				if(customerGender!= "Male" || customerGender!= "Female" || customerGender!="Prefer not to say" )	
				{
					throw new InvalidParameterException("Invalid Input");
				}
				if(Pattern.matches("[0-9]", addressCity))
				{
					throw new InvalidParameterException("Invalid Input");
				}

				if(Pattern.matches("[0-9]", addressState))
				{
					throw new InvalidParameterException("Invalid Input");
				}
				if(Pattern.matches("[0-9]", addressCountry))
				{
					throw new InvalidParameterException("Invalid Input");
				}

				if(accountType!= "Savings" || accountType!="FD" || accountType!="Current")
				{

					throw new InvalidParameterException("Invalid Input");
				}

				if(customerAadhar.length()!= 16 && Pattern.matches((".*[a-zA-Z]+.*"),customerAadhar))
				{
					throw new InvalidParameterException("Invalid Aadhar");
					//System.out.println("Invalid Aadhar");

				}

				if(customerPan.length()!=10)
				{
					throw new InvalidParameterException("Invalid PAN");
					//System.out.println("Invalid PAN");
				}
				if(customerContact.length()!=10 && Pattern.matches((".*[a-zA-Z]+.*"),customerContact) )
				{
					throw new InvalidParameterException("Invalid Contact Number");
					//			System.out.println("Invalid Number");
				}

				if(addressZipcode.length()!=6 && Pattern.matches((".*[a-zA-Z]+.*"),addressZipcode) )
				{
					throw new InvalidParameterException("Invalid Contact Number");
					//System.out.println("Invalid Zip");
				}
				if(accountBalance<0)
				{
					throw new InvalidParameterException("Invalid Account Balance");
					//		System.out.print("Invalid Balance");
				}
				if(accountInterest<0)
				{
					throw new InvalidParameterException("Invalid Account Interest");	
					//System.out.print("Invalid Interest");
				}

				Address add= new Address(addressLine1, addressLine2, addressCity, addressState,
						addressCountry,addressZipcode);

				String tempaddId =add.getAddressId(); //generating address Id

				Customer cust= new Customer(customerName, tempaddId,  customerAadhar,
						customerPan,  customerContact, customerGender, (java.sql.Date) customerDob);
				String tempcustId= cust.getCustomerAddressId(); //generating customer Id

				Account acc= new Account (tempcustId, accountBranchId, accountType,
						"Active",accountBalance, accountInterest, lastUpdated);

				return acc.getAccountId();
			}catch (Exception e) {
				throw new InvalidParameterException("Failure occured.");
//				return "Account not created!";
				// TODO: handle exception
			}
	//generating AccountId
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

	
	

