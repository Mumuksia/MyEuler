package com.euler;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;


public class Problem_142 {

    List<Integer> sqrs = new LinkedList<Integer>();
    List<Integer> notSqrs = new LinkedList<Integer>();

    public boolean getSquare(int x) {
        if (sqrs.contains(x)) return true;
        if (notSqrs.contains(x)) return false;
        if (Math.sqrt(Double.valueOf(String.valueOf(x))) % 1 < 0.000000001) {
            sqrs.add(x);
            return true;
        } else {
            notSqrs.add(x);
            return false;
        }

    }

    public boolean checkSum(int x, int y, int z) {
        if (getSquare(x + y))
            if (getSquare(x - y))
                if (getSquare(x + z))
                    if (getSquare(x - z))
                        if (getSquare(z + y))
                            if (getSquare(y - z))
                                return true;
        return false;

    }

    public int getResult() {
        sqrs.add(1);
        sqrs.add(4);
        for (int sum = 6; ; sum++) {
            if (sum % 300 == 0) {
                System.out.println(sum + " debug ");
                System.out.println(sqrs.size() + " siize ");
            }
            for (int i = sum - 3; i > sum / 2; i--) {
                for (int j = i - 1; j > 2; j--) {
                    //for (int k = 1; k<j; k++){
                    int k = sum - i - j;

                    if (k >= j || k <= 0) continue;
                    if (i + j + k == sum) {
                        if (checkSum(i, j, k)) {
                            System.out.println(i + " " + j + " " + k + " sum " + sum);
                            return sum;
                        }
                    }
                    //}
                }
            }
        }
    }

    @Test
    public void doTest() {
        System.out.println(getResult());
    }

}
