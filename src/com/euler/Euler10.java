package com.euler;

public class Euler10 {
	static long[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};
	static long ds = 4000000;
	static long L = 2 * ds + 1;
	static long bestn = Long.MAX_VALUE;
 
	static void go(long divs, int pi, long n, long max) {
		long n2 = n;
		for(long i = 3; i <= max; i += 2) {
			n2 *= prime[pi];
			if(n2 > bestn) return;
			long divs2 = divs * i;
			if(divs2 >= L) {
				bestn = n2;
				return;
			}
			go(divs2, pi + 1, n2, i);
		}
	}
 
	public static void main(String[] args) {
		go(1, 0, 1, L);
		System.out.println(bestn);
	}
}