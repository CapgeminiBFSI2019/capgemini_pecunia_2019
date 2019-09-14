package com.capgemini.pecunia.dao;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO{

	@Override
	public int getTransactionId(File file) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCheckId(File file) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isSufficientBalance(String accountId, double transactionAmount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int saveTransaction(Transaction transaction) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int creditUsingSlip(String accountId, Double amount, Date transactionDate) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("Account.csv"));
			 String accountRow = getAccountRow(accountId);
			 
			 if(accountRow != null)
	            {
	                String accountArray[] = accountRow.split(",");
	                
	                double oldBalance,newbalance;
	                oldBalance = Double.parseDouble(accountArray[5]);   
                    newbalance = oldBalance - amount;
                    accountArray[5] = Double.toString(newbalance);
                    String transId = Utility.getAlphaNumericString();
                      // return transId;
                }
			 else
	            {
	                System.out.println("Account does not exist");
	                
	            }

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("Account.csv"));
			 String accountRow = getAccountRow(chequeAccount);
			 
			 if(accountRow != null)
	            {
	                String accountArray[] = accountRow.split(",");
	                
	                double oldBalance,newbalance;
	                oldBalance = Double.parseDouble(accountArray[5]);
                    if(amount > oldBalance)
                    {
                        System.out.println("Debit amount is less than account balance");
                       
                    }
                    else
                    {
                        newbalance = oldBalance - amount;
                        accountArray[5] = Double.toString(newbalance);
                        String transId = Utility.getAlphaNumericString();
                      // return transId;
                    }
                    
                }
			 else
	            {
	                System.out.println("Account does not exist");
	                
	            }

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	@Override
	public String getAccountRow(String accountNo)
    {
        try
        {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Account.csv"));
            String input;
            int count = 1;
            String accountRow = null;
            while((input = bufferedReader.readLine()) != null)
            {
                if(count == Integer.parseInt(accountNo))
                {
                   accountRow = input;
                    break;
                }
                count++;
            }
            return accountRow;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }
    }

	
}
