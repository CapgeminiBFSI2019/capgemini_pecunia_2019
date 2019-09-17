package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LoanDisbursedDAOImplTest {

	@Test
	void validateLoanStatus() {
		LoanDisbursedDAOImpl l = new LoanDisbursedDAOImpl();
		boolean trueorfalse = l.checkLoanStatus("Pending");
		assertTrue(trueorfalse);
	}
	
	@Test
	void validateLoanStatus1() {
		LoanDisbursedDAOImpl l = new LoanDisbursedDAOImpl();
		boolean trueorfalse = l.checkLoanStatus("Approved");
		assertFalse(trueorfalse);
	}
	
	@Test
	void validateLoanStatus2() {
		LoanDisbursedDAOImpl l = new LoanDisbursedDAOImpl();
		boolean trueorfalse = l.checkLoanStatus("Rejected");
		assertFalse(trueorfalse);
	}
	
	@Test
	void validateLoanStatus3() {
		LoanDisbursedDAOImpl l = new LoanDisbursedDAOImpl();
		boolean trueorfalse = l.checkLoanStatus(" ");
		assertFalse(trueorfalse);
	}
	
	@Test
	void validateCreditScore() {
		LoanDisbursedDAOImpl l = new LoanDisbursedDAOImpl();
		boolean trueorfalse = l.creditScore(300);
		assertFalse(trueorfalse);
	}
	
	@Test
	void validateCreditScore1() {
		LoanDisbursedDAOImpl l = new LoanDisbursedDAOImpl();
		boolean trueorfalse = l.creditScore(759);
		assertTrue(trueorfalse);
	}
	
	
}
