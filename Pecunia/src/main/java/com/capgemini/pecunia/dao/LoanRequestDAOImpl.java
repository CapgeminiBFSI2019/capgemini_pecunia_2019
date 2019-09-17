package com.capgemini.pecunia.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.InvalidParameterException;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.model.LoanRequest;

public class LoanRequestDAOImpl implements LoanRequestDAO {

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

	// Checking whether loan applicant's account in our database
	public boolean validateCustomerId(String loanCustomerId) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(
					"C:\\Users\\risrai\\git\\capgemini_pecunia_2019\\Pecunia\\src\\main\\java\\com\\capgemini\\pecunia\\dao\\DbFiles\\Customer.csv"));
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

		try {
		if (!validateCustomerId(loanCustomerId)) {
			// throw new InputMismatchException();
			throw new InvalidParameterException();
		}
		if (loanCustomerId.equals(null) || loanType.equals(null) || loanStatus.equals(null)) {
			return null;
		}
		if (loanType != "Home Loan" || loanType != "Vehicle Loan" || loanType != "Jewel Loan"
				|| loanType != "Personal Loan") {
			throw new InvalidParameterException();
		}
		if (loanAmount < 0 || tenure < 0 || loanRoi < 0) {
			throw new InvalidParameterException();
		}
		if (loanStatus != "Pending") {
			throw new InvalidParameterException();
		}
		if (creditScore <= 0) {
			throw new InvalidParameterException();
		}

		// Getting EMI using calculateEMI method for given values of loan amount,tenure
		// and rate of interest
		double emi = calculateEMI(loanAmount, tenure, loanRoi);

		// Getting loan request ID generated using Utility function
		String loanRequestId = Utility.getAlphaNumericString(20);

		// Creating object of loanRequest and passing values to it
		LoanRequest loanreq = new LoanRequest(loanRequestId, loanCustomerId, loanAmount, loanType, tenure, loanRoi,
				loanStatus, emi, creditScore);

		// Writing loan applicant's loan Data to file
			String loanRequestData = loanreq.getLoanRequestData();
			File loancustomerFile = new File("LoanRequest.csv");
			FileWriter fr = new FileWriter(loancustomerFile, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(loanRequestData);
			br.newLine();
			br.close();
			return loanRequestId;
		}catch (InvalidParameterException e) {
			throw new InvalidParameterException("Some input mismatch found.");
		} 
		catch (Exception e) {
			return null;
		}
	}

	// Fetching Loan applicant's Personal Data
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
