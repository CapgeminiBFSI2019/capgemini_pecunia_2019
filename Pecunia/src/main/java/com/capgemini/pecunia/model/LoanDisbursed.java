package com.capgemini.pecunia.model;
import java.util.*;
public class LoanDisbursed {

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(emi);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(loanAmtDisbursed);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(loanAmtPaid);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((loanCustAccId == null) ? 0 : loanCustAccId.hashCode());
		result = prime * result + ((loanDueDate == null) ? 0 : loanDueDate.hashCode());
		result = prime * result + ((loanId == null) ? 0 : loanId.hashCode());
		result = prime * result + ((loanProcessId == null) ? 0 : loanProcessId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanDisbursed other = (LoanDisbursed) obj;
		if (Double.doubleToLongBits(emi) != Double.doubleToLongBits(other.emi))
			return false;
		if (Double.doubleToLongBits(loanAmtDisbursed) != Double.doubleToLongBits(other.loanAmtDisbursed))
			return false;
		if (Double.doubleToLongBits(loanAmtPaid) != Double.doubleToLongBits(other.loanAmtPaid))
			return false;
		if (loanCustAccId == null) {
			if (other.loanCustAccId != null)
				return false;
		} else if (!loanCustAccId.equals(other.loanCustAccId))
			return false;
		if (loanDueDate == null) {
			if (other.loanDueDate != null)
				return false;
		} else if (!loanDueDate.equals(other.loanDueDate))
			return false;
		if (loanId == null) {
			if (other.loanId != null)
				return false;
		} else if (!loanId.equals(other.loanId))
			return false;
		if (loanProcessId == null) {
			if (other.loanProcessId != null)
				return false;
		} else if (!loanProcessId.equals(other.loanProcessId))
			return false;
		return true;
	}

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
