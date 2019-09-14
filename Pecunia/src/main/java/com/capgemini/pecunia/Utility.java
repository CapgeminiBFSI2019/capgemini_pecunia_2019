package com.capgemini.pecunia;

import java.util.Date;
import java.text.SimpleDateFormat;  

public class Utility {
	public static String getAlphaNumericString() {

		// chose a Character random from this String
		String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";

		// create StringBuffer size of AlphaNumericStringsss
		StringBuilder sb = new StringBuilder(20);

		for (int i = 0; i < 20; i++) {

			// generate a random number between
			// 0 to AlphaNumericString variable length
			int index = (int) (AlphaNumericString.length() * Math.random());

			// add Character one by one in end of sb
			sb.append(AlphaNumericString.charAt(index));
		}

		return sb.toString();
	}
	
	public static boolean getUpdatedTrans(String transDate, String updatedDate) {
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date currentDate = new Date();  
	    String strDate = formatter.format(currentDate);   
		
		if(transDate.compareToIgnoreCase(updatedDate)>0 && transDate.compareToIgnoreCase(strDate)<0)
		{
			return true;
		}
		else 
			return false;
	}
	//dfgr
	public static void main(String[] args) {
		System.out.println(getAlphaNumericString());
		
	}
}
