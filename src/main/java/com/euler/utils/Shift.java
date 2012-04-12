package com.euler.utils;

public class Shift {
    
    /** */
    static int counter = 0;
    
    /**
     * @param args 
     */
    public static void main(String[] args) {   
 
        int[] arr = {0, 1, 2, 3, 4};
        printArr(null, arr);
        shifter(new int[] {}, arr);
    }
    
    /**
     * 
     * @param arrHead 
     * @param arrTail 
     */
    private static void shifter(int[] arrHead, int[] arrTail) {
        
        if (arrTail.length <= 1) {
            return;
        }
 
        for (int i = 0; i < arrTail.length; i++) {
            int[] arrBuf = arrTail.clone();           
            shiftOn(arrBuf, i);
            int[] arrNewHead = incrementArr(arrHead, arrBuf[0]);
            int[] arrNewTail = decrementArr(arrBuf);
            if (i != 0) {
                printArr(arrNewHead, arrNewTail);
            }
            
            shifter(arrNewHead, arrNewTail);           
        }
    }
 
    
    /**
     * @param arr
     * @param shift
     */
    private static void shiftOn(int[] arr, int shift) {
        if (shift % arr.length != 0) {
            reverse(arr, 0, shift - 1);
            reverse(arr, shift, arr.length - 1);
            reverse(arr, 0, arr.length - 1);
        }
       
    }
 
    
 
    /**
     * @param arr
     */
    private static int[] decrementArr(int[] arr) {
        
        int[] arrNext = new int [arr.length - 1];            
        for (int item = 0; item < arrNext.length; item++) {
            arrNext[item] = arr[item + 1];
        }
        return arrNext;
    }
    
    /**
     * 
     * @param arr
     * @param num
     * @return
     */
    private static int[] incrementArr(int[] arr, int num) {
        int[] arrNext = new int [arr.length + 1];            
        for (int item = 0; item < arr.length; item++) {
            arrNext[item] = arr[item];
        }
        arrNext[arr.length] = num;
        return arrNext;
    }
 
 
    /**
     * 
     * @param arrBuf
     * @param firstCycleElement
     * @param secondCycleElement
     */
    private static void reverse(int[] arrBuf, int first, int second) {
        int buf;
        
        int firstCycleElement = first % arrBuf.length;
        int secondCycleElement = second % arrBuf.length;
        
        buf = arrBuf[firstCycleElement];
        arrBuf[firstCycleElement] = arrBuf[secondCycleElement];
        arrBuf[secondCycleElement] = buf;
    }
    
    /**
     * 
     * @param arr
     */
    private static void printArr(int[] arrHead, int[] arrTail) {
        System.out.print(++counter + ": ");
        if (arrHead != null && arrHead.length != 0) {
            for (int item : arrHead) {
                System.out.print(item);
            }
        }
        if (arrTail != null && arrTail.length != 0) {
            for (int item : arrTail) {
                System.out.print(item);
            }
        }
       
        System.out.println();
    }
}