package com.capgemini.pecunia.service;

import java.util.Date;

public class TransactionServiceImpl implements TransactionService{

	@Override
	public int creditUsingSlip(String accountId, Double amount, Date transactionDate) {
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
	public int debitUsingSlip(String accountId, Double amount, Date transactionDate) {
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