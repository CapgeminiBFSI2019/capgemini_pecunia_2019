package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class LoginMainTest {
    
	
	
	
	/*
	 * Valid login credentials only (Check from database)
	 */
	@Test
	void testScenario2() {
		LoginMain lm = new LoginMain("capgemini","123");
		assertTrue(lm.validateLogin(lm.getUsername(), lm.getPassword()));
	}

	/*
	 * No null values in either username or password
	 * Should throw null pointer exception
	 */
	
	
	@Test
	void testScenario3() {
		LoginMain lm = new LoginMain(null,"123");
		
		assertThrows(NullPointerException.class, () -> {lm.validateLogin(lm.getUsername(), lm.getPassword());});
	}
	
	@Test
	void testScenario4() {
		LoginMain lm = new LoginMain("capgemini",null);
		
		assertThrows(NullPointerException.class, () -> {lm.validateLogin(lm.getUsername(), lm.getPassword());});
	}
	
	@Test
	void testScenario5() {
		LoginMain lm = new LoginMain(null,null);
		
		assertThrows(NullPointerException.class, () -> {lm.validateLogin(lm.getUsername(), lm.getPassword());});
	}
	
	/*
	 * No special characters in username or password
	 * should throw invalid parameter exception
	 */
	
	
	@Test
	void testScenario6() {
		LoginMain lm = new LoginMain("capgemini^&","123");
		
		assertThrows(InvalidParameterException.class, () -> {lm.validateLogin(lm.getUsername(), lm.getPassword());});
	}
	
	
	@Test
	void testScenario7() {
		LoginMain lm = new LoginMain("capgemini","123^&");
		
		assertThrows(InvalidParameterException.class, () -> {lm.validateLogin(lm.getUsername(), lm.getPassword());});
	}
	
	@Test
	void testScenario8() {
		LoginMain lm = new LoginMain("capgemini^&_","123^&");
		
		assertThrows(InvalidParameterException.class, () -> {lm.validateLogin(lm.getUsername(), lm.getPassword());});
	}
	
	
	
	
	
	
	
	
}
