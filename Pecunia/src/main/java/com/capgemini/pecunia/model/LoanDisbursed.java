package com.capgemini.pecunia.model;
import java.util.*;
public class LoanDisbursed {

	private String loanId; 
	private String loanCustAccId;
	private String loanProcessId;
	private double loanAmtDisbursed;
	private double loanAmtPaid;
	private double emi;
	private Date loanDueDate;
	
	public void setLoanId(String loanId) {
		this.loanId = loanId;
	}
	
	public String getLoanId() {
		return loanId;
	}
	
	public void setLoanCustAccId(String loanCustAccId) {
		this.loanCustAccId = loanCustAccId;
	}
	
	public String getLoanCustAccId() {
		return loanCustAccId;
	}
	
	public void setLoanProcessId(String loanProcessId) {
		this.loanProcessId = loanProcessId;
	}
	
	public String getLoanProcessId() {
		return loanProcessId;
	}
	
	public void setLoanAmtDisbursed(double loanAmtDisbursed) {
		this.loanAmtDisbursed = loanAmtDisbursed;
	}
	
	public double getLoanAmtDisbursed() {
		return loanAmtDisbursed;
	}
	
	public void setLoanAmtPaid(double loanAmtPaid) {
		this.loanAmtPaid = loanAmtPaid;
	}
	
	public double getLoanAmtPaid() {
		return loanAmtPaid;
	}
	
	public void setEmi(double emi) {
		this.emi = emi;
	}
	
	public double getEmi() {
		return emi;
	}
	
	public void setLoanDueDate(Date loanDueDate) {
		this.loanDueDate = loanDueDate;
	}
	
	public Date getLoanDueDate() {
		return loanDueDate;
	}

}
