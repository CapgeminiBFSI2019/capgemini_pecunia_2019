package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

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
}