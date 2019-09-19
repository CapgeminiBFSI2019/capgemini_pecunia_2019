package com.capgemini.pecunia;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.capgemini.pecunia.dao.TransactionDAOImpl;
import com.capgemini.pecunia.model.Account;
import com.capgemini.pecunia.service.TransactionServiceImpl;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MyException, ParseException, IOException
    {
    	List<Account> list = TransactionDAOImpl.getAllAccounts();
    	System.out.println(list.size());
        TransactionServiceImpl obj = new TransactionServiceImpl();
        Date date = new SimpleDateFormat(Values.DATE_FORMAT).parse("12/12/12 12:11:55");
        String result = obj.creditUsingSlip("20190001000001", 50000.00, date);
        System.out.println(result);

    }
}
