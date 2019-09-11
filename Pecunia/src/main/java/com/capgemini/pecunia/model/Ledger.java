package com.capgemini.pecunia.model;

import java.util.Date;

public class Ledger 
{
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
