package com.capgemini.pecunia.model;

import java.io.IOException;
import java.util.ArrayList;

import com.capgemini.pecunia.model.LoanRequest;

public interface LoanDisbursedDAO {
	public ArrayList<LoanRequest> updateLoanList() throws IOException;

	public ArrayList<LoanRequest> approveLoan(ArrayList<LoanRequest> loanList);

	//public ArrayList<LoanRequest> checkCreditScore(ArrayList<LoanRequest> loanList);

	public void releaseLoanSheet(ArrayList<LoanRequest> LoanList) throws IOException;

}
