package com.capgemini.pecunia.model;

public class LoanRequest {
	String loanType;
	double loanAmount;
	int tenure;
	double roi;
	public LoanRequest(String loanType, double loanAmount, int tenure, double roi) {
		super();
		this.loanType = loanType;
		this.loanAmount = loanAmount;
		this.tenure = tenure;
		this.roi = roi;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public double getLoanAmount() {
		return loanAmount;
	}
	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public double getRoi() {
		return roi;
	}
	public void setRoi(double roi) {
		this.roi = roi;
	}
	

}
