package com.capgemini.pecunia.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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

	public boolean editAccount(String accountId) {
		Scanner scanner = new Scanner(System.in);
		try {
			Path FILE_PATH = null;
			BufferedReader bufferedReaderAcc = new BufferedReader(new FileReader("Account.csv"));
			List<String> fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
			boolean validated = validateAccountId(accountId);
			if(validated) {
				String inputAcc = null;
				String inputCust = null;
				String inputAddr = null;
				String arrCust[] = new String[40];
				String arrAddr[] = new String[40];
				String customerRow = null;
				int countAcc=0;
				int countCust=0;
				int countAddr=0;
			    while((inputAcc = bufferedReaderAcc.readLine()) != null)
			    {
				    String[] arrAcc = inputAcc.split(",");
				    if(arrAcc[0] == accountId)
			    	{
					BufferedReader bufferedReaderCust = new BufferedReader(new FileReader("Customer.csv"));
					FILE_PATH = Paths.get("Customer.csv");
			    	while((inputCust = bufferedReaderCust.readLine())!=null) {
			    		if(arrCust[0]==arrAcc[1]) {
			    			customerRow = inputCust;
			    			arrCust = inputCust.split(",");
				    		break;
			    		}
			    		countCust++;
			    	}
			    	bufferedReaderCust.close();
			    	}
				    countAcc++;
			    }
				System.out.println("Enter the field to be changed: 1. Name \n"
										+ "2. Contact \n"
										+ "3. Address");
				int choice = scanner.nextInt();
			    switch(choice) {
				case 1: 
					System.out.println("Enter new name: ");
					String newName = scanner.nextLine();
					arrCust[1] = newName;
					String newDataName = String.join(",",arrCust);
			        fileContent.set(countCust,newDataName);
			        return true;
				case 2:
					System.out.println("Enter new contact number: ");
					String newNumber = scanner.nextLine();
					arrCust[5] = newNumber;
					String newDataContact = String.join(",",arrCust);
			        fileContent.set(countCust,newDataContact);
			        return true;
				case 3:
					BufferedReader bufferedReaderAddr = new BufferedReader(new FileReader("Address.csv"));
					FILE_PATH = Paths.get("Address.csv");
			    	while((inputAddr = bufferedReaderAddr.readLine())!=null) {
			    		if(arrAddr[0]==arrCust[2]) {
			    			customerRow = inputCust;
			    			arrAddr = inputAddr.split(",");
				    		break;
			    			}
			    		countAddr++;
			            }
					System.out.println("Enter address line 1:");
					arrAddr[1]= scanner.nextLine();
					System.out.println("Enter address line 2:");
					arrAddr[2]= scanner.nextLine();
					System.out.println("Enter City:");
					arrAddr[3]= scanner.nextLine();
					System.out.println("Enter State:");
					arrAddr[4]= scanner.nextLine();
					System.out.println("Enter Country:");
					arrAddr[5]= scanner.nextLine();
					System.out.println("Enter Zipcode:");
					arrAddr[6]= scanner.nextLine();
					String newData = String.join(",",arrAddr);
			        fileContent.set(countAddr,newData);
			        bufferedReaderAddr.close();
			        return true;
				}
			    }
			Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);
			bufferedReaderAcc.close();
			return true;
		} 
		     catch (Exception e) 
		     {
		            //TODO: handle exception
		            System.out.println("Error occured");
		            return false;
		     }
		finally {
			scanner.close();
		}
			
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
