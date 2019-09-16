package com.capgemini.pecunia.service;

public interface LoanRequestService {
	public String createLoanRequest(String loanCustomerId, double loanAmount, String loanType, int tenure,
			double loanRoi, String loanStatus);
}
