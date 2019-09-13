package com.capgemini.pecunia.service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.capgemini.pecunia.model.Transaction;

public class AccountServiceImpl {

	public ArrayList<Transaction> updatePassbook(String accountId) throws Exception 
	{
	
		 File file = new File("Transaction.csv");
	        BufferedReader br = new BufferedReader(new FileReader(file));
	        String line;
	      
	        ArrayList<Transaction> transactionList= new ArrayList<Transaction>();
	        while((line = br.readLine())!= null)
	        {
	        	String arr[] = line.split(",");
	        	if(arr[0].equals(accountId))
	        	{
	        		Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(arr[1]);
	            double amount = Integer.parseInt(arr[4]);
	            double closeBal = Integer.parseInt(arr[5]);
	    		Transaction t=new Transaction(arr[0],date1,arr[2],arr[3],amount,closeBal);
	    		transactionList.add(t);
	        	}
	        }
	        br.close();
	        return transactionList;
	}
}
