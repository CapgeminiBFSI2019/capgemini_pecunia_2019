package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TransactionDAOImplTestBalance {

	@Test
	void sufficientBalEmptyTest() {
		assertFalse(new TransactionDAOImpl().isSufficientBalance("", 800.00));
	}
	
	@Test
	void sufficientBalNullTest() {
		assertFalse(new TransactionDAOImpl().isSufficientBalance(null, 800.00));
	}
	
	@Test
	void sufficientBalNegativeValueTest() {
		assertFalse(new TransactionDAOImpl().isSufficientBalance("abbbst567", -90.0));
	}
	
	@Test
	void sufficientBalNegativeValue_EmptyTest() {
		assertFalse(new TransactionDAOImpl().isSufficientBalance("", -90.0));
	}
	

	@Test
	void sufficientBalNegativeValue_NullTest() {
		assertFalse(new TransactionDAOImpl().isSufficientBalance(null, -90.0));
	}
	
	
	
	
}
