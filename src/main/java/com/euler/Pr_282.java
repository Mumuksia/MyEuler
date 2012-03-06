package com.euler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class Pr_282 {
	
	static final BigInteger ZERO = new BigInteger("65536");
	static final BigInteger ONE = new BigInteger("1");
	static final BigInteger TEMP = new BigInteger("2");
	static final BigInteger TWO = new BigInteger("2");
	
	Set<BigInteger> rems = new HashSet<BigInteger>();
	
	@Test
	public void doTest(){
//		System.out.println(getAkkerman(TEMP, TEMP));
	
		
		BigInteger bip = new BigInteger("14");
		bip = bip.pow(8);
		/*
		System.out.println(bi);
		BigInteger mult = TEMP.pow(4096);
		int count = 0;
		for (;;){
			mult = mult.multiply(TEMP);
			mult = mult.remainder(bi);
			if (mult.equals(new BigInteger("103459584"))){
				System.out.println("RESULT"+ count);
				break;
			}
			if (!rems.contains(mult)){
				rems.add(mult);
			}
			else {
				System.out.println("ABRAKADABRA      " + mult);
				break;
			}
			System.out.println(mult + "   " + count + " " + rems.size());
			count ++;
			if (count == 1475789056) break;
		}
		*/
		
		BigInteger bi = TEMP.pow(ZERO.intValue());
		BigInteger mult = TWO;
		for (BigInteger i = ONE; i.compareTo(bi)==-1;i=i.add(ONE)){
			mult = mult.multiply(TWO);
			mult = mult.remainder(bip);
		}
		
		System.out.println(mult);
		
		BigInteger result = TWO;
//		for (BigInteger i = ONE; i.compareTo(mult)==-1;i=i.add(ONE)){
//			result = result.multiply(TWO);
//		}
		
		
		System.out.println(result);
		
	}
	
	public static BigInteger getAkkerman(BigInteger m, BigInteger n){
		
		if (m.compareTo(ZERO) == 0){
			return n.add(ONE);
		}
		
		if (n.compareTo(ZERO) == 0){
			return getAkkerman(m.subtract(ONE), ONE);
		}
		
		return getAkkerman(m.subtract(ONE), getAkkerman(m, n.subtract(ONE)));
		
	}
		

}
