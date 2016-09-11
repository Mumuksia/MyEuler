package com.euler;

import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;


public class PR_41 {

    public static ArrayList<String> digits = new ArrayList<String>();

    BigInteger prime = new BigInteger("987651243");

    @Test
    public void doTest() {
        System.out.println(prime.isProbablePrime(10));
    }

    public static void fillIn() {
        for (int i = 9; i > 0; i--) {
            digits.add(String.valueOf(i));
        }
    }


}
