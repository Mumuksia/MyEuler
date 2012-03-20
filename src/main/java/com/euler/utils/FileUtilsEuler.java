package com.euler.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileUtilsEuler {
	
	public static String fileName="d:/temp/matrix.txt";
	
	private static final int size = 15; 
	
	public static int[][] readFile() throws IOException{
		@SuppressWarnings("unchecked")
		List<String> lines = FileUtils.readLines(new File(
				fileName));	
		
		int[][] values = new int[size][size];
		
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
	
	public static int[] readFileList() throws IOException{
		@SuppressWarnings("unchecked")
		List<String> lines = FileUtils.readLines(new File(
				fileName));
		int[] result = new int[lines.size()];
		int i = 0;
		for (String in : lines) {
			result[i] = Integer.valueOf(in.trim());
			if (result[i] == 0) System.out.println(i);
			i++;
		}
		return result;
	}

}
