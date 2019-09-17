package com.capgemini.pecunia.dao;

import java.io.IOException;
import java.util.ArrayList;

import com.capgemini.pecunia.model.LoanRequest;

public interface LoanDisbursedDAO {
	public ArrayList<LoanRequest> updateLoanList() throws IOException;
	public void approveLoan();
	public void checkCreditScore();
	public void releaseLoanSheet(String loanRequestId) throws IOException;
	
	
}
