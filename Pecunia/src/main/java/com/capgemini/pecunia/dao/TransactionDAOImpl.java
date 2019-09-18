package com.capgemini.pecunia.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.capgemini.pecunia.MyException;
import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.Values;
import com.capgemini.pecunia.model.Account;
import com.capgemini.pecunia.model.Cheque;
import com.capgemini.pecunia.model.Employee;
import com.capgemini.pecunia.model.Transaction;

import sun.font.CreatedFontTracker;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public boolean isSufficientBalance(String accountId, double transactionAmount) {

		// Method to check if sufficient balance is in account

		try {
			File file = new File(Values.ACCOUNT_CSV_FILE);
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				String arr[] = line.split(",");
				if (arr[0].equals(accountId)) {
					double balance = Double.parseDouble(arr[5]);
					if (balance > transactionAmount)
						return true;
					else
						return false;
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}

	}

	@Override
	public int saveTransaction(Transaction transaction) {

		// new transaction instance is written into file

		try {
			String transString = transaction.getTransactionString();
			File customerFile = new File(Values.TRANSACTION_CSV_FILE);
			FileWriter fr = new FileWriter(customerFile, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(transString);
			br.newLine();
			br.close();
			fr.close();
			return 1;
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int updatebalance(String accountId,double newBalance) throws IOException
	{
		//balance is updated in the list and updated into the file
		try
		{
			List<Account> accountList = getAllAccounts();
			for(int i=0;i<accountList.size();i++)
			{
				if(accountList.get(i).getAccountId().equals(accountId))
				{
					Account temp = accountList.get(i);
					temp.setAccountBalance(newBalance);
					accountList.set(i, temp);
					
					
					
					
				}
			}
			List<String> finalList = new ArrayList<String>();
			for(int i=0;i<accountList.size();i++)
			{
				finalList.add(accountList.get(i).getAccountString());
			}
			Path FILE_PATH = Paths.get(Values.ACCOUNT_CSV_FILE);
			Files.write(FILE_PATH, finalList, StandardCharsets.UTF_8);
			return 1;
		}
		catch(Exception e)
		{
			return 0;
		}
		
	}

	@Override
	public String creditUsingSlip(String accountId, Double amount, Date transactionDate) throws MyException {
		
		try
		{
			//Account object is fetched corresponding to account id 
			Account account = getAccountObject(accountId);
			System.out.println("account info :" + account);
			if(account != null)
			{
				double oldBalance,newBalance;
				oldBalance = account.getAccountBalance();
				newBalance = oldBalance + amount;
				// Need to update balance 
				updatebalance(accountId, newBalance);
				String transId = Utility.getAlphaNumericString(20);
				Transaction transaction = new Transaction(transId, accountId, Values.TRANSACTION_CREDIT,Values.TRANSACTION_OPTION_SLIP, amount, transactionDate, Values.NA, Values.NA, Values.NA,newBalance);
				saveTransaction(transaction);
				return transId;
			}
			else
			{
				throw new MyException(Values.INVALID_ACCOUNT_EXCEPTION);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
			throw new MyException(Values.EXCEPTION_DURING_TRANSACTION);
		}
	}

	@Override
	public String debitUsingSlip(String accountId, double amount, Date transactionDate) throws MyException {
		try
		{
				//Account object is fetched corresponding to account id 

			Account account = getAccountObject(accountId);
			if(account != null)
			{
				double oldBalance,newBalance;
				oldBalance = account.getAccountBalance();
				
				//Sufficient balance is checked
				if(isSufficientBalance(accountId, amount))
				{
					newBalance = oldBalance - amount;
					// Need to update balance 
					updatebalance(accountId, newBalance);
					String transId = Utility.getAlphaNumericString(20);
					Transaction transaction = new Transaction(transId, accountId, Values.TRANSACTION_DEBIT,Values.TRANSACTION_OPTION_SLIP, amount, transactionDate, Values.NA, Values.NA, Values.NA,newBalance);
					saveTransaction(transaction);
					return transId;
				}
				else
				{
					throw new MyException(Values.INSUFFICIENT_BALANCE_EXCEPTION);
				}
				
			}
			else
			{
				throw new MyException(Values.INVALID_ACCOUNT_EXCEPTION);
			}
		}
		catch(Exception e)
		{
			throw new MyException(Values.EXCEPTION_DURING_TRANSACTION);
		}
	}

	@Override
	public String creditUsingCheque(String accountId, Double amount, Date transactionDate, String chequeNum,
			String chequeAccount, String chequeBankName, String chequeHolderName, String chequeIFSC,
			Date chequeIssueDate, String chequeStatus) throws MyException{
		
		double oldBalPayee, newBalPayee, oldBalBeneficiary, newBalBenificiary;
		try
		{
			//get account object of payee and beneficiary
			Account beneficiaryAccount = getAccountObject(accountId);
			Account payeeAccount = getAccountObject(chequeAccount);
			
			if(beneficiaryAccount != null && payeeAccount != null)
			{
				oldBalBeneficiary = beneficiaryAccount.getAccountBalance();
				//for Pecunia cheques
				if(chequeBankName.equals(Values.BANK_NAME))
				{
					if(isSufficientBalance(chequeAccount, amount))
					{
						oldBalPayee = payeeAccount.getAccountBalance();
						
						newBalBenificiary = oldBalBeneficiary + amount;
						newBalPayee = oldBalPayee - amount;
						
						//update balance required
						updatebalance(accountId, newBalBenificiary);
						updatebalance(chequeAccount, newBalPayee);
						
						String chequeId = Utility.getAlphaNumericString(20);
						//cheque object generated
						Cheque cheque = new Cheque(chequeId, Integer.parseInt(chequeNum), chequeAccount,
								chequeHolderName, chequeBankName, chequeIFSC, chequeIssueDate,
								Values.CHEQUE_STATUS_CLEARED);
						
						//cheque should be saved
						String transId1 = Utility.getAlphaNumericString(20);
						
						//beneficary trans_id generataed
						Transaction transaction1 = new Transaction(transId1, accountId, Values.TRANSACTION_CREDIT,
								Values.TRANSACTION_OPTION_CHEQUE, amount, transactionDate, chequeId, chequeAccount,
								Values.NA, newBalBenificiary);
						
						//trans_id1 recorded
						saveTransaction(transaction1);
						String transId2 = Utility.getAlphaNumericString(20);
						//beneficary trans_id generataed
						Transaction transaction2 = new Transaction(transId2, chequeAccount, Values.TRANSACTION_DEBIT,
								Values.TRANSACTION_OPTION_CHEQUE, amount, transactionDate, chequeId, Values.NA,
								chequeAccount, newBalPayee);
						//trans_id1 recorded
						saveTransaction(transaction2);
						//transaction should be saved
					}
					else
					{
						//If insufficient balance
						String chequeId = Utility.getAlphaNumericString(20);
						Cheque cheque = new Cheque(chequeId, Integer.parseInt(chequeNum), chequeAccount,
								chequeHolderName, chequeBankName, chequeIFSC, chequeIssueDate,
								Values.CHEQUE_STATUS_BOUNCED);
						//No trans_id will be generated
						//save cheque
						throw new MyException(Values.CHEQUE_BOUNCE_EXCEPTION);
					}
						
				}
				else
				{
					//If the cheque is from other banks
					boolean chequebankFlag = false;
					for(String temp:Values.OTHER_BANK_NAME)
					{
						if(temp.equals(chequeBankName))
						{
							chequebankFlag = true;
							break;
						}
					}
					
					if(chequebankFlag)
					{
						String chequeId = Utility.getAlphaNumericString(20);
						Cheque cheque = new Cheque(chequeId, Integer.parseInt(chequeNum), chequeAccount, chequeHolderName,
								chequeBankName, chequeIFSC, chequeIssueDate, Values.CHEQUE_STATUS_PENDING);
						//save cheque
					}
					else
					{
						throw new MyException(Values.INVALID_BANK_EXCEPTION);
					}
					
				}
			}
			else
			{
				//If no account is found
				throw new MyException(Values.INVALID_ACCOUNT_EXCEPTION);
			}
				
		}
		catch(Exception e)
		{
			throw new MyException(Values.EXCEPTION_DURING_TRANSACTION);
		}
		return null;
	}

	@Override
	public String debitUsingCheque(String accountId, Double amount, Date chequeIssueDate, String checkNum,
			String chequeAccount, String chequeBankName, String chequeHolderName, String chequeIFSC,
			String chequeStatus, Date transactionDate) throws MyException {
		
		try
		{
			//Account object is fetched corresponding to account id 

			Account account = getAccountObject(accountId);
			if(account != null)
			{
				double oldBalance,newBalance;
				oldBalance = account.getAccountBalance();
				
				//Sufficient balance is checked
				if(isSufficientBalance(accountId, amount))
				{
					newBalance = oldBalance - amount;
					// Need to update balance 
					updatebalance(accountId, newBalance);
					String chequeId = Utility.getAlphaNumericString(20);
					//cheque object generated
					Cheque cheque = new Cheque(chequeId, Integer.parseInt(checkNum), chequeAccount, chequeHolderName,
							chequeBankName, chequeIFSC, chequeIssueDate, Values.CHEQUE_STATUS_CLEARED);
					//save cheque
					String transId1 = Utility.getAlphaNumericString(20);
					//trans_id1 recorded
					Transaction transaction = new Transaction(transId1, accountId, Values.TRANSACTION_DEBIT,
							Values.TRANSACTION_OPTION_CHEQUE, amount, transactionDate, chequeId, Values.NA, transId1,
							newBalance);
					//transaction should be saved
					saveTransaction(transaction);
					 return transId1;
				}
				else
				{
					//If insufficient balance
					String chequeId = Utility.getAlphaNumericString(20);
					Cheque cheque = new Cheque(chequeId, Integer.parseInt(checkNum), chequeAccount, chequeHolderName,
							chequeBankName, chequeIFSC, chequeIssueDate, Values.CHEQUE_STATUS_BOUNCED);
					//save cheque
					throw new MyException(Values.INSUFFICIENT_BALANCE_EXCEPTION);
				}
				
			}
			else
			{
				//If no account is found
				throw new MyException(Values.INVALID_ACCOUNT_EXCEPTION);
			}
		}
		catch(Exception e)
		{
			throw new MyException(Values.EXCEPTION_DURING_TRANSACTION);
		}
	}

	@Override
	public String getAccountRow(String accountNo) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Values.ACCOUNT_CSV_FILE));
			String input;
			String accountRow = null;
			while ((input = bufferedReader.readLine()) != null) {
				String arr[] = input.split(",");
				if (arr[0].contentEquals(accountNo)) {
					return input;
				}
			}
			return accountRow;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	//Account object of corresponding account_id is created
	public static Account getAccountObject(String accountNo)
	{
		try
		{
			//returns list of all accounts objects
			List<Account> allAccountList = getAllAccounts();
			for(Account acc : allAccountList)
			{
				System.out.println(acc.getAccountId());
				if(acc.getAccountId().equals(accountNo))
				{
					return acc;
				}
			}
			return null;
			
		}
		catch(Exception e)
		{
			System.out.println("Error");
			return null;
		}
	}
	
	//returns list of all account objects after reading from file
	public static List<Account> getAllAccounts() throws IOException {
		Path FILE_PATH = Paths.get(Values.ACCOUNT_CSV_FILE);
		List<String> fileContent = new ArrayList<>(Files.readAllLines(FILE_PATH, StandardCharsets.UTF_8));
		List<Account> accList = new ArrayList<Account>();
		for (String line : fileContent) {
			Account acc = Account.getAccountObject(line);
			accList.add(acc);
		}
		return accList;
	}

}
