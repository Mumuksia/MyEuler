package com.euler;

import java.math.BigInteger;
import java.util.HashSet;

import org.testng.annotations.Test;

public class PR_45 {
	
	private static final BigInteger THREE = new BigInteger("3");
	private static final BigInteger TWO = new BigInteger("2");
	private static final BigInteger ONE = new BigInteger("1");
	private static final BigInteger ZERO = new BigInteger("0");
	private static final BigInteger TEMP = new BigInteger("10000");
	
	public static HashSet<BigInteger> penta = new HashSet<BigInteger>();
	public static HashSet<BigInteger> trian = new HashSet<BigInteger>();
	public static HashSet<BigInteger> hexa = new HashSet<BigInteger>();
	
	public void fillIn(){		
		for (BigInteger i = ONE; i.compareTo(TEMP) == -1; i=i.add(ONE)){
			//hexa.add(i.multiply((i.multiply(TWO)).subtract(ONE)));
			trian.add((i.multiply((i.multiply(THREE)).subtract(ONE))).divide(TWO));
			//penta.add((i.multiply(i.add(ONE))).divide(TWO));
		}
	}
	
	@Test
	public void doTest(){
		fillIn();
		for (BigInteger b : trian) {
			for (BigInteger p : trian) {
				if (trian.contains(p.subtract(b).abs()) && trian.contains(p.add(b))){
					System.out.println(p + " " + b + " " + p.subtract(b).abs());
				}
			}
		}
	}

}
