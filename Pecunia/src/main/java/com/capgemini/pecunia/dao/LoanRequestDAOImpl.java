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

	
	public double calculateEMI(double amount, int tenure, double loanRoi) {
		double p = amount;
		double r = loanRoi / 1200;
		int t = tenure - 1;
		double a = Math.pow(1 + r, tenure);
		double b = Math.pow(1 + r, t);
		double emi = p * r * a / b;
		return emi;
	}

	public String createLoanRequest( String loanCustomerId, double loanAmount, String loanType,
			int tenure, double loanRoi, String loanStatus) {
	double emi=calculateEMI(loanAmount, tenure, loanRoi);
	String loanRequestId=Utility.getAlphaNumericString();
	LoanRequest loanreq = new LoanRequest(loanRequestId,loanCustomerId,loanAmount,loanType,tenure,loanRoi,
			loanStatus,emi);
	try {
    String loanRequestData = loanreq.getLoanRequestData();
    File loancustomerFile = new File("CustomerDetails.csv");
    FileWriter fr = new FileWriter(loancustomerFile,true);
    BufferedWriter br = new BufferedWriter(fr);
    br.write(loanRequestData);
    br.newLine();
    br.close();
    fr.close();
	}
	catch(Exception e) {
		
	}
//		String customerId = arr[0];
//		String customerName = arr[1];
//		String customerAddressId = arr[2];
//		String customerAadhar = arr[3];
//		String customerPan = arr[4];
//		int customerContact = Integer.parseInt(arr[5]);
//		String customerGender = arr[6];
//		Date CustomerDob = new SimpleDateFormat("dd/MM/yyyy").parse(arr[7]);
		// Customer c= new
		// Customer(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7]);
		
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
