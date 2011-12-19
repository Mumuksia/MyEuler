package com.euler;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class P_26 {
	
	static final BigInteger START = new BigInteger("501");
	static final BigInteger TEMP = new BigInteger("1000");
	static final BigInteger TWO = new BigInteger("2");
	static final BigInteger TEST = new BigInteger("7");
	static final BigDecimal ONE = new BigDecimal(1);
	
	@Test
	public void doTest(){
		
		Set<BigInteger> prs = getPrimes();
		int max = 7;
		BigInteger maxB = TWO;
		for (BigInteger bigI : prs) {
			if (getSeq(bigI).length() > max) 
				{
				max = getSeq(bigI).length();
				maxB = bigI;
				}
		}
		System.out.println("length = " + max + " number " + maxB);
	}
	
	public Set<BigInteger> getPrimes(){
		Set<BigInteger> primes = new HashSet<BigInteger>();
		for (BigInteger i = START; i.compareTo(TEMP) == -1; i = i.add(TWO)){
			if (i.isProbablePrime(10)){
				primes.add(i);
			}
		}
		return primes;
	}
	
	public String getSeq(BigInteger n){
		BigDecimal bd = new BigDecimal(n);		
		bd = ONE.divide(bd,4020,RoundingMode.CEILING);
		String number = bd.toPlainString();
		if (number.length() > 4000){
		number = number.substring(2, 4000);
		for (int i=5;;i++){
			if (number.substring(0, i).equals(number.substring(i, i+i))){
				return number.substring(0, i);
			}
		}
		}
		return "";
	}
	
	

}
