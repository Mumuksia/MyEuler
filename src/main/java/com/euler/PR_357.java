package com.euler;


import com.euler.utils.AtkinSieve;
import org.junit.Test;

public class PR_357 {


    @Test
    public void doTest() {
        long time = System.currentTimeMillis();
        System.out.println(getSum(100000000));
        System.out.println(System.currentTimeMillis() - time);

    }

    public long getSum(int limit) {
        long time = System.currentTimeMillis();
        long sum = 0;
        int sqrt = 0;
        boolean flag = false;
        boolean[] primes = AtkinSieve.getPrimesBool(limit);
        System.out.println(System.currentTimeMillis() - time);

        for (int in = 1; in < limit; in++) {
            if (!primes[in + 1]) continue;
            flag = true;
            sqrt = (int) Math.sqrt(in);

            for (int i = 1; i <= sqrt; i++) {
                if (in % i == 0 && !primes[i + in / i]) {
                    flag = false;
                    break;
                }
            }
            if (!flag) continue;
            sum += in;
        }

        return sum;
    }

}
