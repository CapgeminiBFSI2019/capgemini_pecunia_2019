package com.capgemini.pecunia.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginMainTest {

	@Test
	public void test() {
		LoginMain log = new LoginMain("capgemini","123");
		assertTrue(log.validateLogin());
	}

}
