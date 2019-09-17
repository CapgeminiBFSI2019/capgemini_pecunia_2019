package com.capgemini.pecunia.dao;

import java.util.*;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.model.LoanRequest;
import com.capgemini.pecunia.model.Transaction;

import java.io.*;
import java.text.SimpleDateFormat;
/* This class is called after loan request class releases the loanRequest.csv file.
 * From pending list, we see which loan requests are having 
 * credit score is greater than 750. If greater than 750, then approve the loan */
public class LoanDisbursedDAOImpl implements LoanDisbursedDAO{


	
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
	 ArrayList<LoanRequest> loanList2= new ArrayList<LoanRequest>();
	public ArrayList<LoanRequest> updateLoanList() throws IOException {
	
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
    	int creditScore = Integer.parseInt(arr[8]);
    
    	loanList.add(new LoanRequest(loanRequestId, loanCustomerId, loanAmount, loanType, tenure, loanRoi, loanStatus, loanEmi, creditScore));
    	
    }
    br.close();
    return loanList;
    }
   
	public void approveLoan() {
		for(int i = 0; i<loanList.size(); i++) {
			if (loanList.get(i).getLoanStatus() == "Pending") {
		    	
		    	loanList1.add(new LoanRequest(loanList.get(i).getLoanRequestId(),loanList.get(i).getLoanCustomerId(),loanList.get(i).getLoanAmount(),loanList.get(i).getLoanType(), loanList.get(i).getTenure(),loanList.get(i).getLoanRoi(), loanList.get(i).getLoanStatus(), loanList.get(i).getLoanEmi(), i));
				
			}
		}
	}
	
	public void checkCreditScore() {
		for(int i=0; i<loanList1.size(); i++) {
			if(loanList1.get(i).getCreditScore() >750) {
				loanList2.add(new LoanRequest(loanList1.get(i).getLoanRequestId(),loanList1.get(i).getLoanCustomerId(),loanList1.get(i).getLoanAmount(),loanList1.get(i).getLoanType(), loanList1.get(i).getTenure(),loanList1.get(i).getLoanRoi(), loanList1.get(i).getLoanStatus(), loanList1.get(i).getLoanEmi(),loanList1.get(i).getCreditScore()));
			}
		}
	}

	public void releaseLoanSheet(String loanRequestId) throws IOException{
	
		File file1 = new File("loandisbursed.csv");
		BufferedWriter wr = new BufferedWriter(new FileWriter(file1));
		StringBuffer sb1 = new StringBuffer();
		sb1.append("loanId").append(",").append("loanCustAccId").append(",").append("loanProcessId").append(",").append("loanAmtDisbursed").append(",").append("loanAmtPaid").append(",").append("loanAmtPaid").append(",");
		wr.write(sb1.toString());
		wr.write("\n");

			for(int i=0;i<loanList2.size();i++) {
				
				StringBuffer sb2 = new StringBuffer();
		    	String loanRequestId1 = loanList2.get(i).getLoanRequestId();
		    	String loanCustomerId1 = loanList2.get(i).getLoanCustomerId();
		    	String loanAmount1 = String.valueOf(loanList2.get(i).getLoanAmount());
		    	String loanType1 = loanList2.get(i).getLoanType(); 
		    	String tenure1 = String.valueOf(loanList2.get(i).getTenure());
		    	String loanRoi1 = String.valueOf(loanList2.get(i).getLoanRoi());
		    	String loanStatus1 =loanList2.get(i).getLoanStatus();
		    	String loanEmi1 = String.valueOf(loanList2.get(i).getLoanEmi());
		    	//String creditScore1 = String.valueOf(loanList2.get(i).getCreditScore());
		    	sb2.append(loanRequestId1).append(",").append(loanCustomerId1).append(",").append(loanAmount1).append(",").append(loanType1).append(",").append(tenure1).append(",").append(loanRoi1).append(",").append(loanStatus1).append(",").append(loanEmi1);
		    	wr.write(sb2.toString());
		    	wr.write("\n");
		}
	
	wr.close();

	

}}
