package com.capgemini.pecunia.dao;

import java.io.File;
import java.util.Date;

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
	public int createNewTransaction(String accountId, double amount, Date transactionDate) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
