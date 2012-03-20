package com.euler.utils.sorting;

import java.util.Random;

import org.testng.annotations.Test;

public class QuickSort {
	
	public static int[] result;
	
	public static int count = 0;
	
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
	
	public static void splitQuick(int low, int high){
		
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
	
	public static void splitPivotFirst(int low, int high){
		int i = low+1;
		for (int j=low+1; j<=high; j++){
			if (result[j] < result[low]){
				exchange(j, i);
				i++;				
			}
		}
		count +=high-low-1;
		exchange(low, i-1);
		
		if (low < i-2)
			splitPivotFirst(low, i-2);
		if (i < high)
			splitPivotFirst(i, high);
	}
	
	public static void splitPivotLast(int low, int high){
		int i = low;
		for (int j=low+1; j<=high-1; j++){
			if (result[j] < result[high]){
				exchange(j, i);
				i++;				
			}
		}
		count +=high-low-1;
		exchange(high, i);
		
		if (low < i-2)
			splitPivotFirst(low, i-2);
		if (i < high)
			splitPivotFirst(i, high);
	}
	
	private static void exchange(int i, int j) {
		int temp = result[i];
		result[i] = result[j];
		result[j] = temp;
	}

}
