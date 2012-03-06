package com.euler;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

import org.testng.annotations.Test;

import com.euler.utils.AtkinSieve;

public class P_357 {

	static final BigInteger ZERO = new BigInteger("65536");
	static final BigInteger ONE = new BigInteger("1");
	static final BigInteger TEMP = new BigInteger("10000000");
	static final BigInteger TWO = new BigInteger("2");
	
	static ArrayList<Integer> primes = new ArrayList<Integer>();
	static HashSet<BigInteger> numbers = new HashSet<BigInteger>();
	
	
	@Test
	public void doTest(){
		long time = System.currentTimeMillis();
		primes = AtkinSieve.getPrimesInt(100000000);
		System.out.println(System.currentTimeMillis() - time);
		Collections.sort(primes);
		System.out.println(System.currentTimeMillis() - time);
	}
	

	
	public void calculateNumbers(){		
		Integer sum = 0;		
		for (int i : primes) {
			checkCondition(i+1);
		}
		System.out.println(sum);
	}
	
	public boolean checkCondition(int n){
		int[] primeDivisors;
		
		
		return true;
	}

	
}
