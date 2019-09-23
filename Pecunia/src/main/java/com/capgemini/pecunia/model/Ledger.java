package com.capgemini.pecunia.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.capgemini.pecunia.Values;

	public class Ledger
{
	@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(creditAmount);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			temp = Double.doubleToLongBits(debitAmount);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + numOfLoans;
			temp = Double.doubleToLongBits(totalLoanAmt);
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
			if (Double.doubleToLongBits(creditAmount) != Double.doubleToLongBits(other.creditAmount))
				return false;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			if (Double.doubleToLongBits(debitAmount) != Double.doubleToLongBits(other.debitAmount))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (numOfLoans != other.numOfLoans)
				return false;
			if (Double.doubleToLongBits(totalLoanAmt) != Double.doubleToLongBits(other.totalLoanAmt))
				return false;
			return true;
		}
	private String id;
	private Date date;
	private double debitAmount;
	private double creditAmount;
	private int numOfLoans;
	private double totalLoanAmt;
	
	
		
	public String getId() {
		return id;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public double getDebitAmount() {
		return debitAmount;
	}
	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}
	public double getCreditAmount() {
		return creditAmount;
	}
	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}
	public int getNumOfLoans() {
		return numOfLoans;
	}
	public void setNumOfLoans(int numOfLoans) {
		this.numOfLoans = numOfLoans;
	}
	public double getTotalLoanAmt() {
		return totalLoanAmt;
	}
	public void setTotalLoanAmt(double totalLoanAmt) {
		this.totalLoanAmt = totalLoanAmt;
	}
	public Ledger(String id, Date date, double debitAmount, double creditAmount, int numOfLoans, double totalLoanAmt) {
		super();
		this.id = id;
		this.date = date;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.numOfLoans = numOfLoans;
		this.totalLoanAmt = totalLoanAmt;
	}
	public static Ledger getLedgerObject(String row) {
		String arr[] = row.split(",");
		Date date;
		try {
		date = new SimpleDateFormat(Values.DATE_FORMAT).parse(arr[1]);
		Ledger ledger= new Ledger(arr[0],date,Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),Integer.parseInt(arr[4]),Double.parseDouble(arr[5]));
		return ledger;
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	
	return null;
}
	
	@Override
	public String toString() {
		return this.id+" "+this.date+" "+this.debitAmount+" "+this.creditAmount+" "+this.numOfLoans+
				" "+this.totalLoanAmt;
	}
}
