package com.capgemini.pecunia.dao;

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

	// Retrieve the loan requests from LoanRequest.csv and then make a list from it.

	// Method to calculate EMI
	public double calculateEMI(double amount, int tenure, double loanRoi) {

		// Checking the parameter values
		if (amount < 0 || tenure < 0 || loanRoi < 0) {
			throw new InvalidParameterException();
		}
		double p = amount;
		double r = loanRoi / 1200;
		int t = tenure - 1;
		double a = Math.pow(1 + r, tenure);
		double b = Math.pow(1 + r, t);
		double emi = (p * r * a) / b;
		return Math.round(emi);
	}

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

	public boolean checkLoanStatus(String s) {
		if (s.equals("Pending")) {

			if (!(s.isEmpty()))

				return true;
		}
		return false;
	}

	public boolean creditScore(int n) {
		if (n >= 750) {
			return true;
		}
		return false;
	}

	/*
	 * From the list, i.e. loanList, check whether the loan status is pending or
	 * not. If yes, then create another list of requests, having status pending. Or
	 * throws error
	 * 
	 */
	public ArrayList<LoanRequest> approveLoan(ArrayList<LoanRequest> loanList) {

		for (int i = 0; i < loanList.size(); i++) {

			if (checkLoanStatus(loanList.get(i).getLoanStatus())) {

				loanList1.add(new LoanRequest(loanList.get(i).getRequestId(), loanList.get(i).getCustomerId(),
						loanList.get(i).getAmount(), loanList.get(i).getType(), loanList.get(i).getTenure(),
						loanList.get(i).getRoi(), loanList.get(i).getLoanStatus(), loanList.get(i).getEmi(),
						loanList.get(i).getCreditScore()));

			}

			else {
				throw new InvalidParameterException();
			}

		}
		return loanList1;
	}

	/*
	 * From the list, i.e. loanList1, check whether the credit score is greater than
	 * 750 or not. If yes then create another list of requests having required
	 * credit score. Else throw error.
	 */
	public ArrayList<LoanRequest> checkCreditScore(ArrayList<LoanRequest> loanList) {

		for (int i = 0; i < loanList1.size(); i++) {
			System.out.println(loanList1.get(i).getCreditScore());
			if (creditScore(loanList1.get(i).getCreditScore())) {
				loanList2.add(new LoanRequest(loanList1.get(i).getRequestId(), loanList1.get(i).getCustomerId(),
						loanList1.get(i).getAmount(), loanList1.get(i).getType(), loanList1.get(i).getTenure(),
						loanList1.get(i).getRoi(), loanList1.get(i).getLoanStatus(), loanList1.get(i).getEmi(),
						loanList1.get(i).getCreditScore()));
			}
		}

		return loanList2;
	}

	/* Finally, release a list of all applicant's requests which are approved */
	public void releaseLoanSheet(ArrayList<LoanRequest> loanList) throws IOException {

		File file1 = new File(Values.LOAN_DISBURSED_CSV_FILE);
		BufferedWriter wr = new BufferedWriter(new FileWriter(file1));
		StringBuffer sb1 = new StringBuffer();

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
			loanRequestId1 = loanList2.get(i).getRequestId();
			loanCustomerId1 = loanList2.get(i).getCustomerId();
			loanAmount1 = String.valueOf(loanList2.get(i).getAmount());
			loanType1 = loanList2.get(i).getType();
			tenure1 = String.valueOf(loanList2.get(i).getTenure());
			loanRoi1 = String.valueOf(loanList2.get(i).getRoi());
			loanStatus1 = loanList2.get(i).getLoanStatus();
			loanEmi1 = String.valueOf(loanList2.get(i).getEmi());

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
