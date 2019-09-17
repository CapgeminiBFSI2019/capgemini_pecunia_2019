package com.capgemini.pecunia;

import com.capgemini.pecunia.service.AccountServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "chapp nish na" );
        System.out.println("Anish edit");
        System.out.println("Ankit");
        System.out.println(new AccountServiceImpl().addAccount(null,null,null,null,null, null, null, null, null, null,null,null,"gfdestetjhesr", -1.4, -1.0, null, null));
//        new AccountServiceImpl().addAccount(null,null,null,null,null, null, null, null, null, null,null,null,"gfdestetjhesr", -1.4, -1.0, null, null);
    }
}
