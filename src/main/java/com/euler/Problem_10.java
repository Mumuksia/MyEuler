package com.euler;

import java.util.List;

public class Problem_10 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(sumOfAllPrime(2000000));
	}
	
	public static Integer getSum(List<Integer> values){
		Integer sum = 0;
		for (Integer in : values) {
			sum += in;
		}
		return sum;
	}
	
	  public static boolean isPrime(int i) {
	        if (i < 2) {
	            return false;
	        } else if (i % 2 == 0 && i != 2) {
	            return false;
	        } else {
	            for (int j = 3; j <= Math.sqrt(i); j = j + 2) {
	                if (i % j == 0) {
	                    return false;
	                }
	            }

	            return true;
	        }
	    }
	  
	  public static long sumOfAllPrime(int number){
	        long sum = 2;

	        for (int i = 3; i <= number; i += 2) {
	            if (isPrime(i)) {
	                sum += i;
	            }
	        }

	        return sum;
	    }



}
