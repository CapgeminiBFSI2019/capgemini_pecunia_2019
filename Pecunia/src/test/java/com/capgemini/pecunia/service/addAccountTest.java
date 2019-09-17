package com.capgemini.pecunia.service;

import static org.junit.jupiter.api.Assertions.*;

import java.security.InvalidParameterException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.activity.InvalidActivityException;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.pecunia.Values;
import com.sun.scenario.animation.shared.InfiniteClipEnvelope;

class addAccountTest {


	@Test
	void addAccount_NullTest1() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount(null,null,null,null,null,date1,null,null,null,null,null,null,null,-0.2,-0.2,date1,null);
				    });			
	}
	
	@Test
	void addAccount_AadharValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vidu","11234678923","1gf5123fg5","8879771137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","India","110051","Savings",-3.0,5.0,date1, "1");
				    });			
	}
	
	
	@Test
	void addAccount_PanValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123f5","8879771137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","India","110051","Savings",3.0,5.0,date1, "1");
				    });			
	}
	@Test
	void addAccount_customernameValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vid12u","112345678923","1gf5123fg5","8879771137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","India","110051","Savings",3.0,5.0,date1, "1");
				    });			
	}
	@Test
	void addAccount_customerContactValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123fg5","887977137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","India","110051","Savings",3.0,5.0,date1, "1");
				    });			
	}
	@Test
	void addAccount_customerGenderValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123fg5","8879771137","Feme", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","India","110051","Savings",3.0,5.0,date1, "1");
				    });			
	}
	@Test
	void addAccount_addresscityValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123fg5","8879771137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi1","Delhi","India","110051","Savings",3.0,5.0,date1, "1");
				    });				
	}
	
	@Test
	void addAccount_addressstateValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123fg5","8879771137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi1","India","110051","Savings",3.0,5.0,date1, "1");
				    });			
	}
	@Test
	void addAccount_addresscountryValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123fg5","8879771137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","Ind1a","110051","Savings",3.0,5.0,date1, "1");
				    });				
	}
	@Test
	void addAccount_addresszipcodeValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123fg5","8879771137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","India","11001","Savings",3.0,5.0,date1, "1");
				    });				
	}
	@Test
	void addAccount_accounttypeValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123fg5","8879771137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","India","110051","Sings",3.0,5.0,date1, "1");
				    });			
	}
	@Test
	void addAccount_accountbalanceValidity() throws Exception {
		
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
		assertThrows(InvalidParameterException.class, () -> {
		      
			new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123fg5","8879771137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","India","110051","Savings",-3.0,5.0,date1, "1");
				    });			
	}
//	@Test
//	void addAccount_accountinterestValidity() {
//		
//		double line= 4.0;
//		@SuppressWarnings("deprecation")
//	Date dt1= new Date("12/11/1998 12:33:21");
//		@SuppressWarnings("deprecation")
//		java.sql.Date dt= (java.sql.Date) new Date("12/11/1998 12:33:21");
//		assertThrows(InvalidParameterException.class, () -> {
//		      
//			new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123fg5","8879771137","Female", dt1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","India","110051","Savings",-1.6,line,dt, "1");
//				    });		
//	}
	
	@Test
void addAccount_accountinterest() throws Exception {
//		java.sql.Date date1 = (java.sql.Date) new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse("13/08/1998 00:00:00");
		Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse("13/08/1998 00:00:00");
	assertThrows(InvalidParameterException.class, () -> {
	      
		new AccountServiceImpl().addAccount("vidu","112345678923","1gf5123fg5","8879771137","Female", date1 ,"South anarkali extension","Near sanatan dharam mandir","Delhi","Delhi","India","110051","Savings",-3.0,-5.0,date1, "1");
			    });		
}
	
}

	
	

