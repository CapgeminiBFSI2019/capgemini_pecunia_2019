package com.capgemini.pecunia.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.InvalidParameterException;
import java.text.SimpleDateFormat;
import java.util.InputMismatchException;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.dao.LoanRequestDAO;
import com.capgemini.pecunia.model.Customer;
import com.capgemini.pecunia.model.LoanRequest;

public class LoanRequestDAOImpl implements LoanRequestDAO {


	public double calculateEMI(double amount, int tenure, double loanRoi) {
		if(amount<0||tenure<0||loanRoi<0) {
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

	public boolean validateCustomerId(String loanCustomerId)
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader("Customer.csv"));
			String line;
			while ((line = br.readLine()) != null) {
				String arr[] = line.split(",");
				if (arr[0].equals(loanCustomerId)) {
					br.close();
					return true;
				}
			}
			br.close();
			return false;
		} catch (Exception e) {
			
			return false;
		}
	}
	public String createLoanRequest(String loanCustomerId, double loanAmount, String loanType, int tenure,
			double loanRoi, String loanStatus, int creditScore) {
		
		if(!validateCustomerId(loanCustomerId))
		{
			//throw new InputMismatchException();
			return null;
		}
		if(loanCustomerId.equals(null)||loanType.equals(null)||loanStatus.equals(null)) {
			return null;
		}
		if(loanType!="Home Loan"|| loanType!= "Vehicle Loan" || loanType!= "Jewel Loan"|| loanType!= "Perosonal Loan")
		{
			throw new InvalidParameterException();
		}
		if(loanAmount<0||tenure<0||loanRoi<0)
		{
			throw new InvalidParameterException();
		}
		if(loanStatus!="Pending")
		{
			throw new InvalidParameterException();
		}
		
		double emi = calculateEMI(loanAmount, tenure, loanRoi);
		String loanRequestId = Utility.getAlphaNumericString();
		
		LoanRequest loanreq = new LoanRequest(loanRequestId, loanCustomerId, loanAmount, loanType, tenure, loanRoi,
				loanStatus, emi, creditScore);
		try {
			String loanRequestData = loanreq.getLoanRequestData();
			File loancustomerFile = new File("LoanRequest.csv");
			FileWriter fr = new FileWriter(loancustomerFile, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(loanRequestData);
			br.newLine();
			br.close();
			return loanRequestId;
		} catch (Exception e) {
			return null;

		}
	}
	public String getCustomerRow(String loanCustomerId) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("Customer.csv"));
			String line;
			while ((line = br.readLine()) != null) {
				String arr[] = line.split(",");
				if (arr[0].equals(loanCustomerId)) {
					break;
				}
			}
			br.close();
			return line;
		} catch (Exception e) {
			return null; 
		}
	}
}
