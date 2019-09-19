package com.capgemini.pecunia.dao;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class LoanRequestDAOImplTest {

	// When Loan amount entered is negative in calculateEMI method
	@Test
	void EMI_test1() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().calculateEMI(-2453454.0, 89, 13.5);
		});
	}

	// To test the output result of calculateEMI method
	@Test
	void EMI_test2() {
		assertEquals(1545, new LoanRequestDAOImpl().calculateEMI(200000.00, 24, 9.2));
	}

	@Test
	void EMI_test3() {
		assertNotEquals(1600, new LoanRequestDAOImpl().calculateEMI(200000.00, 24, 9.2));
	}

	// When tenure entered is Negative
	@Test
	void EMI_test4() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().calculateEMI(100000.0, -89, 13.5);
		});
	}

	// When loanRoi entered is negative
	@Test
	void EMI_test5() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().calculateEMI(157788.0, 89, -13.5);
		});
	}

	// When both loanAmount and tenure entered is negative
	@Test
	void EMI_test6() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().calculateEMI(-154355.0, -89, 13.5);
		});
	}

	//// When both loanAmount and loanRoi entered is negative
	@Test
	void EMI_test7() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().calculateEMI(-1353535.0, 89, -13.5);
		});
	}

	//// When both loanRoi and tenure entered is negative
	@Test
	void EMI_test8() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().calculateEMI(1335353.0, -89, -13.5);
		});
	}

	// When all loanAmount,loanRoi and tenure entered is negative
	@Test
	void EMI_test9() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().calculateEMI(-1355524.0, -89, -13.5);
		});
	}

	// If loanCustomerId,loanType,loanStatus entered is null
	@Test
	void createLoanRequestTest1() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().createLoanRequest(null, 200000, null, 24, 9.6, null, 600);
		});
	}

	// If loanCustomerId and loanType entered is null
	@Test
	void createLoanRequestTest2() {
		// assertThrows(NullPointerException.class, ()->{new
		// LoanRequestDAOImpl().createLoanRequest(null,200000,null,24,9.6,"Pending");});
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().createLoanRequest(null, 200000, null, 24, 9.6, "Pending", 654);
		});
	}

	// If loanCustomerId and loanStatus entered is null
	@Test
	void createLoanRequestTest3() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().createLoanRequest(null, 200000, "House Loan", 24, 9.6, null, 600);
		});
	}

	// If loanCustomerId and loanType entered is null
	@Test
	void createLoanRequestTest4() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().createLoanRequest(null, 200000, null, 24, 9.6, "Pending", 890);
		});
	}

	//If tenure entered is negative
	@Test
	void createLoanRequestTest5() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().createLoanRequest("bdbujsbdu", 200000, "Vehicle Loan", -24, 9.6, "Pending", 500);
		});
	}

	//If loan amount entered is negative
	@Test
	void createLoanRequestTest6() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().createLoanRequest("bdbujsbdu", -200000, "Vehicle Loan", 24, 9.6, "Pending", 899);
		});
	}

	//If rate of interest entered is negative
	@Test
	void createLoanRequestTest7() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().createLoanRequest("bdbujsbdu", 200000, "Vehicle Loan", 24, -9.6, "Pending", 789);
		});
	}

	//If Credit Card entered is zero 
	@Test
	void createLoanRequestTest8() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().createLoanRequest("bdbujsbdu", 200000, "Vehicle Loan", 24, -9.6, "Pending", 0);
		});
	}
	
	//If credit score entered is negative
	@Test
	void createLoanRequestTest9() {
		assertThrows(InvalidParameterException.class, () -> {
			new LoanRequestDAOImpl().createLoanRequest("bdbujsbdu", 200000, "Vehicle Loan", 24, 9.6, "Pending", -667);
		});
	}

	// Testing validateCustomerId method
	@Test
	public void validate_customerid() {
		LoanRequestDAOImpl loanRequest = new LoanRequestDAOImpl();
		assertFalse(loanRequest.validateCustomerId("jilmSOrNBgkJbV9vn4mA"));
	}
}