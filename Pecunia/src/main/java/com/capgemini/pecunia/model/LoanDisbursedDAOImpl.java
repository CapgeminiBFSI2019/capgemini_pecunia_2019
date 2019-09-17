package com.capgemini.pecunia.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;

import com.capgemini.pecunia.Values;
import com.capgemini.pecunia.model.LoanRequest;

/* This class is called after loan request class releases the loanRequest.csv file.
 * From pending list, we see which loan requests are having 
 * credit score is greater than 750. If greater than 750, then approve the loan */
public class LoanDisbursedDAOImpl implements LoanDisbursedDAO {

	private String loanRequestId;
	private String loanCustomerId;
	private double loanAmount;
	private String loanType;
	private int tenure;
	private double loanRoi;
	private String loanStatus;
	private double loanEmi;
	private int creditScore;
	static ArrayList<LoanRequest> loanList = new ArrayList<LoanRequest>();
	ArrayList<LoanRequest> loanList1 = new ArrayList<LoanRequest>();
	ArrayList<LoanRequest> loanList2 = new ArrayList<LoanRequest>();

	
	// TODO Write Comments
	public ArrayList<LoanRequest> updateLoanList() throws IOException {

		FileReader file = new FileReader(Values.LOAN_REQUEST_CSV_FILE1);
		BufferedReader br = new BufferedReader(file);

		String line;

		while ((line = br.readLine()) != null) {

			String arr[] = line.split(",");
			loanRequestId = arr[0];
			loanCustomerId = arr[1];
			loanAmount = Double.valueOf(arr[2]);
			loanType = arr[3];
			tenure = Integer.parseInt(arr[4]);
			loanRoi = Double.parseDouble(arr[5]);
			loanStatus = arr[6];
			loanEmi = Double.parseDouble(arr[7]);
			creditScore = Integer.parseInt(arr[8]);

			loanList.add(new LoanRequest(loanRequestId, loanCustomerId, loanAmount, loanType, tenure, loanRoi,
					loanStatus, loanEmi, creditScore));

		}
		br.close();
	    System.out.println(loanList.get(1));
		return loanList;
		
	

	}

	// TODO Write Comments
	public ArrayList<LoanRequest> approveLoan(ArrayList<LoanRequest> loanList) {
	
		
		for (int i = 0; i < loanList.size(); i++) {
			
			if (loanList.get(i).getLoanStatus().equals("Pending")) {

				loanList1.add(new LoanRequest(loanList.get(i).getLoanRequestId(), loanList.get(i).getLoanCustomerId(),
						loanList.get(i).getLoanAmount(), loanList.get(i).getLoanType(), loanList.get(i).getTenure(),
						loanList.get(i).getLoanRoi(), loanList.get(i).getLoanStatus(), loanList.get(i).getLoanEmi(),
						loanList.get(i).getCreditScore()));

			}
			
			else {
				throw new InvalidParameterException();
			}
			
		}
		return loanList1;
	}

	// TODO Comments
	public ArrayList<LoanRequest> checkCreditScore(ArrayList<LoanRequest> loanList) {
		
		for (int i = 0; i < loanList1.size(); i++) {
			System.out.println(loanList1.get(i).getCreditScore());
			if (loanList1.get(i).getCreditScore() > 750) {
				loanList2.add(new LoanRequest(loanList1.get(i).getLoanRequestId(), loanList1.get(i).getLoanCustomerId(),
						loanList1.get(i).getLoanAmount(), loanList1.get(i).getLoanType(), loanList1.get(i).getTenure(),
						loanList1.get(i).getLoanRoi(), loanList1.get(i).getLoanStatus(), loanList1.get(i).getLoanEmi(),
						loanList1.get(i).getCreditScore()));
			}
		}
		
		return loanList2;
	}

	// TODO Comments
	public void releaseLoanSheet(ArrayList<LoanRequest> loanList) throws IOException {

		File file1 = new File(Values.LOAN_DISBURSED_CSV_FILE);
		BufferedWriter wr = new BufferedWriter(new FileWriter(file1));
		StringBuffer sb1 = new StringBuffer();
		
		sb1.append("loanRequestId").append(",").append("loanCustomerId").append(",").append("loanAmount").append(",")
				.append("loanType").append(",").append("tenure").append(",").append("loanRoi").append(",")
				.append("loanStatus").append(",").append("loanEmi");
		wr.write(sb1.toString());
		wr.write("\n");

		String loanRequestId1;
		String loanCustomerId1;
		String loanAmount1;
		String loanType1;
		String tenure1;
		String loanRoi1;
		String loanStatus1;
		String loanEmi1;

		for (int i = 0; i < loanList2.size(); i++) {

			StringBuffer sb2 = new StringBuffer();
			loanRequestId1 = loanList2.get(i).getLoanRequestId();
			loanCustomerId1 = loanList2.get(i).getLoanCustomerId();
			loanAmount1 = String.valueOf(loanList2.get(i).getLoanAmount());
			loanType1 = loanList2.get(i).getLoanType();
			tenure1 = String.valueOf(loanList2.get(i).getTenure());
			loanRoi1 = String.valueOf(loanList2.get(i).getLoanRoi());
			loanStatus1 = loanList2.get(i).getLoanStatus();
			loanEmi1 = String.valueOf(loanList2.get(i).getLoanEmi());

			// String creditScore1 = String.valueOf(loanList2.get(i).getCreditScore());
			sb2.append(loanRequestId1).append(",").append(loanCustomerId1).append(",").append(loanAmount1).append(",")
					.append(loanType1).append(",").append(tenure1).append(",").append(loanRoi1).append(",")
					.append(loanStatus1).append(",").append(loanEmi1);
			wr.write(sb2.toString());
			wr.write("\n");
		}

		wr.close();

	}

	

	public static void main(String[] args) throws IOException {
		ArrayList<LoanRequest> loanList2 = new ArrayList<LoanRequest>();
		ArrayList<LoanRequest> loanList3 = new ArrayList<LoanRequest>();
		ArrayList<LoanRequest> loanList4 = new ArrayList<LoanRequest>();
		LoanDisbursedDAOImpl loan = new LoanDisbursedDAOImpl();
		loanList2 = loan.updateLoanList();
		loanList3 = loan.approveLoan(loanList2);
		loanList4 = loan.checkCreditScore(loanList3);
		loan.releaseLoanSheet(loanList4);
	}





}
