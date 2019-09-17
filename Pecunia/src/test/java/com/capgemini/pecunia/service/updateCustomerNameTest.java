package com.capgemini.pecunia.service;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Test;

class updateCustomerNameTest {

	@Test
	void updateCustomerName_NullTest() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerName(null,null);
			
		    });		
	}
	
	@Test
	void updateCustomerName_customernameValidity1() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerName("20190001000001","Ad1t1");
			
		    });		
	}
	
	@Test
	void updateCustomerName_customernameValidity2() {
		
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().updateCustomerName("20190001000001","Aditi!@");
			
		    });		
	}
	

}
