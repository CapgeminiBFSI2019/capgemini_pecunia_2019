package com.capgemini.pecunia.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UpdateServiceImpl implements UpdateService {

	@Override
	public boolean updateCustomerName(String accountId, String newName) {
		Scanner scanner = new Scanner(System.in);
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
			}finally {
				scanner.close();
			}
		}

	@Override
	public boolean updateCustomerContact(String accountId, String newContact) {
		Scanner scanner = new Scanner(System.in);
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
			}finally {
				scanner.close();
			}
		}

	public boolean updateCustomerAddress(String accountId, String addressLine1, String addressLine2,
			String addressCity, String addressState, String addressCountry, String addressZipcode) 
	{
		Scanner scanner = new Scanner(System.in);
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
		    			while((inputCust = bufferedReaderCust.readLine())!=null) {
		    				arrAddr = inputAddr.split(",");
		    				if(arrAddr[0]==arrCust[2]) {
		    					customerRow = inputCust;
				    			break;
		    				}
				    	}
		    			countAddr++;
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
			arrAddr[6] = addressZipcode;
			
			String newData = String.join(",",arrAddr);
	        fileContent.set(countCust,newData);
	        Files.write(FILE_PATH, fileContent, StandardCharsets.UTF_8);
			bufferedReaderAcc.close();
			return true;
			
		}catch(Exception e) {
			return false;
		}finally {
			scanner.close();
		}
	}
	}
