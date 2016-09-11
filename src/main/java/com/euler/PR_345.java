package com.euler;

import com.euler.utils.FileUtilsEuler;
import org.junit.Test;

import java.io.IOException;
import java.util.HashSet;

public class PR_345 {

    public int[][] matrix;
    public int max = 0;

    public static int count = 14 * 7 + 7;

    public HashSet<Integer> columns = new HashSet<Integer>();

    @Test
    public void doTest() throws IOException {
        matrix = FileUtilsEuler.readFile();
        getResultDP(matrix);
    }

    public void getResultDP(int[][] mat) {
        int n = mat.length;
        int k = 1 << n;
        int[][] f = new int[n + 1][1 << n];
        for (int i = 0; i < n; ++i) {
            for (int b = 0; b < (1 << n); ++b) {
                for (int j = 0; j < n; ++j) {
                    int kk = (b >> j);
                    kk = kk & 1;
                    if (((b >> j) & 1) == 0) {
                        f[i + 1][b | (1 << j)] = Math.max(f[i + 1][b | (1 << j)],
                                f[i][b] + mat[i][j]);
                    }
                }
            }
        }
        System.out.println("ans = " + f[n][(1 << n) - 1]);
    }

}
