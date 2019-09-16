package com.capgemini.pecunia.service;

import com.capgemini.pecunia.dao.LoanRequestDAOImpl;

public class LoanRequestServiceImpl implements LoanRequestService{

	@Override
	public String createLoanRequest(String loanCustomerId, double loanAmount, String loanType, int tenure,
			double loanRoi, String loanStatus) {
		LoanRequestDAOImpl loanRequestDAOImpl=new LoanRequestDAOImpl();
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
