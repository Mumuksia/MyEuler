package algo;

import java.io.IOException;

import org.testng.annotations.Test;

import com.euler.utils.FileUtilsEuler;
import com.euler.utils.sorting.QuickSort;

public class QuickSortNumber {
	
	private int[] numbers;
	
	@Test
	public void doTest() throws IOException{
		FileUtilsEuler.fileName="d:/temp/algo2.txt";
		numbers = FileUtilsEuler.readFileList();
//		numbers = new int[]{2,3,4,5,6,8,1,7};
		QuickSort.result = numbers;
		QuickSort.splitPivotFirst(0, numbers.length-1);
		
		for (int i=0;i<15;i++){
			System.out.println(QuickSort.result[i]);
		}
		System.out.println("count " + QuickSort.count);
	}

}
