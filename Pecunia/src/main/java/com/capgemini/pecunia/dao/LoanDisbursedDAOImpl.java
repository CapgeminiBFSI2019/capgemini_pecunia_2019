package com.capgemini.pecunia.dao;

import java.util.*;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.model.LoanRequest;
import com.capgemini.pecunia.model.Transaction;

import java.io.*;
import java.text.SimpleDateFormat;

public class LoanDisbursedDAOImpl {


	
	String loanRequestId;
	String loanCustomerId; 
	double loanAmount; 
	String loanType; 
	int tenure;
	double loanRoi; String loanStatus;
	double loanEmi;
	String loanApproval;
	static ArrayList<LoanRequest> loanList= new ArrayList<LoanRequest>();
	 ArrayList<LoanRequest> loanList1= new ArrayList<LoanRequest>();
	public static ArrayList<LoanRequest> updateLoanList() throws Exception {
	
	FileReader file = new FileReader("LoanRequest.csv");
	BufferedReader br = new BufferedReader(file);

    String line;
  
    while((line = br.readLine())!= null)
    {

    	
    	String arr[] = line.split(",");
    	String loanRequestId = arr[0];
    	String loanCustomerId = arr[1];
    	double loanAmount = Double.parseDouble(arr[2]); 
    	String loanType = arr[3]; 
    	int tenure = Integer.parseInt(arr[4]);
    	double loanRoi = Double.parseDouble(arr[5]);
    	String loanStatus = arr[6];
    	double loanEmi = Double.parseDouble(arr[7]);
    
    	loanList.add(new LoanRequest(loanRequestId, loanCustomerId, loanAmount, loanType, tenure, loanRoi, loanStatus, loanEmi));
    	
    }
    return loanList;
    }
   
	public void approveLoan() {
		for(int i = 0; i<loanList.size(); i++) {
			if (loanList.get(i).getLoanStatus() == "Pending") {
		    	
		    	loanList1.add(new LoanRequest(loanList.get(i).getLoanRequestId(),loanList.get(i).getLoanCustomerId(),loanList.get(i).getLoanAmount(),loanList.get(i).getLoanType(), loanList.get(i).getTenure(),loanList.get(i).getLoanRoi(), loanList.get(i).getLoanStatus(), loanList.get(i).getLoanEmi()));
				
			}
		}
	}

	public void releaseLoanSheet(String loanRequestId) throws IOException{
	
		

			for(int i=0;i<loanList1.size();i++) {
       			File file1 = new File("loandisbursed.csv");
				BufferedWriter wr = new BufferedWriter(new FileWriter(file1));
				StringBuffer sb1 = new StringBuffer();
				sb1.append("loanId").append(",").append("loanCustAccId").append(",").append("loanProcessId").append(",").append("loanAmtDisbursed").append(",").append("loanAmtPaid").append(",").append("loanAmtPaid").append(",");
				wr.write(sb1.toString());
				wr.write("\n");
		}
	
	

	

}}
