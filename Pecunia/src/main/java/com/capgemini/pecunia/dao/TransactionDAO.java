package com.capgemini.pecunia.dao;

import java.io.File;
import java.util.Date;

public interface TransactionDAO {
	public int getTransactionId(File file);
	public int getCheckId(File file);
	public boolean isSufficientBalance(String accountId,double transactionAmount);
	public int createNewTransaction(String accountId,double amount,Date transactionDate);
}
