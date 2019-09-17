package com.capgemini.pecunia;

import java.util.Date;
import java.text.SimpleDateFormat;  
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
	
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
	{ 
		// Static getInstance method is called with hashing SHA 
		MessageDigest md = MessageDigest.getInstance("SHA-256"); 

		// digest() method called 
		// to calculate message digest of an input 
		// and return array of byte 
		return md.digest(input.getBytes(StandardCharsets.UTF_8)); 
	} 
	
	public static String toHexString(byte[] hash) 
	{ 
		// Convert byte array into signum representation 
		BigInteger number = new BigInteger(1, hash); 

		// Convert message digest into hex value 
		StringBuilder hexString = new StringBuilder(number.toString(16)); 

		// Pad with leading zeros 
		while (hexString.length() < 32) 
		{ 
			hexString.insert(0, '0'); 
		} 

		return hexString.toString(); 
	}
	//dfgr
	public static void main(String[] args) {
		System.out.println(getAlphaNumericString());
		boolean answer = getUpdatedTrans("08/08/2018 18:00:00", "08/08/2018 10:55:56");
		System.out.println(answer);
	}
}
