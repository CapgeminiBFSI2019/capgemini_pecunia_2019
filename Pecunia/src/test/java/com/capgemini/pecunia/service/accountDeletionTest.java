package com.capgemini.pecunia.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class accountDeletionTest {

	@Test
	void AccountDeletionNull_Test() {
		assertFalse(new AccountServiceImpl().deleteAccount(null));
	}
	
	@Test
	void AccountDeletionEmpty_Test() {
		assertFalse(new AccountServiceImpl().deleteAccount(""));
	}

}
