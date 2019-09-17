package com.capgemini.pecunia.service;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.capgemini.pecunia.Values;



class AccountSummaryImplTest {

	@Test
	void AccountSummarry_EmptyTest() throws ParseException {
		String d1="12/07/2017 00:00:00";
		String d2="12/08/2017 00:00:00";
		Date date1=new SimpleDateFormat(Values.DATE_FORMAT).parse(d1);
		Date date2=new SimpleDateFormat(Values.DATE_FORMAT).parse(d2);
		assertNull(new AccountSummaryImpl().getAccountSummary("", date1, date2));
	}
	
	@Test
	void AccountSummarry_NullTest() throws ParseException {
		String d1="12/07/2017 00:00:00";
		String d2="12/08/2017 00:00:00";
		Date date1=new SimpleDateFormat(Values.DATE_FORMAT).parse(d1);
		Date date2=new SimpleDateFormat(Values.DATE_FORMAT).parse(d2);
		assertNull(new AccountSummaryImpl().getAccountSummary(null, date1, date2));
	}
	
	@Test
	void AccountSummarry_InvalidDate() throws ParseException {
		String d1="12/07/2017 00:00:00";
		String d2="12/08/2017 00:00:00";
		Date date1=new SimpleDateFormat(Values.DATE_FORMAT).parse(d1);
		Date date2=new SimpleDateFormat(Values.DATE_FORMAT).parse(d2);
		assertNull(new AccountSummaryImpl().getAccountSummary("", date2, date1));
	}
	
	
	

}
