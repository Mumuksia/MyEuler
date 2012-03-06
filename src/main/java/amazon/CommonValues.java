package amazon;

/**
 * Class to count the sum of most common elements in array general algorithm is
 * to sort array and then just find the max sequence For sorting the quicksort
 * algorithm will be used
 * 
 * Approximate complexity is (O(N*logN) + O(N))
 * Approximate space usage - array.length (O(N))
 * @author yuriy zavada
 * 
 */
public class CommonValues {

	
	/**
	 * Method takes array input, sorts it, and search for biggest sequence of the same number
	 * 
	 * @param result - input array
	 * @return - sum of most common number in an array
	 */
	public long getSumOfMostCommonValues(int[] result) {

		if (result == null || result.length == 0)
			return 0;

		quickSort(0, result.length - 1, result);

		int maxCount = 1;
		int count = 0;
		int base = result[0];
		int number = base;
		for (int i : result) {
			if (base == i)
				count++;
			else {
				if (count > maxCount) {
					maxCount = count;
					number = base;
					base = i;
				}
				count = 1;
			}
		}
		return maxCount * number;
	}

	/**
	 * method to perform quicksort algorithm on the array
	 * 
	 * @param low
	 *            - low edge of (sub)sequence
	 * @param high
	 *            - high edge of (sub)sequence
	 * @param result
	 *            - the result will be placed in the same array space
	 *            optimization
	 */
	public void quickSort(int low, int high, int[] result) {

		int i = low, j = high;
		int pivot = result[i + (j - i) / 2];
		do {
			while (result[i] < pivot)
				i++;
			while (result[j] > pivot)
				j--;

			if (i <= j) {
				exchange(i, j, result);
				i++;
				j--;
			}

		} while (i <= j);
		if (low < j)
			quickSort(low, j, result);
		if (i < high)
			quickSort(i, high, result);
	}

	/**
	 * method to exchange to values in an array
	 * 
	 * @param i
	 *            - first value to exchange
	 * @param j
	 *            - second value to exchange
	 * @param result
	 *            - the result will be placed in the same array space
	 *            optimization
	 */
	private void exchange(int i, int j, int[] result) {
		if (i == j)
			return;
		result[i] = result[i] + result[j];
		result[j] = result[i] - result[j];
		result[i] = result[i] - result[j];
	}

}
