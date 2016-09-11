package com.euler;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashMap;


public class PR_53 {

    public static HashMap<Integer, BigInteger> factorials = new HashMap<Integer, BigInteger>();

    public void calculateFactorials() {
        for (Integer i = 1; i < 101; i++) {
            factorials.put(i, factorial(new BigInteger(String.valueOf(i))));
        }
    }

    public BigInteger factorial(BigInteger i) {
        if (i.equals(new BigInteger("1"))) return i;
        if (factorials.containsKey(i.intValue())) return factorials.get(i.intValue());
        return i.multiply(factorial(i.subtract(new BigInteger("1"))));
    }

    @Test
    public void doTest() {
        calculateFactorials();
        int count = 0;
        for (int i = 1; i < 101; i++)
            for (int j = 1; j < i; j++) {

                BigInteger calc = factorials.get(i).divide(factorials.get(j).multiply(factorials.get(i - j)));
                if (calc.compareTo(new BigInteger("1000000")) == 1) {
                    count++;
                }
            }

        System.out.println(count);

    }

}
