package com.euler.utils;

import java.util.Arrays;
import java.util.Stack;

public class SecretCombination {
    private static final int USED = Integer.MAX_VALUE;
    public static void printCombination(int[] arr, Stack<Integer> s, int am) {
        if (am == 0) {
            System.out.println(Arrays.toString(s.toArray()));
            return;
        }
        for (int i = 0; i < arr.length; i++) if (arr[i] != USED) {
            s.push(arr[i]);
            arr[i] = USED;
            printCombination(arr, s, am - 1);
            arr[i] = s.pop();
        }
    }
    public static void main(String[] args) {
        printCombination(new int[]{1,2,3,4}, new Stack<Integer>(), 4);
    }
}