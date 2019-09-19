package com.capgemini.pecunia.service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

import com.capgemini.pecunia.Values;
import com.capgemini.pecunia.model.Transaction;

public class AccountSummaryImpl implements AccountSummary{


//function to get the account summary
	@Override
	public ArrayList<Transaction> getAccountSummary(String accountId, Date startDate, Date endDate)
	{
		try {
		String[] arrTrans = new String[10];
		ArrayList<Transaction> l= new ArrayList<Transaction>(); //declaration of arraylist od class Transaction
		String line;
		Calendar c = Calendar.getInstance(); //storing an instance of calender in c
        c.setTime(startDate); //c is set to given start date
		File file = new File("Transaction.csv"); //reading file from Transaction.csv
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    while((line = br.readLine())!= null) 
        {
	    	arrTrans = line.split(","); //storing the data in the arrTrans string
	    	double amount = Double.parseDouble(arrTrans[4]);
            double closeBal = Double.parseDouble(arrTrans[9]);

            Date date1 = new SimpleDateFormat(Values.DATE_FORMAT).parse(arrTrans[5]); //parsing the string into date format
            //storing the elements of arrTrans in object transaction t
    	   Transaction t = new Transaction(arrTrans[0],arrTrans[1],arrTrans[2],amount,arrTrans[4],date1, arrTrans[6],arrTrans[7],arrTrans[8],closeBal);
    	   //checking and comparing dates
    	   if(t.getTransDate()==startDate) {
    		   while(t.getTransDate().compareTo(endDate)<0) {
    			   l.add(t);
        		   c.add(Calendar.SECOND, 1);
    		   }
    	   }
        }
	    br.close();
		
		return l;
		}catch (Exception e) {
			return null;
		}
		}

	

}

	

	
