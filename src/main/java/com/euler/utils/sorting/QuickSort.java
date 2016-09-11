package com.euler.utils.sorting;

import org.junit.Test;

import java.util.Random;


public class QuickSort {

    public static int[] result;

    public static int countLast = 0;
    public static int countFirst = 0;
    public static int countMedium = 0;

    @Test
    public void doSort() {
        init();
        splitQuick(0, result.length - 1);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public void init() {
        result = new int[50];
        Random generator = new Random();
        for (int i = 0; i < result.length; i++) {
            result[i] = generator.nextInt(5);
        }
    }

    public static void splitQuick(int low, int high) {

        int i = low, j = high;
        int pivot = result[i + (j - i) / 2];
        do {
            while (result[i] < pivot) i++;
            while (result[j] > pivot) j--;


            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }

        } while (i <= j);
        if (low < j)
            splitQuick(low, j);
        if (i < high)
            splitQuick(i, high);
    }

    public static void splitPivotFirst(int low, int high) {
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            countFirst++;
            if (result[j] < result[low]) {
                exchange(j, i);
                i++;
            }
        }
        exchange(low, i - 1);

        if (low < i - 2)
            splitPivotFirst(low, i - 2);
        if (i < high)
            splitPivotFirst(i, high);
    }

    public static void splitPivotLastTest(int low, int high) {
        exchange(low, high);
        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            countLast++;
            if (result[j] < result[low]) {
                exchange(j, i);
                i++;
            }
        }
        exchange(low, i - 1);

        if (low < i - 2)
            splitPivotLastTest(low, i - 2);
        if (i < high)
            splitPivotLastTest(i, high);
    }

    public static void splitPivotMediana(int low, int high) {
        int mediana = getMediana(low, high);
        if ((result[high] < result[low] && result[high] > result[mediana]) || (result[high] > result[low] && result[high] < result[mediana])) {
            exchange(low, high);
        } else if ((result[mediana] < result[low] && result[mediana] > result[high]) || (result[mediana] > result[low] && result[mediana] < result[high])) {
            exchange(mediana, low);
        }

        int i = low + 1;
        for (int j = low + 1; j <= high; j++) {
            countMedium++;
            if (result[j] < result[low]) {
                exchange(j, i);
                i++;
            }
        }
        exchange(low, i - 1);

        if (low < i - 2)
            splitPivotMediana(low, i - 2);
        if (i < high)
            splitPivotMediana(i, high);

    }

    public static int getMediana(int low, int high) {

        return low + (high - low) / 2;

    }

    private static void exchange(int i, int j) {
        int temp = result[i];
        result[i] = result[j];
        result[j] = temp;
    }

    public static void splitPivotLast(int low, int high) {
        int i = low;
        for (int j = low; j < high; j++) {
            countLast++;
            if (result[j] < result[high]) {
                exchange(j, i);
                i++;
            }
        }
        exchange(high, i);

        if (low < i - 1)
            splitPivotLast(low, i - 1);
        if (i + 1 < high)
            splitPivotLast(i + 1, high);
    }

}
