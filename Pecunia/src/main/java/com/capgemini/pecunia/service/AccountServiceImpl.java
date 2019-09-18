package com.capgemini.pecunia.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidParameterException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.Values;
import com.capgemini.pecunia.model.Account;
import com.capgemini.pecunia.model.Address;
import com.capgemini.pecunia.model.Customer;
import com.capgemini.pecunia.model.Transaction;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

public class AccountServiceImpl implements AccountService {

	public static ArrayList<Transaction> updatePassbookOne(String accountId){
       
		try 
		{
			//reads data from csv file and storing in array list
		File file = new File("Transaction.csv");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line;
        
		ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
		while ((line = br.readLine()) != null) {
			String arr[] = line.split(","); //storing the data in the arr
			
			String updatedDate1 = updateCurrentDate(accountId); // calling the function to get the current date
			boolean ans = getUpdatedTrans(arr[5], updatedDate1); // calling function to get the updated transaction details
			if (arr[1].equals(accountId) && ans == true) {
				Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse(arr[5]); 
				double amount = Integer.parseInt(arr[4]);
				double closeBal = Integer.parseInt(arr[9]);
				Transaction t = new Transaction(arr[0], arr[1], arr[2], arr[3], amount, date1, arr[6], arr[7], arr[8],
						closeBal);
				transactionList.add(t); // return the list of transactions
			}
		}
		br.close();
		return transactionList;
		}
		catch (Exception e) 
		{
			return null;
		}
	}
    // function to get the updated transaction details
	public static boolean getUpdatedTrans(String transDate, String updatedDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date currentDate = new Date();
		String strDate = formatter.format(currentDate);

		if (transDate.compareToIgnoreCase(updatedDate) > 0 && transDate.compareToIgnoreCase(strDate) < 0) {
			return true;
		} else
			return false;
	}
    //function to get the current date and return it
	public static String updateCurrentDate(String accountId) throws Exception {
		File file = new File("Account.csv");
		BufferedReader br1 = new BufferedReader(new FileReader(file));
		String line1;
		while ((line1 = br1.readLine()) != null) {
			String arr1[] = line1.split(",");
			if (arr1[0].equals(accountId)) {
				return arr1[7];
			}
		}
		br1.close();
		return "Account Id not found";
	}


	
	public  String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
			String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity,
			String addressState, String addressCountry, String addressZipcode, String accountType,
			double accountBalance, double accountInterest, Date lastUpdated, String accountBranchId) {

		try {	
			DateFormat dateFormat = new SimpleDateFormat(Values.DATE_FORMAT);
			if( customerName== null || customerAadhar== null || customerPan== null || customerContact== null || customerGender== null
					|| customerDob==null ||addressLine1 == null || addressLine2 == null|| addressCity== null ||
							addressState == null || addressCountry== null || addressZipcode== null || accountType== null ||
							 lastUpdated== null ||accountBranchId == null) //checking if all fields compulsory
		
			{
				throw new InvalidParameterException("All fields compulsory");
			}
			if(Pattern.matches(".*[0-9]+.*", customerName) || Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*",customerName ))
			{
				throw new InvalidParameterException("Your name is a digit?");
			}		
			if(customerGender!= "Male" || customerGender!= "Female" || customerGender!="Prefer not to say" )	
			{
				throw new InvalidParameterException("Invalid Input");
			}
			if(Pattern.matches(".*[0-9]+.*", addressCity) ||  Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*",addressCity))
			{
				throw new InvalidParameterException("Invalid Input");
			}

			if(Pattern.matches(".*[0-9]+.*", addressState) ||  Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*",addressState))
			{
				throw new InvalidParameterException("Invalid Input");
			}
			if(Pattern.matches(".*[0-9]+.*", addressCountry) ||  Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*",addressCountry))
			{
				throw new InvalidParameterException("Invalid Input");
			}

			if(accountType!= "Savings" || accountType!="FD" || accountType!="Current")
			{

				throw new InvalidParameterException("Invalid Input");
			}

			if(customerAadhar.length()!= 12 && Pattern.matches((".*[a-zA-Z]+.*"),customerAadhar) ||  Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*",customerAadhar))
			{
				throw new InvalidParameterException("Invalid Aadhar");
				//System.out.println("Invalid Aadhar");

			}

			if(customerPan.length()!=10 ||  Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*",customerPan))
			{
				throw new InvalidParameterException("Invalid PAN");
				//System.out.println("Invalid PAN");
			}
			if(customerContact.length()!=10 || Pattern.matches((".*[a-zA-Z]+.*"),customerContact) ||  Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*",customerContact))
			{
				throw new InvalidParameterException("Invalid Contact Number");
				//			System.out.println("Invalid Number");
			}

			if(addressZipcode.length()!=6 || Pattern.matches((".*[a-zA-Z]+.*"),addressZipcode) || Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*",addressZipcode)) 
			{
				throw new InvalidParameterException("Invalid Zipcode");
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
			String inputAcc;
			String inputCust;
			String inputAddr;
			int countCust=0, countAcc=0, countAddr=0;
			String addressId = Utility.getAlphaNumericString(20);
			Address add= new Address(addressId,addressLine1, addressLine2, addressCity, addressState,
					addressCountry,addressZipcode);
			Path FILE_PATH = Paths.get("Address.csv");
			BufferedReader bufferedReaderAddr = new BufferedReader(new FileReader("Address.csv"));
			List<String> fileContentAddr = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
			while((inputAddr = bufferedReaderAddr.readLine()) != null) {
				countAddr++;
			}
			fileContentAddr.set(countAddr+1,add.getAddressId()+","+add.getAddressLine1()+","+add.getAddressLine2()+","+
							add.getAddressCity()+","+add.getAddressState()+","+add.getAddressCountry()+","+
							add.getAddressZipcode());
	        Files.write(FILE_PATH, fileContentAddr, StandardCharsets.UTF_8);
			bufferedReaderAddr.close();
			

			String tempaddId =add.getAddressId(); //generating address Id
			String custid = Utility.getAlphaNumericString(20);
			Customer cust= new Customer(custid,customerName, tempaddId,  customerAadhar,
					customerPan,  customerContact, customerGender, (java.sql.Date) customerDob);
			FILE_PATH = Paths.get("Customer.csv"); //reading the csv file and storing in a list
			BufferedReader bufferedReaderCust = new BufferedReader(new FileReader("Customer.csv"));
			List<String> fileContentCust = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
			while((inputCust = bufferedReaderCust.readLine()) != null) //reading till the end of line 
				{
				countCust++; //increasingthecount
				}
			fileContentCust.set(countCust+1,cust.getCustomerId()+","+cust.getCustomerName()+","+cust.getCustomerAddressId()+
							","+cust.getCustomerAadhar()+","+cust.getCustomerPan()+","+cust.getCustomerContact()+
							","+cust.getCustomerGender()+","+cust.getCustomerDob());
	        Files.write(FILE_PATH, fileContentCust, StandardCharsets.UTF_8); 
			bufferedReaderCust.close();  //closing
			
			String tempcustId= cust.getCustomerAddressId(); //generating customer Id
			
			String accId = Utility.getAlphaNumericString(20);
			Account acc= new Account (accId,tempcustId, accountBranchId, accountType,
					"Active",accountBalance, accountInterest, lastUpdated);
			FILE_PATH = Paths.get("Account.csv");
			BufferedReader bufferedReaderAcc = new BufferedReader(new FileReader("Account.csv"));
			List<String> fileContentAcc = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
			while((inputAcc = bufferedReaderAcc.readLine()) != null) {
				countAcc++;
			}
			fileContentAcc.set(countAcc+1,acc.getAccountId()+","+acc.getAccountHolderId()+","+acc.getAccountBranchId()+
								","+acc.getAccountType()+","+acc.getAccountStatus()+","+acc.getAccountBalance()+
								","+acc.getAccountInterest()+","+acc.getLastUpdated());
	        Files.write(FILE_PATH, fileContentAcc, StandardCharsets.UTF_8);
			bufferedReaderAcc.close();

			return acc.getAccountId();
		}catch (Exception e) {
			throw new InvalidParameterException("Failure occured.");
//			return "Account not created!";
			// TODO: handle exception
		}
//generating AccountId
}


	@Override
	public boolean deleteAccount(String accountId) {

		int countAcc = 0;
		String inputAcc;
		String[] arrAcc = new String[50];
		try {
			if(accountId==null || accountId.equals("")) {
				throw new Exception();
			}
			boolean validated = validateAccountId(accountId);
			if (validated) {
				Path FILE_PATH = Paths.get("Account.csv");
				BufferedReader bufferedReaderAcc = new BufferedReader(new FileReader("Account.csv"));
				List<String> fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
				while ((inputAcc = bufferedReaderAcc.readLine()) != null) {
					arrAcc = inputAcc.split(",");
					if (arrAcc[0] == accountId) {
						arrAcc[3] = "Closed";
						break;
					}
					countAcc++;
				}
				String newData = String.join(",", arrAcc);
				fileContent.set(countAcc, newData);
				Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);
				bufferedReaderAcc.close();
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean updatePassbook(String accountId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean validateAccountId(String accountId) {
		String inputAcc = null;
		if (accountId != null && !accountId.isEmpty() && accountId.length() == 14) {
			if (accountId.matches("^[0-9]+$")) {
				try {
					Path FILE_PATH = Paths.get("Customer.csv");
					BufferedReader bufferedReaderAcc = new BufferedReader(new FileReader("Account.csv"));
					List<String> fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
					while ((inputAcc = bufferedReaderAcc.readLine()) != null) {
						String[] arrAcc = inputAcc.split(",");
						if (arrAcc[0] == accountId) {
							return true;
						}
					}
				} catch (Exception e) {
					return false;

			}

		}
			}
			
			
		return false;

		// implemented

	}

	@Override
	public boolean validateAccountName(String accountName) {
		String[] Nametmp = accountName.split("\\s+");
		if (accountName != null && !accountName.isEmpty()) {
			if (Nametmp[0].matches("[A-Za-z]+") && Nametmp[1].matches("[A-Za-z]+")) {
				return true;
			} else {
				return false;
			}

	}
		return false;

	}

	@Override
	public boolean validateTransAmt(Double transAmt){
		
		if(transAmt==null || transAmt<0.00 || transAmt> 1000000.00 || transAmt<50.00)
		return false;
		else {
			return true;			
		}
	}


	@Override
	public boolean validateChequeNum(Integer ChequeNum) {
		if (ChequeNum != null && Integer.toString(ChequeNum).length() == 6)
			return true;
		else
			return false;
		
	}

		public boolean updateCustomerName(String accountId, String newName) {
			try {	
				if( newName== null)
				{
					throw new InvalidParameterException("New name has to be given");
				}
				if(Pattern.matches(".*[0-9]+.*", newName) || Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*", newName))
				{
					throw new InvalidParameterException("Your name has a digit?");
				}
			}catch(Exception e) {
				throw new InvalidParameterException("Failure occured.");
			}
			String inputAcc = null;
			String inputCust = null;
			String arrCust[] = new String[40];
			int countAcc=0;
			int countCust=0;
			String customerRow=null;
			try {
				Path FILE_PATH = Paths.get("Customer.csv");
				BufferedReader bufferedReaderAcc = new BufferedReader(new FileReader("Account.csv"));
				List<String> fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
				while((inputAcc = bufferedReaderAcc.readLine()) != null)
			    {
				    String[] arrAcc = inputAcc.split(",");
				    if(arrAcc[0] == accountId)
			    	{
					BufferedReader bufferedReaderCust = new BufferedReader(new FileReader("Customer.csv"));
					while((inputCust = bufferedReaderCust.readLine())!=null) {
						arrCust = inputCust.split(",");
		    			if(arrCust[0]==arrAcc[1]) {
			    			customerRow = inputCust;
			    			break;
			    		}
			    		countCust++;
			    	}
			    	bufferedReaderCust.close();
			    	break;
			    	}
				    countAcc++;
			    }
				arrCust[1] = newName;
				String newDataName = String.join(",",arrCust);
		        fileContent.set(countCust,newDataName);
		        Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);
				bufferedReaderAcc.close();
				return true;
				}catch(Exception e) {
					return false;
				}
			}


	@Override
	public boolean updateCustomerContact(String accountId, String newContact) {
		try {	
			if( newContact== null)
			{
				throw new InvalidParameterException("New number has to be given");
			}
			if(newContact.length()!=10 || Pattern.matches(".*[a-zA-Z]+.*",newContact) || Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*", newContact))
			{
				throw new InvalidParameterException("Invalid Contact Number");
			}
		}catch(Exception e) {
			throw new InvalidParameterException("Failure occured.");
		}
		String inputAcc = null;
		String inputCust = null;
		String arrCust[] = new String[40];
		int countAcc=0;
		int countCust=0;
		String customerRow=null;
		try {
			Path FILE_PATH = Paths.get("Customer.csv");
			BufferedReader bufferedReaderAcc = new BufferedReader(new FileReader("Account.csv"));
			List<String> fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
			while((inputAcc = bufferedReaderAcc.readLine()) != null)
		    {
			    String[] arrAcc = inputAcc.split(",");
			    if(arrAcc[0] == accountId)
		    	{
				BufferedReader bufferedReaderCust = new BufferedReader(new FileReader("Customer.csv"));
				while((inputCust = bufferedReaderCust.readLine())!=null) {
					arrCust = inputCust.split(",");
		    		if(arrCust[0]==arrAcc[1]) {
		    			customerRow = inputCust;
		    			break;
		    		}
		    		countCust++;
		    	}
		    	bufferedReaderCust.close();
		    	break;
		    	}
			    countAcc++;
		    }
			arrCust[1] = newContact;
			String newDataName = String.join(",",arrCust);
	        fileContent.set(countCust,newDataName);
	        Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);
			bufferedReaderAcc.close();
			return true;
			}catch(Exception e) {
				return false;
			}
		}

	public boolean updateCustomerAddress(String accountId, String addressLine1, String addressLine2,
			String addressCity, String addressState, String addressCountry, String addressZipcode) 
	{
		try {	
			if(addressLine1 == null || addressLine2 == null|| addressCity== null ||
					addressState == null || addressCountry== null || addressZipcode== null)
			{
				throw new InvalidParameterException("Fill all the fields");
			}
			if(Pattern.matches(".*[0-9]+.*", addressCity) || Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*", addressCity))
			{
				throw new InvalidParameterException("Invalid City");
			}

			if(Pattern.matches(".*[0-9]+.*", addressState) || Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*", addressState))
			{
				throw new InvalidParameterException("Invalid State");
			}
			if(Pattern.matches(".*[0-9]+.*", addressCountry) || Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*", addressCountry))
			{
				throw new InvalidParameterException("Invalid Country");
			}
			if(addressZipcode.length()!=6 || Pattern.matches(".*[a-zA-Z]+.*",addressZipcode) || Pattern.matches(".*[!@#$%&*()_+=|<>?{}.\\[\\]~-]+.*", addressZipcode))
			{
				throw new InvalidParameterException("Invalid Zipcode");
			}
		}catch(Exception e) {
			throw new InvalidParameterException("Failure occured.");
		}
		String inputAcc = null;
		String inputCust = null;
		String inputAddr = null;
		String arrCust[] = new String[40];
		String arrAddr[] = new String[40];
		String arrAcc[] = new String[40];
		int countAcc=0;
		int countCust=0;
		int countAddr=0;
		String customerRow=null;
		try {
			Path FILE_PATH = Paths.get("Address.csv");
			BufferedReader bufferedReaderAcc = new BufferedReader(new FileReader("Account.csv"));
			List<String> fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
			while((inputAcc = bufferedReaderAcc.readLine()) != null)
		    {
			    arrAcc = inputAcc.split(",");
			    if(arrAcc[0] == accountId)
		    	{
				BufferedReader bufferedReaderCust = new BufferedReader(new FileReader("Customer.csv"));
		    	while((inputCust = bufferedReaderCust.readLine())!=null) {
		    		arrCust = inputCust.split(",");
	    		 	if(arrCust[0]==arrAcc[1]) {
		    			BufferedReader bufferedReaderAddr = new BufferedReader(new FileReader("Address.csv"));
		    			while((inputAddr = bufferedReaderAddr.readLine())!=null) {
		    				arrAddr = inputAddr.split(",");
		    				if(arrAddr[0]==arrCust[2]) {
		    					customerRow = inputCust;
				    			break;
		    				}
				    	}
		    			countAddr++;
		    			bufferedReaderAddr.close();
		    		}
		    		countCust++;
		    	}
		    	bufferedReaderCust.close();
		    	break;
		    	}
			    countAcc++;  
		    }
			arrAddr[1] = addressLine1;
			arrAddr[2] = addressLine2;
			arrAddr[3] = addressCity;
			arrAddr[4] = addressState;
			arrAddr[5] = addressCountry;
			arrAddr[6] = addressZipcode;   //adding address
			
			String newData = String.join(",",arrAddr);
	        fileContent.set(countCust,newData);
	        Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);  //writing
			bufferedReaderAcc.close();
			return true;
			
		}catch(Exception e) {
			return false;
		}
	}
//
//	@Override
//	public String addAccount(String customerName, String customerAadhar, String customerPan, String customerContact,
//			String customerGender, Date customerDob, String addressLine1, String addressLine2, String addressCity,
//			String addressState, String addressCountry, String addressZipcode, String accountType,
//			double accountBalance, double accountInterest,  lastUpdated, String accountBranchId) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}


