package com.capgemini.pecunia.service;

import com.capgemini.pecunia.dao.TransactionDAO;
import com.capgemini.pecunia.dao.TransactionDAOImpl;

public class TransactionServiceImpl implements TransactionService{
	
	TransactionDAOImpl transactionDAOImpl ;
	public void creditAccountUsingSlip(String accountNo, Double amount) {
		// TODO Auto-generated method stub
		transactionDAOImpl.creditAccountUsingSlip(accountNo, amount);
	}

}
