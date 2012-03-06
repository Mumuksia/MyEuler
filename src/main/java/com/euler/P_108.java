package com.euler;

import java.math.BigInteger;

import org.testng.annotations.Test;

public class P_108 {
	
	static BigInteger ONE = new BigInteger ("1");
	static BigInteger TEMP = new BigInteger ("12252240");
	static BigInteger TWO = new BigInteger ("2");
	
	@Test
	public void doTest(){
		long start  = System.currentTimeMillis();
//		for (BigInteger j  =TEMP;;j = j.add(TWO)){	
//			int sol = getSolutions(j);
//			if (sol > 1000){
//			System.out.println("result " + j + " count " + sol);
//			break;
//			}
//		}
		
		getNum();
		System.out.println(2*3*5*7*11);
		System.out.println(System.currentTimeMillis() - start);

	}
	
	/*
	 * x = y*n/(y-n)
	 * n  = 1 .. 
	 * (y-n)/n*y < 1/n
	 */
	
	public int getSolutions(BigInteger n){
		
		BigInteger[] res;
		BigInteger x;
		BigInteger y;
		int count =  0;
		
		
			for (BigInteger i = n.add(ONE); ; i = i.add(ONE)){
						
						res = (i.multiply(n)).divideAndRemainder(i.subtract(n));
						x = res[1];
						y = res[0];
						
						if (y.compareTo(i) == -1){
							return count;
						}
						if (y.compareTo(i) == 0){
							count ++;
							return count;
						}
						if (x.compareTo(new BigInteger("0")) == 0){						
						count ++;
						}
						if (y.compareTo(i) == 0){
							return count;
						}
						if ((y.subtract(n)).compareTo(ONE) == -1 ){
							return count;
						}
						
					}
			
			}
		
		
	public static void getNum(){
		long n = 2 * 3 * 5 * 7 * 11;
		while (true) {
			long sq = n * n;
			int count = 2;
			for (int i = 2; i < n; i++) {
				if (sq % i == 0) {
					count++;
				}
			}
			if (count > 1000) {
				System.out.println(n + " " + count);
				break;
			}
			n += 2 * 3 * 5 * 7 * 11;
		}
	}
		
		

	}
	


