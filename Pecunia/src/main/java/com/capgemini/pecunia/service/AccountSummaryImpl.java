package com.capgemini.pecunia.service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.*;

import com.capgemini.pecunia.model.Transaction;

public class AccountSummaryImpl {



	public ArrayList<Transaction> getAccountSummary(String accountId, Date startDate, Date endDate)throws Exception
	{
		String[] arrTrans = new String[10];
		ArrayList<Transaction> l= new ArrayList<Transaction>();
		String line;
		Calendar c = Calendar.getInstance();
        c.setTime(startDate);
		File file = new File("Transaction.csv");
	    BufferedReader br = new BufferedReader(new FileReader(file));
	    while((line = br.readLine())!= null)
        {
	    	arrTrans = line.split(",");
	    	double amount = Integer.parseInt(arrTrans[4]);
            double closeBal = Integer.parseInt(arrTrans[9]);

            Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(arrTrans[5]);
    	   Transaction t = new Transaction(arrTrans[0],arrTrans[1],arrTrans[2],arrTrans[4],amount,date1, arrTrans[6],arrTrans[7],arrTrans[8],closeBal);
    	   if(t.getTransDate()==startDate) {
    		   while(t.getTransDate().compareTo(endDate)<0) {
    			   l.add(t);
        		   c.add(Calendar.DATE, 1);
    		   }
    	   }
        }
	    br.close();
		
		return l;
		}

	

}

	

	
