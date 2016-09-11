package com.euler;


import org.junit.Test;

public class PR_33 {

    @Test
    public void doTest() {
        System.out.println(check(26, 65));
        for (int i = 10; i <= 99; i++) {
            for (int j = i + 1; j <= 99; j++) {
                if (check(i, j)) {
                    System.out.println(i + "/" + j);
                }
            }
        }
    }

    public static boolean check(int n, int m) {

        String ns = String.valueOf(n);
        String ms = String.valueOf(m);

        if (ns.charAt(1) == ms.charAt(0) && ns.charAt(0) != ms.charAt(0)) {
            int nns = Integer.valueOf(String.valueOf(ns.charAt(0)));
            int mms = Integer.valueOf(String.valueOf(ms.charAt(1)));
            if (m / n == mms / nns && m % n == mms % nns) {
                return true;
            }
        }

        if (ns.charAt(0) == ms.charAt(1) && ns.charAt(0) != ms.charAt(0)) {
            int nns = Integer.valueOf(String.valueOf(ns.charAt(1)));
            int mms = Integer.valueOf(String.valueOf(ms.charAt(0)));
            if (nns != 0 && m / n == mms / nns && m % n == mms % nns) {
                return true;
            }
        }

        return false;
    }

}
