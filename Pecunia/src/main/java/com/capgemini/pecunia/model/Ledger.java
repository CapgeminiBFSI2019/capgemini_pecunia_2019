package com.capgemini.pecunia.model;

import java.util.Date;

public class Ledger 
{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ledgerCreditAmount == null) ? 0 : ledgerCreditAmount.hashCode());
		result = prime * result + ((ledgerDate == null) ? 0 : ledgerDate.hashCode());
		result = prime * result + ((ledgerDebitAmount == null) ? 0 : ledgerDebitAmount.hashCode());
		result = prime * result + ((ledgerId == null) ? 0 : ledgerId.hashCode());
		result = prime * result + ledgerNumOfLoans;
		result = prime * result + ((ledgerTotalLoanAmt == null) ? 0 : ledgerTotalLoanAmt.hashCode());
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
		Ledger other = (Ledger) obj;
		if (ledgerCreditAmount == null) {
			if (other.ledgerCreditAmount != null)
				return false;
		} else if (!ledgerCreditAmount.equals(other.ledgerCreditAmount))
			return false;
		if (ledgerDate == null) {
			if (other.ledgerDate != null)
				return false;
		} else if (!ledgerDate.equals(other.ledgerDate))
			return false;
		if (ledgerDebitAmount == null) {
			if (other.ledgerDebitAmount != null)
				return false;
		} else if (!ledgerDebitAmount.equals(other.ledgerDebitAmount))
			return false;
		if (ledgerId == null) {
			if (other.ledgerId != null)
				return false;
		} else if (!ledgerId.equals(other.ledgerId))
			return false;
		if (ledgerNumOfLoans != other.ledgerNumOfLoans)
			return false;
		if (ledgerTotalLoanAmt == null) {
			if (other.ledgerTotalLoanAmt != null)
				return false;
		} else if (!ledgerTotalLoanAmt.equals(other.ledgerTotalLoanAmt))
			return false;
		return true;
	}
	private String ledgerId;
	private Date ledgerDate;
	private Double ledgerDebitAmount;
	private Double ledgerCreditAmount;
	private int ledgerNumOfLoans;
	private Double ledgerTotalLoanAmt;
	public Ledger(String ledgerId, Date ledgerDate, Double ledgerDebitAmount, Double ledgerCreditAmount,
			int ledgerNumOfLoans, Double ledgerTotalLoanAmt) {
		super();
		this.ledgerId = ledgerId;
		this.ledgerDate = ledgerDate;
		this.ledgerDebitAmount = ledgerDebitAmount;
		this.ledgerCreditAmount = ledgerCreditAmount;
		this.ledgerNumOfLoans = ledgerNumOfLoans;
		this.ledgerTotalLoanAmt = ledgerTotalLoanAmt;
	}
	public String getLedgerId() {
		return ledgerId;
	}
	public void setLedgerId(String ledgerId) {
		this.ledgerId = ledgerId;
	}
	public Date getLedgerDate() {
		return ledgerDate;
	}
	public void setLedgerDate(Date ledgerDate) {
		this.ledgerDate = ledgerDate;
	}
	public Double getLedgerDebitAmount() {
		return ledgerDebitAmount;
	}
	public void setLedgerDebitAmount(Double ledgerDebitAmount) {
		this.ledgerDebitAmount = ledgerDebitAmount;
	}
	public Double getLedgerCreditAmount() {
		return ledgerCreditAmount;
	}
	public void setLedgerCreditAmount(Double ledgerCreditAmount) {
		this.ledgerCreditAmount = ledgerCreditAmount;
	}
	public int getLedgerNumOfLoans() {
		return ledgerNumOfLoans;
	}
	public void setLedgerNumOfLoans(int ledgerNumOfLoans) {
		this.ledgerNumOfLoans = ledgerNumOfLoans;
	}
	public Double getLedgerTotalLoanAmt() {
		return ledgerTotalLoanAmt;
	}
	public void setLedgerTotalLoanAmt(Double ledgerTotalLoanAmt) {
		this.ledgerTotalLoanAmt = ledgerTotalLoanAmt;
	}
	
}
