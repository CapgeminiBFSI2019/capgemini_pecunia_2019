package com.capgemini.pecunia.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountPassBookTest {

	@Test
	void updatePassBook_EmptyTest() {
		String line = "";
		assertNull(AccountServiceImpl.updatePassbookOne(line));
	}

	@Test
	void updatePassBook_NullTest() {
		String line = null;
		assertNull(AccountServiceImpl.updatePassbookOne(line));
	}
}
