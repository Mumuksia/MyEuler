package com.euler;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.Test;

public class Pr_38 {
	
	static Set digits = new HashSet();
	static BigInteger mult = new BigInteger("123456789");
	
	@Test
	public void doTest(){
		digits.add('0');
		
		for (int i=10;i<10000;i++){
			check(i);
			clearDigits();
		}
		
		System.out.println(mult);
	}
	
	public static void clearDigits(){
		digits = new HashSet<String>();
		digits.add('0');		
	}

	public boolean check(Integer n){
		if (n.toString().length() == 3){
			digits.add(n.toString().charAt(0));
			digits.add(n.toString().charAt(1));
			digits.add(n.toString().charAt(2));
			
			String m = String.valueOf(n*2);
			digits.add(m.charAt(0));
			digits.add(m.charAt(1));
			digits.add(m.charAt(2));
			
			String k = String.valueOf(n*3);
			digits.add(k.charAt(0));
			digits.add(k.charAt(1));
			digits.add(k.charAt(2));
			
			if (digits.size() == 10) {
				if (mult.compareTo(new BigInteger(n.toString() + m + k)) == -1){
					mult = new BigInteger(n.toString() + m + k);
				}
			}
		}
		
		if (n.toString().length() == 4 && String.valueOf(n*2).length() == 5 && String.valueOf(n).length() == 4){
			digits.add(n.toString().charAt(0));
			digits.add(n.toString().charAt(1));
			digits.add(n.toString().charAt(2));
			digits.add(n.toString().charAt(3));
			
			String m = String.valueOf(n*2);
			digits.add(m.charAt(0));
			digits.add(m.charAt(1));
			digits.add(m.charAt(2));
			digits.add(m.charAt(3));
			digits.add(m.charAt(4));
			

			
			if (digits.size() == 10) {
				if (mult.compareTo(new BigInteger(n.toString() + m)) == -1){
					mult = new BigInteger(n.toString() + m);
				}
			}
		}
		
		if (n.toString().length() == 2 && String.valueOf(n*4).length() ==3 && String.valueOf(n*4).length()==2){
			digits.add(n.toString().charAt(0));
			digits.add(n.toString().charAt(1));			
			
			String m = String.valueOf(n*2);
			digits.add(m.charAt(0));
			digits.add(m.charAt(1));			
			
			String k = String.valueOf(n*3);
			digits.add(k.charAt(0));
			digits.add(k.charAt(1));
			
			String g = String.valueOf(n*4);
			digits.add(g.charAt(0));
			digits.add(g.charAt(1));
			digits.add(g.charAt(2));
			
			if (digits.size() == 10) {
				if (mult.compareTo(new BigInteger(n.toString() + m + k + g)) == -1){
					mult = new BigInteger(n.toString() + m + k + g);
				}
			}
		}	
		
		
		return false;
	}
}
