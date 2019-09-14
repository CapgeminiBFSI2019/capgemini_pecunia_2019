package com.capgemini.pecunia.service;

import java.util.Date;

public interface TransactionService {
	public int creditUsingSlip(String accountId,Double amount,Date transactionDate);
	public int creditUsingCheque(String accountId,Double amount,Date transactionDate,String checkNum,String chequeAccount);
	public int debitUsingSlip(String accountId,Double amount,Date transactionDate);
	public int debitUsingCheque(String accountId, Double amount, Date chequeIssueDate, String checkNum,
			String chequeAccount,String chequeHolderName,String chequeIFSC,String chequeStatus);
}
