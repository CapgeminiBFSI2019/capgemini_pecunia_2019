package com.capgemini.pecunia.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Date;

import com.capgemini.pecunia.model.Transaction;

public interface TransactionDAO {
	public String getTransactionId(File file);
	public String getCheckId(File file);
	public boolean isSufficientBalance(String accountId,double transactionAmount);
	public int saveTransaction(Transaction transaction);
	public int debitUsingSlip(String accountId,double amount,Date transactionDate);
	public int creditUsingCheque(String accountId, Double amount, Date chequeIssueDate, String checkNum,
			String chequeAccount,String chequeBankName,String chequeHolderName,String chequeIFSC,String chequeStatus);
	public int debitUsingCheque(String accountId, Double amount, Date chequeIssueDate, String checkNum,
			String chequeAccount,String chequeBankName,String chequeHolderName,String chequeIFSC,String chequeStatus);
	public int creditUsingSlip(String accountId, Double amount, Date transactionDate);
	public String getAccountRow(String accountNo);
}
