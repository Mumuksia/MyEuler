package com.euler;


public class Problem_12 {

	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		Integer triNumber = 0;
//		
//		for(int i=1;;i++){
//			triNumber += i;
//			int count =0;
//			for (int j=1; j<(triNumber/2+1);j++){
//				if (triNumber%j == 0) {count++;}				
//				if (count == 500) {System.out.println(triNumber); continue;}
//			}
//			
//		}
//
//	}
	
	  public static void main(String[] args) {

		    long start = System.currentTimeMillis();
		    int num = 1;
		    int sum = 0;
		    while(true){
		      sum += num;
		      if(divisors(sum) >= 500){
		        System.out.println("It is " + sum);
		        break;
		      }
		      num++;
		    }
		    long stop = System.currentTimeMillis();
		     System.out.println("Time: " + (stop-start) + "ms");    
		  }
		  
		  public static int divisors(int sum){
		    int divisors = 2;
		    double root = Math.sqrt(sum);
		    for(int i = 2; i <= root ; i++){
		      if(sum % i == 0){
		        divisors += 2;
		      }
		    }
		    return divisors;
		  }
		}


