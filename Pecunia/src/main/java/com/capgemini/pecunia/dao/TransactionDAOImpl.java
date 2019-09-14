package com.capgemini.pecunia.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.model.Transaction;

public class TransactionDAOImpl implements TransactionDAO {

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
		return 0;
	}

	@Override
	public int creditUsingSlip(String accountId, Double amount, Date transactionDate) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/capgemini/pecunia/dao/DbFiles/Account.csv"));
			String accountRow = getAccountRow(accountId);

			if (accountRow != null) {
				String accountArray[] = accountRow.split(",");

				double oldBalance, newbalance;
				oldBalance = Double.parseDouble(accountArray[5]);
				newbalance = oldBalance - amount;
				accountArray[5] = Double.toString(newbalance);
				String transId = Utility.getAlphaNumericString();
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
			BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/java/com/capgemini/pecunia/dao/DbFiles/Account.csv"));
			String accountRow = getAccountRow(chequeAccount);

			if (accountRow != null) {
				String accountArray[] = accountRow.split(",");

				double oldBalance, newbalance;
				oldBalance = Double.parseDouble(accountArray[5]);
				if (amount > oldBalance) {
					System.out.println("Debit amount is less than account balance");

				} else {
					newbalance = oldBalance - amount;
					accountArray[5] = Double.toString(newbalance);
					String transId = Utility.getAlphaNumericString();
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
			BufferedReader bufferedReader = new BufferedReader(new FileReader("Account.csv"));
			String input;
			int count = 1;
			String accountRow = null;
			while ((input = bufferedReader.readLine()) != null) {
				if (count == Integer.parseInt(accountNo)) {
					accountRow = input;
					break;
				}
				count++;
			}
			return accountRow;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public static void main(String[] args) {
		TransactionDAOImpl obj = new TransactionDAOImpl();
		boolean result = obj.isSufficientBalance("20190001000001", 6000);
		System.out.println(result);
	}

}
