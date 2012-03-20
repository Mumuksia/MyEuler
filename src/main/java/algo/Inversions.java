package algo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.euler.utils.FileUtilsEuler;

public class Inversions {
	
	private static int[] input;
	private int[] helper;
	private long INVERSIONS = 0;
	
	private static void init() throws IOException{
		FileUtilsEuler.fileName = "d:/temp/IntegerArray.txt";
		input = FileUtilsEuler.readFileList();
	}
	
	@Test
	public void doTest() throws IOException{
		init();
//		System.out.println(input[0]);
//		input = new int[]{1,2,3,4,5,6};
		helper = new int[input.length];
//		System.out.println(simpleCount());
		mergesort(0, input.length-1);		
		
		System.out.println(INVERSIONS);
		System.out.println(input[0]);
		
	}
	
	private long simpleCount(){
		long count = 0;
		for (int i=0;i<input.length; i++)
			for (int j=i+1;j<input.length; j++){
				if (input[i] > input[j]) count++;
			}
		return count;
	}
	
	private void mergesort(int low, int high) {
		// Check if low is smaller then high, if not then the array is sorted
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = (low + high) / 2;
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}
	}

	private void merge(int low, int middle, int high) {

		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = input[i];
		}

		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				input[k] = helper[i];
				i++;
			} else {
				input[k] = helper[j];				
				INVERSIONS = INVERSIONS + middle - i + 1;
				
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			input[k] = helper[i];
			k++;
			i++;
		}

	}

}
