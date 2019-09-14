package com.capgemini.pecunia.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

import com.capgemini.pecunia.Utility;
import com.capgemini.pecunia.dao.LoanRequestDAO;
import com.capgemini.pecunia.model.Customer;
import com.capgemini.pecunia.model.LoanRequest;

public class LoanRequestDAOImpl implements LoanRequestDAO {


	public static double calculateEMI(double amount, int tenure, double loanRoi) {
		double p = amount;
		double r = loanRoi / 1200;
		int t = tenure - 1;
		double a = Math.pow(1 + r, tenure);
		double b = Math.pow(1 + r, t);
		double emi = p * r * a / b;
		return emi;
	}

	public String createLoanRequest(String loanCustomerId, double loanAmount, String loanType, int tenure,
			double loanRoi, String loanStatus) {
		double emi = calculateEMI(loanAmount, tenure, loanRoi);
		String loanRequestId = Utility.getAlphaNumericString();
		LoanRequest loanreq = new LoanRequest(loanRequestId, loanCustomerId, loanAmount, loanType, tenure, loanRoi,
				loanStatus, emi);
		try {
			String loanRequestData = loanreq.getLoanRequestData();
			File loancustomerFile = new File("LoanRequest.csv");
			FileWriter fr = new FileWriter(loancustomerFile, true);
			BufferedWriter br = new BufferedWriter(fr);
			br.write(loanRequestData);
			br.newLine();
			br.close();
			fr.close();
		} catch (Exception e) {
			System.out.println(e);

		}

		return loanRequestId;
	}

	public String getCustomerRow(String loanCustomerId) {
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("Customer.csv"));
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String arr[] = line.split(",");
				if (arr[0].equals(loanCustomerId)) {
					return line;
				}
			}
			return line;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}
}
