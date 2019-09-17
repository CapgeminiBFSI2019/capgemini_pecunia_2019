package com.capgemini.pecunia.service;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class updateCustomerContact {

	@Test
	void updateCustomerContact_NullTest() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerContact(null,null);
			
		    });		
	}
	
	@Test
	void updateCustomerContact_customerContactValidity1() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerContact("20190001000001","754939273");
			
		    });		
	}
	
	@Test
	void updateCustomerContact_customerContactValidity2() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerContact("20190001000001","837261534%");
			
		    });		
	}


}
