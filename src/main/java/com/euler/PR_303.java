package com.euler;

import org.testng.annotations.Test;

public class PR_303 {
	
	public boolean checkDigit(long n){
		while(n != 0){
			if (n%10 > 2) return false;
			n = n/10;
		}
		return true;
	}
	
	@Test
	public void doTest(){
		long time = System.currentTimeMillis();

		System.out.println(findSum(10000));
		System.out.println(System.currentTimeMillis()-time);
	}
	
	
	public long f(int n){
		for(int i=1;;i++)
			if (checkDigit(n*i)) return n*i;
	}
	
	public long findSum(int limit){
		long sum = 0;
		for(int i=1;i<=limit;i++){
			if (i!=9999)
			sum =sum + f(i)/i;
		}
		
		sum+= 10002000200020002l / 9;
		return sum;
	}

}
