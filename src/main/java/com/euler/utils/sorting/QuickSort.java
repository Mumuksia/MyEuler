package com.euler.utils.sorting;

import java.util.Random;

import org.testng.annotations.Test;

public class QuickSort {
	
	public static int[] result;
	
	@Test
	public void doSort(){
		init();
		splitQuick(0, result.length-1);
		for (int i : result) {
			System.out.print(i + " ");
		}
	}
	
	public void init(){
		result = new int[50];
		Random generator = new Random();
		for (int i = 0; i < result.length; i++) {
			result[i] = generator.nextInt(5);
		}		
	}
	
	public void splitQuick(int low, int high){
		
		int i = low, j = high;
		int pivot = result[i+(j-i)/2];
		do{
			while (result[i] < pivot) i++;
			while (result[j] > pivot) j--;
			
			
			if (i <= j) {
				exchange(i, j);
				i++;
				j--;
			}
			
		} while (i<=j);
		if (low < j)
			splitQuick(low, j);
		if (i < high)
			splitQuick(i, high);		
	}
	
	private void exchange(int i, int j) {
		int temp = result[i];
		result[i] = result[j];
		result[j] = temp;
	}

}
