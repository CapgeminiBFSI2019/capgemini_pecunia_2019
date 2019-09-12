package com.capgemini.pecunia.dao;

import java.io.File;
import java.util.Date;

import com.capgemini.pecunia.model.Transaction;

public interface TransactionDAO {
	public int getTransactionId(File file);
	public int getCheckId(File file);
	public boolean isSufficientBalance(String accountId,double transactionAmount);
	public int saveTransaction(Transaction transaction);
	public int creditUsingSlip(String accountNum,double amount,Date transactionDate);
	public int debitUsingSlip(String accountNum,double amount,Date transactionDate);
	public int creditUsingCheque(String accountId, Double amount, Date transactionDate, String checkNum, String chequeAccount);
	public int debitUsingCheque(String accountId, Double amount, Date transactionDate, String checkNum,String chequeAccount);
}
