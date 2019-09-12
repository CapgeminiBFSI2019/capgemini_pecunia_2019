package com.capgemini.pecunia.model;

import java.util.Date;

	public class Ledger
{
	@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(ledgerCreditAmount);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((ledgerDate == null) ? 0 : ledgerDate.hashCode());
			temp = Double.doubleToLongBits(ledgerDebitAmount);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((ledgerId == null) ? 0 : ledgerId.hashCode());
			result = prime * result + ledgerNumOfLoans;
			temp = Double.doubleToLongBits(ledgerTotalLoanAmt);
			result = prime * result + (int) (temp ^ (temp >>> 32));
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
			if (Double.doubleToLongBits(ledgerCreditAmount) != Double.doubleToLongBits(other.ledgerCreditAmount))
				return false;
			if (ledgerDate == null) {
				if (other.ledgerDate != null)
					return false;
			} else if (!ledgerDate.equals(other.ledgerDate))
				return false;
			if (Double.doubleToLongBits(ledgerDebitAmount) != Double.doubleToLongBits(other.ledgerDebitAmount))
				return false;
			if (ledgerId == null) {
				if (other.ledgerId != null)
					return false;
			} else if (!ledgerId.equals(other.ledgerId))
				return false;
			if (ledgerNumOfLoans != other.ledgerNumOfLoans)
				return false;
			if (Double.doubleToLongBits(ledgerTotalLoanAmt) != Double.doubleToLongBits(other.ledgerTotalLoanAmt))
				return false;
			return true;
		}
	private String ledgerId;
	private Date ledgerDate;
	private double ledgerDebitAmount;
	private double ledgerCreditAmount;
	private int ledgerNumOfLoans;
	private double ledgerTotalLoanAmt;
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
	public double getLedgerDebitAmount() {
		return ledgerDebitAmount;
	}
	public void setLedgerDebitAmount(double ledgerDebitAmount) {
		this.ledgerDebitAmount = ledgerDebitAmount;
	}
	public double getLedgerCreditAmount() {
		return ledgerCreditAmount;
	}
	public void setLedgerCreditAmount(double ledgerCreditAmount) {
		this.ledgerCreditAmount = ledgerCreditAmount;
	}
	public int getLedgerNumOfLoans() {
		return ledgerNumOfLoans;
	}
	public void setLedgerNumOfLoans(int ledgerNumOfLoans) {
		this.ledgerNumOfLoans = ledgerNumOfLoans;
	}
	public double getLedgerTotalLoanAmt() {
		return ledgerTotalLoanAmt;
	}
	public void setLedgerTotalLoanAmt(double ledgerTotalLoanAmt) {
		this.ledgerTotalLoanAmt = ledgerTotalLoanAmt;
	}
	
	
}
