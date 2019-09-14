package com.capgemini.pecunia.dao;

public interface LoanRequestDAO {
//	public double calculateEMI(double amount, int tenure, double loanRoi);

	public String createLoanRequest(String loanCustomerId, double loanAmount, String loanType,
			int tenure, double loanRoi, String loanStatus);
}
