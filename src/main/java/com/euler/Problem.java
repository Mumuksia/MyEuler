package com.euler;

import java.math.BigInteger;
import java.util.HashSet;

import org.testng.annotations.Test;

public class Problem {
	
	static BigInteger TWO = new BigInteger ("2");
	static BigInteger ONE = new BigInteger ("1");
	static BigInteger TEMP = new BigInteger ("30457");
	//result = 8739992576

	@Test
	public void doTest(){
		long start = System.currentTimeMillis();
//		stupidApproach();	
		BigInteger mult = TWO;
		System.out.println(mult.pow(30457));
		System.out.println(System.currentTimeMillis() - start);

	}
	
	public static BigInteger getTenDigits(BigInteger i){
		if (i.toString().length() < 13) return i;
		return new BigInteger(i.toString().substring(i.toString().length()-13, i.toString().length()));
	}
	
	public void stupidApproach(){
		BigInteger mult = TWO;		
		for (BigInteger i = ONE; i.compareTo(TEMP) == -1; i = i.add(ONE)){
			mult = getTenDigits(mult.multiply(TWO));			
		}
		System.out.println(getTenDigits(mult.multiply(new BigInteger("28433"))));
	}
	
	
	static HashSet<Integer> primes = new HashSet<Integer>();
	
	static HashSet<Integer> dividers = new HashSet<Integer>();
	
	
	
	public static void getPrimes(){
		for (Integer i=1000; i< 9999; i++){
			if ((new BigInteger(String.valueOf(i))).isProbablePrime(100)){
				primes.add(i);
			}
		}
	}
	
	public static void getDividers(){
		
		
		for (Integer prime : primes){
			for (Integer pr : primes){
				if (pr > prime) {
					if (primes.contains(pr + pr - prime)) {
						if (checkNumbers(prime, pr) && checkNumbers(prime, pr + pr - prime) && checkNumbers(pr, pr + pr - prime)) {
						System.out.println(prime + " "+ pr + " " +  (pr + pr - prime));
						}
					}
				}
			}
		}
		
	}

	public static boolean checkNumbers(Integer i, Integer j){
		char[] base = i.toString().toCharArray();
		char[] comp = j.toString().toCharArray();	
		
		for (char b : base) {
			boolean t = false;
			for (char c : comp) {
				if (b == c) t= true;
			}
			if (!t) return false;
		}
		
		return true;
	}
	
	
}
