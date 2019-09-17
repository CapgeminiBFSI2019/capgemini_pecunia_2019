package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.util.InputMismatchException;

import org.junit.jupiter.api.Test;

class LoanRequestDAOImplTest {

	@Test
	void EMI_test1() {
		assertThrows(InvalidParameterException.class, ()->{new LoanRequestDAOImpl().calculateEMI(-1.0, 89, 13.5);});
	}
	@Test
	void EMI_test2() {
		assertEquals(1545,new LoanRequestDAOImpl().calculateEMI(200000.00, 24, 9.2));
	}
	@Test
	void EMI_test3() {
		assertThrows(InvalidParameterException.class, ()->{new LoanRequestDAOImpl().calculateEMI(1.0, -89, 13.5);});
	}
	@Test
	void EMI_test4() {
		assertThrows(InvalidParameterException.class, ()->{new LoanRequestDAOImpl().calculateEMI(1.0, 89,-13.5);});
	}
	@Test
	void EMI_test5() {
		assertThrows(InvalidParameterException.class, ()->{new LoanRequestDAOImpl().calculateEMI(-1.0,-89, 13.5);});
	}
	@Test
	void EMI_test6() {
		assertThrows(InvalidParameterException.class, ()->{new LoanRequestDAOImpl().calculateEMI(-1.0, 89,-13.5);});
	}
	@Test
	void EMI_test7() {
		assertThrows(InvalidParameterException.class, ()->{new LoanRequestDAOImpl().calculateEMI(1.0,-89,-13.5);});
	}
	
	
	@Test
	void EMI_test8() {
		assertThrows(InvalidParameterException.class, ()->{new LoanRequestDAOImpl().calculateEMI(-1.0,-89,-13.5);});
	}
	
	
	@Test
	void createLoanRequestNullTest1() {
		assertNull(new LoanRequestDAOImpl().createLoanRequest(null,200000,null,24,9.6,null));
	}
	
	@Test
	void createLoanRequestNullTest2() {
		//assertThrows(NullPointerException.class, ()->{new LoanRequestDAOImpl().createLoanRequest(null,200000,null,24,9.6,"Pending");});
		assertNull(new LoanRequestDAOImpl().createLoanRequest(null,200000,null,24,9.6,"Pending"));
	}
	
	@Test
	void createLoanRequestNullTest3() {
		 assertNull(new LoanRequestDAOImpl().createLoanRequest("jilmSOrNBgkJbV9vn4mA",200000,null,24,9.6,null));
			// TODO Auto-generated method stub

		}
	
	@Test
	void createLoanRequestNullTest4() {
		assertNull(new LoanRequestDAOImpl().createLoanRequest(null,200000,"House Loan",24,9.6,null));
	}
	
	@Test
	void createLoanRequestNullTest5() {
		assertNull(new LoanRequestDAOImpl().createLoanRequest(null,200000,null,24,9.6,"Pending"));
	}
	@Test
	void createLoanRequestNullTest6() {
		assertNull(new LoanRequestDAOImpl().createLoanRequest("bdbujsbdu",200000,"Vehicle Loan",-24,9.6,"Pending"));
	}
	@Test
	void createLoanRequestNullTest7() {
		assertNull(new LoanRequestDAOImpl().createLoanRequest("bdbujsbdu",-200000,"Vehicle Loan",24,9.6,"Pending"));
	}
	@Test
	void createLoanRequestNullTest8() {
		assertNull(new LoanRequestDAOImpl().createLoanRequest("bdbujsbdu",200000,"Vehicle Loan",24,-9.6,"Pending"));
	}
}