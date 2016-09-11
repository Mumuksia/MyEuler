package com.euler;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;


public class PR_51 {


    @Test
    public void doTest() {
        Primes.setPrimes(Primes.TEMP);

        for (BigInteger pr : Primes.primes) {
            int[] pos = checkPrime3(pr);
            if (pos.length >= 3) {
                if (getFamily3(pr, pos).size() == 8) {
                    System.out.println(pr);
                }
            }
        }

        System.out.println("nothing");
    }

    public int[] checkPrime3(BigInteger n) {
        char[] digits = n.toString().toCharArray();
        int count0 = 0, count1 = 0, count2 = 0;
        int[] c0 = new int[3], c1 = new int[3], c2 = new int[3];
        int[] c5 = new int[1];
        for (int i = 0; i < digits.length; i++) {
            char c = digits[i];
            if ('0' == c) {
                c0[count0] = i;
                count0++;
            } else if ('1' == c) {
                c1[count1] = i;
                count1++;
            } else if ('2' == c) {
                c2[count2] = i;
                count2++;
            }
            if (count0 >= 3) {
                return c0;
            }
            if (count1 >= 3) {
                return c1;
            }
            if (count2 >= 3) {
                return c2;
            }
        }


        return c5;
    }

    public HashSet<BigInteger> getFamily3(BigInteger n, int[] positions) {
        char[] bi = n.toString().toCharArray();
        HashSet<BigInteger> prs = new HashSet<BigInteger>();
        if (positions.length == 3) {
            for (int i = 1; i <= 9; i++) {
                for (int k : positions) {
                    bi[k] = (String.valueOf(i)).charAt(0);      //substring(k, k+1);
                }
                if (fromFromChars(bi).isProbablePrime(20)) {
                    prs.add(fromFromChars(bi));
                }
            }
        }
        return prs;
    }

    public BigInteger fromFromChars(char[] bis) {
        String bb = "";
        for (char c : bis) {
            bb += c;
        }
        return new BigInteger(bb);
    }
}
