package com.capgemini.pecunia.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.Values;
import com.capgemini.pecunia.model.Cheque;
import com.capgemini.pecunia.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO {

	@Override
	public boolean isSufficientBalance(String accountId, double transactionAmount) {
		// TODO Auto-generated method stub
		try {
			File file = new File("src/main/java/com/capgemini/pecunia/dao/DbFiles/Account.csv");
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
		// TODO Auto-generated method stub
		try
		{
			String transString = transaction.getTransactionString();
			File customerFile = new File(Values.TRANSACTION_CSV_FILE);
	        FileWriter fr = new FileWriter(customerFile,true);
	        BufferedWriter br = new BufferedWriter(fr);
	        br.write(transString);
	        br.newLine();
	        br.close();
	        fr.close();
	        return 1;
		}
		catch(Exception e)
		{
			return 0;
		}
	}

	@Override
	public int creditUsingSlip(String accountId, Double amount, Date transactionDate) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Values.ACCOUNT_CSV_FILE));
			String accountRow = getAccountRow(accountId);

			if (accountRow != null) {
				String accountArray[] = accountRow.split(",");

				double oldBalance, newbalance;
				oldBalance = Double.parseDouble(accountArray[5]);
				newbalance = oldBalance + amount;
				accountArray[5] = Double.toString(newbalance);
				String transId = Utility.getAlphaNumericString();
				Transaction transaction1 = new Transaction(transId, accountId, Values.TRANSACTION_CREDIT,
						amount, Values.NA, transactionDate, Values.NA, Values.NA, Values.NA, newbalance);
				// return transId;
			} else {
				System.out.println("Account does not exist");

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int debitUsingSlip(String accountId, double amount, Date transactionDate) {
		// TODO Auto-generated method stub

		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Values.ACCOUNT_CSV_FILE));
//				 String acountId;
			String accountRow = getAccountRow(accountId);

			if (accountRow != null) {
				String accountArray[] = accountRow.split(",");

				double oldBalance, newbalance;
				oldBalance = Double.parseDouble(accountArray[5]);

				if (isSufficientBalance(accountId, amount)) {
					newbalance = oldBalance - amount;
					accountArray[5] = Double.toString(newbalance);
					String transId = Utility.getAlphaNumericString();
					// return transId;
				} else {
					System.out.println("Debit amount is more than account balance");
				}

			} else {
				System.out.println("Account does not exist");

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int creditUsingCheque(String accountId, Double amount, Date transactionDate, String chequeNum,
			String chequeAccount, String chequeBankName, String chequeHolderName, String chequeIFSC,
			Date chequeIssueDate, String chequeStatus) {
		// TODO Auto-generated method stub
		double oldBalPayee, newBalPayee, oldBalBeneficiary, newBalBenificiary;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Values.ACCOUNT_CSV_FILE));
			String accountRow = getAccountRow(accountId);

			if (accountRow != null) {
				String accountArray[] = accountRow.split(",");
				oldBalBeneficiary = Double.parseDouble(accountArray[5]);
				if (chequeBankName.equals(Values.BANK_NAME)) {
					if (isSufficientBalance(chequeAccount, amount)) {
						String payeeAccount = getAccountRow(chequeAccount);
						String payeeAccArray[] = payeeAccount.split(",");
						oldBalPayee = Double.parseDouble(payeeAccArray[5]);

						newBalBenificiary = oldBalBeneficiary + amount;
						newBalPayee = oldBalPayee - amount;

						String chequeId = Utility.getAlphaNumericString();
						Cheque cheque = new Cheque(chequeId, Integer.parseInt(chequeNum), chequeAccount,
								chequeHolderName, chequeBankName, chequeIFSC, chequeIssueDate, Values.CHEQUE_STATUS_CLEARED);
						String transId1 = Utility.getAlphaNumericString();
						Transaction transaction1 = new Transaction(transId1, accountId, Values.TRANSACTION_CREDIT,
								amount, Values.TRANSACTION_OPTION_CHEQUE, transactionDate, chequeId, payeeAccount, Values.NA,
								newBalBenificiary);
						String transId2 = Utility.getAlphaNumericString();
						Transaction transaction2 = new Transaction(transId2, payeeAccount, Values.TRANSACTION_DEBIT,
								amount, Values.TRANSACTION_OPTION_CHEQUE, transactionDate, chequeId, Values.NA, payeeAccount,
								newBalPayee);
					} else {
						String chequeId = Utility.getAlphaNumericString();
						Cheque cheque = new Cheque(chequeId, Integer.parseInt(chequeNum), chequeAccount,
								chequeHolderName, chequeBankName, chequeIFSC, chequeIssueDate, Values.CHEQUE_STATUS_BOUNCED);
						System.out.println("Insufficient balance");
					}
				} else {
					String chequeId = Utility.getAlphaNumericString();
					Cheque cheque = new Cheque(chequeId, Integer.parseInt(chequeNum), chequeAccount, chequeHolderName,
							chequeBankName, chequeIFSC, chequeIssueDate, Values.CHEQUE_STATUS_PENDING);

				}

			} else {
				System.out.println("Account does not exist");

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int debitUsingCheque(String accountId, Double amount, Date chequeIssueDate, String checkNum,
			String chequeAccount, String chequeBankName, String chequeHolderName, String chequeIFSC,
			String chequeStatus,Date transactionDate) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(Values.ACCOUNT_CSV_FILE));
			String accountRow = getAccountRow(accountId);

			if (accountRow != null) {
				String accountArray[] = accountRow.split(",");

				double oldBalance, newbalance;
				oldBalance = Double.parseDouble(accountArray[5]);
				if (amount > oldBalance) {
					String chequeId = Utility.getAlphaNumericString();
					Cheque cheque = new Cheque(chequeId, Integer.parseInt(checkNum), chequeAccount,
							chequeHolderName, chequeBankName, chequeIFSC, chequeIssueDate, Values.CHEQUE_STATUS_BOUNCED);
					System.out.println("Debit amount is less than account balance");

				} else {
					newbalance = oldBalance - amount;
					accountArray[5] = Double.toString(newbalance);
					String transId = Utility.getAlphaNumericString();
					String chequeId = Utility.getAlphaNumericString();
					Cheque cheque = new Cheque(chequeId, Integer.parseInt(checkNum), chequeAccount,
							chequeHolderName, chequeBankName, chequeIFSC, chequeIssueDate, Values.CHEQUE_STATUS_CLEARED);
					String transId1 = Utility.getAlphaNumericString();
					Transaction transaction1 = new Transaction(transId1, accountId, Values.TRANSACTION_CREDIT,
							amount, Values.TRANSACTION_OPTION_CHEQUE, transactionDate, chequeId, Values.NA,
							transId1, newbalance);
					// return transId;
				}

			} else {
				System.out.println("Account does not exist");

			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
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

	
	@Override
	public Transaction getTransactionObject(String row) {
		// TODO Auto-generated method stub
		String arr[] = row.split(",");
		Date date;
		Transaction transaction;
		try {
			date = new SimpleDateFormat(Values.DATE_FORMAT).parse(arr[5]);
			transaction = new Transaction(arr[0],arr[1],arr[2],Double.parseDouble(arr[3]),arr[4],date,arr[6],arr[7],arr[8],Double.parseDouble(arr[9]));
			return transaction;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	
}
