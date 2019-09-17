                               package com.capgemini.pecunia.service;

import com.capgemini.pecunia.dao.LoanRequestDAOImpl;

public class LoanRequestServiceImpl implements LoanRequestService{

	@Override
	public String createLoanRequest(String loanCustomerId, double loanAmount, String loanType, int tenure,
			double loanRoi, String loanStatus, int creditScore) {
		LoanRequestDAOImpl loanRequestDAOImpl=new LoanRequestDAOImpl();
		loanRequestDAOImpl.createLoanRequest(loanCustomerId, loanAmount, loanType, tenure, loanRoi, loanStatus,creditScore);
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
