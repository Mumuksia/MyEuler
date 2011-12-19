package com.euler;

import java.util.LinkedList;
import java.util.List;

public class Problem_7 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> primes = new LinkedList<Integer>();
		
		primes.add(2);
		
		while (primes.size() < 10002){
			for (Integer i=primes.get(primes.size()-1)+1;;i++){
				boolean flag  = true;
				for (Integer r : primes) {
					if (i%r == 0) {flag  = false;}
				}
				if (flag) {primes.add(i); System.out.println(i); break;}
			}
		}
		System.out.println("result" + primes.get(10000));
		
	}

}
