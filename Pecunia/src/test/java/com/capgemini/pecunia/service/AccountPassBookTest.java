package com.capgemini.pecunia.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.capgemini.pecunia.dao.AccountDAOImpl;

class AccountPassBookTest {

	@Test
	void updatePassBook_EmptyTest() {
		String line = "";
		assertNull(AccountDAOImpl.updatePassbookOne(line));
	}

	@Test
	void updatePassBook_NullTest() {
		String line = null;
		assertNull(AccountDAOImpl.updatePassbookOne(line));
	}
}
