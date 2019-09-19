package com.capgemini.pecunia.service;

import java.util.ArrayList;
import java.util.Date;

import com.capgemini.pecunia.model.Transaction;

public interface AccountSummary {
	public ArrayList<Transaction> getAccountSummary(String accountId, Date startDate, Date endDate);
}
