package com.euler;

public class Problem_9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int c = 0;
		for (int i = 0; i< 500; i ++)
			for (int j = 0; j< 500; j++){
				double sum = i + j + Math.sqrt(i*i + j*j);
				Double s  = new Double(sum);
				c = s.intValue();
				if (c == 1000){System.out.println(i + " "+ j+ " " + Math.sqrt(i*i + j*j));}
			}
		System.out.println("result" + 375*200*425);

	}

}
