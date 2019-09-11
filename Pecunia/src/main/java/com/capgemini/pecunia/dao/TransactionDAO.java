package com.capgemini.pecunia.dao;

abstract public class TransactionDAO {
	public abstract void creditAccountUsingSlip(String accountNo,Double amount);
}
