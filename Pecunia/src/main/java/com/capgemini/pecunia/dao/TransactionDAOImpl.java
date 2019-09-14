package com.capgemini.pecunia.dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import com.capgemini.pecunia.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO{

	@Override
	public String getTransactionId(File file) {
		// TODO Auto-generated method stub
		return "a";
	}

	@Override
	public String getCheckId(File file) {
		// TODO Auto-generated method stub
		return "a";
	}

	@Override
	public boolean isSufficientBalance(String accountId, double transactionAmount)  {
		// TODO Auto-generated method stub
		try
		{
//			System.out.println(System.getProperty("user.dir"));
			File file = new File("src/main/java/com/capgemini/pecunia/dao/DbFiles/Account.csv");
			// \src\main\java\com\capgemini\pecunia\dao\DbFiles
			BufferedReader br = new BufferedReader(new FileReader(file));
	        String line;
	        while((line = br.readLine())!= null)
	        {
	        	String arr[] = line.split(",");
	        	if(arr[0].equals(accountId))
	        	{
	        		double balance = Double.parseDouble(arr[5]);
	        		if(balance > transactionAmount)
	        			return true;
	        		else
	        			return false;
	        	}
	        }
	        return false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}
		
	}

	@Override
	public int saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int creditUsingSlip(String accountNum, double amount, Date transactionDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int debitUsingSlip(String accountNum, double amount, Date transactionDate) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int creditUsingCheque(String accountId, Double amount, Date transactionDate, String checkNum,
			String chequeAccount) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int debitUsingCheque(String accountId, Double amount, Date transactionDate, String checkNum,
			String chequeAccount) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public static void main(String[] args) {
		TransactionDAOImpl obj = new TransactionDAOImpl();
		boolean result = obj.isSufficientBalance("20190001000001", 6000);
		System.out.println(result);
	}

	
}
