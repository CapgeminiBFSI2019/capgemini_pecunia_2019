package com.capgemini.pecunia.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import com.capgemini.pecunia.MyException;
import com.capgemini.pecunia.model.Transaction;

public interface TransactionDAO {
	public boolean isSufficientBalance(String accountId,double transactionAmount);
	public int saveTransaction(Transaction transaction);
	public String debitUsingSlip(String accountId,double amount,Date transactionDate)throws MyException;;
	public String creditUsingCheque(String accountId, Double amount, Date transactionDate, String checkNum,
			String chequeAccount,String chequeBankName,String chequeHolderName,String chequeIFSC,Date chequeIssueDate,String chequeStatus)throws MyException;;
	public String debitUsingCheque(String accountId, Double amount, Date chequeIssueDate, String checkNum,
			String chequeAccount,String chequeBankName,String chequeHolderName,String chequeIFSC,String chequeStatus,Date transactionDate)throws MyException;;
	public String creditUsingSlip(String accountId, Double amount, Date transactionDate)throws MyException;
	public String getAccountRow(String accountNo);
	public int updatebalance(String accountId,double newBalance) throws IOException;
}
