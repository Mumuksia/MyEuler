package com.euler.utils;

import org.junit.Test;

import java.util.ArrayList;


public class AtkinSieve {

    @Test
    public void doTest() {
        long time = System.currentTimeMillis();
        ArrayList<Integer> primes = getPrimesInt(100000000);
        System.out.println(primes.size());
        System.out.println(System.currentTimeMillis() - time);
    }


    public static ArrayList<Integer> getPrimesInt(int limit) {
        boolean[] primes = new boolean[limit + 1];
        ArrayList<Integer> result = new ArrayList<Integer>();

        int n = 0;

        for (int x = 1; x < Math.sqrt(limit); x++)
            for (int y = 1; y < Math.sqrt(limit); y++) {
                n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    primes[n] ^= true;
                }

                n = 3 * x * x + y * y;
                if ((n <= limit) && (n % 12 == 7)) {
                    primes[n] ^= true;
                }

                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11)) {
                    primes[n] ^= true;
                }
            }

        for (int i = 5; i < Math.sqrt(limit); i += 2) {
            if (primes[i]) {
                int t = i * i;
                for (int j = t; j <= limit; j += t) {
                    primes[j] = false;
                }
            }
        }


        result.add(2);

        result.add(3);

        for (int i = 5; i <= limit; i += 2) {
            if (primes[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static boolean[] getPrimesBool(int limit) {
        boolean[] primes = new boolean[limit + 1];

        int n = 0;

        for (int x = 1; x < Math.sqrt(limit); x++)
            for (int y = 1; y < Math.sqrt(limit); y++) {
                n = 4 * x * x + y * y;
                if (n <= limit && (n % 12 == 1 || n % 12 == 5)) {
                    primes[n] ^= true;
                }

                n = 3 * x * x + y * y;
                if ((n <= limit) && (n % 12 == 7)) {
                    primes[n] ^= true;
                }

                n = 3 * x * x - y * y;
                if ((x > y) && (n <= limit) && (n % 12 == 11)) {
                    primes[n] ^= true;
                }
            }

        for (int i = 5; i < Math.sqrt(limit); i += 2) {
            if (primes[i]) {
                int t = i * i;
                for (int j = t; j <= limit; j += t) {
                    primes[j] = false;
                }
            }
        }

        primes[2] = true;
        primes[3] = true;

        return primes;
    }


}
