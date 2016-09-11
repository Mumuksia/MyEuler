package com.euler;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;


public class Pr_52 {

    public static HashSet<String> getDigits(BigInteger n) {
        String b = n.toString();
        HashSet<String> digits = new HashSet<String>();
        for (int i = 0; i < b.length(); i++) {
            digits.add(String.valueOf(b.charAt(i)));
        }
        return digits;
    }

    public boolean checkNumber(BigInteger number) {
        if (getDigits(number).equals(getDigits(number.multiply(new BigInteger("2")))) &&
                getDigits(number.multiply(new BigInteger("3"))).equals(getDigits(number.multiply(new BigInteger("4")))) &&
                getDigits(number.multiply(new BigInteger("5"))).equals(getDigits(number.multiply(new BigInteger("6")))) &&
                getDigits(number).equals(getDigits(number.multiply(new BigInteger("3")))) &&
                getDigits(number).equals(getDigits(number.multiply(new BigInteger("5"))))) {
            System.out.println(number);
            return true;
        }
        return false;
    }

    @Test
    public void doTest() {
        BigInteger i = new BigInteger("1");
        while (true) {
            if (checkNumber(i)) {
                System.out.println(checkNumber(i));
                break;
            }
            i = i.add(new BigInteger("1"));
        }
    }

}
