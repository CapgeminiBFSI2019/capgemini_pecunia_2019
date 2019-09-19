package com.capgemini.pecunia.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

import com.capgemini.pecunia.MyException;
import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.dao.TransactionDAOImpl;

public class TransactionServiceImpl implements TransactionService{

	@Override
	public String creditUsingSlip(String accountId, Double amount, Date transactionDate) throws MyException {
		// object of transactionDAOImpl created
		TransactionDAOImpl transactionDAOImpl = new TransactionDAOImpl();
		//Method called
		String transactionId = transactionDAOImpl.creditUsingSlip(accountId, amount, transactionDate);
		return transactionId;
		
		
	}

	@Override
	public String creditUsingCheque(String accountId, Double amount, Date transactionDate, String checkNum,
			String chequeAccount,String chequeBankName,String chequeHolderName,String chequeIFSC,Date chequeIssueDate,String chequeStatus) throws MyException {
		// object of transactionDAOImpl created
		TransactionDAOImpl transactionDAOImpl = new TransactionDAOImpl();
		String transactionId = transactionDAOImpl.creditUsingCheque(accountId,amount,transactionDate,checkNum,
				chequeAccount,chequeBankName,chequeHolderName,chequeIFSC, chequeIssueDate,chequeStatus);
		return transactionId;
	}

	@Override
	public String debitUsingSlip(String accountId, Double amount, Date transactionDate) throws MyException {
		// object of transactionDAOImpl created

		TransactionDAOImpl transactionDAOImpl = new TransactionDAOImpl();
		//Method called
		String transactionId = transactionDAOImpl.debitUsingSlip(accountId, amount, transactionDate);
		return transactionId;
		
	}

	@Override
	public String debitUsingCheque(String accountId, Double amount, Date chequeIssueDate, String checkNum,
			String chequeAccount,String chequeBankName,String chequeHolderName,String chequeIFSC,String chequeStatus,Date transactionDate) throws MyException {
		// object of transactionDAOImpl created
		TransactionDAOImpl transactionDAOImpl = new TransactionDAOImpl();
		//Method called
		String transactionId = transactionDAOImpl.debitUsingCheque(accountId,amount,chequeIssueDate,checkNum,
				chequeAccount,chequeBankName,chequeHolderName,chequeIFSC,chequeStatus,transactionDate);
		return transactionId;
		
	
}
}
