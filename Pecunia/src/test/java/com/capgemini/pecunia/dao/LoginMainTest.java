package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

class LoginMainTest {

	@Test
	void testScenario1() {
		LoginMain lm = new LoginMain("capgemini","123");
		assertTrue(lm.validateLogin(lm.getUsername(), lm.getPassword()));
	}

	
	@Test
	void testScenario2() {
		LoginMain lm = new LoginMain("capgeminisdasd","123");
		
		assertFalse(lm.validateLogin(lm.getUsername(), lm.getPassword()));
	}
	
	@Test
	void testScenario3() {
		LoginMain lm = new LoginMain(null,"123");
		
		assertThrows(RuntimeException.class, () -> {lm.validateLogin(lm.getUsername(), lm.getPassword());});
	}
	
	@Test
	void testScenario4() {
		LoginMain lm = new LoginMain("capgemini",null);
		
		assertThrows(RuntimeException.class, () -> {lm.validateLogin(lm.getUsername(), lm.getPassword());});
	}
	
	@Test
	void testScenario5() {
		LoginMain lm = new LoginMain(null,null);
		
		assertThrows(RuntimeException.class, () -> {lm.validateLogin(lm.getUsername(), lm.getPassword());});
	}
}
