package com.capgemini.pecunia.dao;

import java.io.File;
import java.util.Date;

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

	
}
