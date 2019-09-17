package com.capgemini.pecunia.service;

import java.util.Date;

import com.capgemini.pecunia.MyException;

public interface TransactionService {
	public String creditUsingSlip(String accountId,Double amount,Date transactionDate) throws MyException;
	public String creditUsingCheque(String accountId, Double amount, Date transactionDate, String checkNum,
			String chequeAccount,String chequeBankName,String chequeHolderName,String chequeIFSC,Date chequeIssueDate,String chequeStatus) throws MyException;
	public String debitUsingSlip(String accountId,Double amount,Date transactionDate)throws MyException;
	public String debitUsingCheque(String accountId, Double amount, Date chequeIssueDate, String checkNum,
			String chequeAccount,String chequeBankName,String chequeHolderName,String chequeIFSC,String chequeStatus,Date transactionDate)throws MyException;
}
