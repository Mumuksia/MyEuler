package com.euler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class P_27 {
	
	static final BigInteger ONE = new BigInteger("1");
	static final BigInteger END = new BigInteger("1000");
	static final BigInteger TWO = new BigInteger("2");
	static final BigInteger TEMP = new BigInteger("13400");
	static int max  = 40; 
	static BigInteger result = ONE;
	
	
	@Test
	public void doTest(){
		long start  = System.currentTimeMillis();
		getAbsolutPrimes();
		getPrimes();
		System.out.println(check());
		System.out.println(System.currentTimeMillis() - start);
	}
	
	static Set<BigInteger> primes  = new HashSet<BigInteger>();
	static Set<BigInteger> sprimes  = new HashSet<BigInteger>();
	
	public static BigInteger check(){
		for (BigInteger a: primes){
			for (BigInteger b: primes){
				for (int i=0;i<80;i++){
					int sum = i*i + a.intValue()*i+b.intValue();
					BigInteger test = new BigInteger(String.valueOf(sum));
					
					if (!sprimes.contains(test)){
						if (i>max) {
							max = i;
							result = a.multiply(b);
							System.out.println(max);
						}
						break;
					}
				}
			}
		}
		return result;
	}
	
	public static void getAbsolutPrimes(){
		primes.add(ONE);
		primes.add(TWO);
		primes.add(ONE.negate());
		primes.add(TWO.negate());
		for (BigInteger i = ONE; i.compareTo(END) == -1; i = i.add(TWO)){
			if (i.isProbablePrime(10)){
				primes.add(i);
				primes.add(i.negate());
			}
		}
	}
	
	public static void getPrimes(){
		sprimes.add(ONE);
		sprimes.add(TWO);
		for (BigInteger i = ONE; i.compareTo(TEMP) == -1; i = i.add(TWO)){
			if (i.isProbablePrime(10)){
				sprimes.add(i);
			}
		}
	}

}
