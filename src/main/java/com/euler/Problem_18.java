package com.euler;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
 
public class Problem_18 {
    private static int heightOfTree = 100;
    private static final String fileName = "d:/temp/pyr2.txt";
    private int[][] tree;
 
    public int maxValue() throws IOException {
    	tree = readFile();
 
        for (int i = Problem_18.heightOfTree - 2; i >= 0; i--)
            for (int j = 0; j <= i; j++)
                tree[i][j] += tree[i + 1][j] > tree[i + 1][j + 1] ? tree[i + 1][j] : tree[i + 1][j + 1];
 
        return tree[0][0];
    }
 
    public static void main(String[] args) throws IOException {
        System.out.println(new Problem_18().maxValue());
    }
    
	public static int[][] readFile() throws IOException{
		@SuppressWarnings("unchecked")
		List<String> lines = FileUtils.readLines(new File(
				fileName));	
		
		int[][] values = new int[100][100];
		
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
