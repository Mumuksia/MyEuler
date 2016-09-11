package com.euler;

import org.junit.Test;

import java.math.BigInteger;
import java.util.HashSet;


public class Primes {

    private static final BigInteger THREE = new BigInteger("3");
    private static final BigInteger TWO = new BigInteger("2");
    private static final BigInteger ONE = new BigInteger("1");
    private static final BigInteger ZERO = new BigInteger("0");
    public static final BigInteger TEMP = new BigInteger("1000000");

    public static HashSet<BigInteger> primes = new HashSet<BigInteger>();

    public static void setPrimes(BigInteger limit) {
        primes.add(TWO);

        for (BigInteger i = THREE; i.compareTo(limit) == -1; i = i.add(TWO)) {
            if (i.isProbablePrime(50))
                primes.add(i);
        }

    }

    public HashSet<BigInteger> getFactors(BigInteger n) {
        HashSet<BigInteger> factors = new HashSet<BigInteger>();
        while (true) {
            for (BigInteger i : primes) {
                if (n.remainder(i).equals(ZERO)) {
                    n = n.divide(i);
                    factors.add(i);
                    break;
                }
            }
            if (n.equals(ONE)) return factors;
        }
    }

    @Test
    public void doTest() {
        setPrimes(TEMP);

        HashSet<BigInteger> f = new HashSet<BigInteger>();
        BigInteger temp = new BigInteger("70000");
        while (true) {
            f = getFactors(temp);
            if (f.size() == 4) {
                f = getFactors(temp.add(ONE));
                if (f.size() == 4) {
                    f = getFactors(temp.add(TWO));
                    if (f.size() == 4) {
                        f = getFactors(temp.add(THREE));
                        if (f.size() == 4) {
                            System.out.println(temp);
                            break;
                        }
                    }
                }
            }
            temp = temp.add(ONE);
            if (temp.compareTo(new BigInteger("143050")) == 1) break;
            if (temp.compareTo(new BigInteger("80000")) == 1) break;
        }

    }
}
