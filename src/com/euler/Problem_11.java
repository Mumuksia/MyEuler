package com.euler;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class Problem_11 {
	
	public static String fileName="d:/temp/matrix.txt";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			int[][] values  = readFile();
			Integer max  = 0;
			Integer temp = 0;
			for (int i=19;i>=3;i--)
				for (int j=19;j>=3;j--){
					temp = values[i][j]*values[i-1][j-1]*values[i-2][j-2]*values[i-3][j-3];
					if (temp>max){max = temp;}
					temp = values[i][j]*values[i-1][j]*values[i-2][j]*values[i-3][j];
					if (temp>max){max = temp;}
					temp = values[i][j]*values[i][j-1]*values[i][j-2]*values[i][j-3];
					if (temp>max){max = temp;}
					temp = values[i][j]*values[i-1][j-1]*values[i-2][j-2]*values[i-3][j-3];
					if (temp>max){max = temp;}
					try{
						if (temp>max){max = temp;}
						temp = values[i][j]*values[i-1][j+1]*values[i-2][j+2]*values[i-3][j+3];
						if (temp>max){max = temp;}
						temp = values[i][j]*values[i+1][j-1]*values[i+2][j-2]*values[i+3][j-3];						
					}
					catch(Exception e){}
					
				}
			
			System.out.println(max);
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static int[][] readFile() throws IOException{
		@SuppressWarnings("unchecked")
		List<String> lines = FileUtils.readLines(new File(
				fileName));	
		
		int[][] values = new int[20][20];
		
		int i= 0;
		for(String l : lines){
		String[] ls = l.split(" ");
		int j = 0;
		for (String str : ls) {
			values[i][j] = Integer.valueOf(str).intValue();
			System.out.print(values[i][j] + " ");
			j++;
		}
		System.out.println();
		i++;
		}
		
		return values;
	}

}
