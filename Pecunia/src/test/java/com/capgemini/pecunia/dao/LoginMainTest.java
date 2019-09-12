package com.capgemini.pecunia.dao;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

public class LoginMainTest {
	 
    @Test
    public void validatePassword_Null() {
       // setup
        String password = null;
 
        // execute
        boolean actual = LoginMain.validateLoginPassword(password);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validatePassword_EmptyString() {
       // setup
        String password = "";
 
        // execute
        boolean actual = LoginMain.validateLoginPassword(password);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validatePassword_Missing_OneNumber() {
       // setup
        String password = "Abcdefg#";
 
        // execute
        boolean actual = LoginMain.validateLoginPassword(password);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validatePassword_Missing_OneUpperCaseLetter() {
       // setup
        String password = "abcdefg5#";
 
        // execute
        boolean actual = LoginMain.validateLoginPassword(password);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validatePassword_Missing_OneLowerCaseLetter() {
       // setup
        String password = "ABCDEFG5#";
 
        // execute
        boolean actual = LoginMain.validateLoginPassword(password);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validatePassword_Missing_OneSymbol() {
       // setup
        String password = "Abcdefg5";
 
        // execute
        boolean actual = LoginMain.validateLoginPassword(password);
 
        // assert
        assertFalse(actual);
    }
 
    @Test
    public void validatePassword_AllRulesMet() {
       // setup
        String password = "Abcdefg5#";
 
        // execute
        boolean actual = LoginMain.validateLoginPassword(password);
 
        // assert
        assertTrue(actual);
    }
 
    @Test
    public void validatePassword_LengthTooLong() {
       // setup
        String password = "Abcdefg5#abcdefgabcd";
 
        // execute
        boolean actual = LoginMain.validateLoginPassword(password);
 
        // assert
        assertFalse(actual);
    }
 
}