package sortAlgorithms;

import java.util.Arrays;

public class selectionSort {

	public static void main(String[] args) {


		int[] test = {23, 2, 36, 9, 68, 0, 2, 99, 5, 16, 9, 35, 0, 64, 6, 92, 4, 12, 2, 69, 6, 97, 9, 35};

		selectionSort_Attempt_1(test);
		
		System.out.println(Arrays.toString(test));
	}

	/**
	 * SOLUTION IDEA:
	 * - Split the array into two partitions, sorted and unsorted. Loop over the unsorted partition,
	 * each time finding the smallest element. Then swap the smallest element with the first element
	 * in the unsorted partition. Then increment the firstUnsorteed index up by one, effectively
	 * adding that next smallest element to the end of the sorted partition. 
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Initialize firstUnsorted to 0
	 * - while firstUnsorted < input.length -1 
	 * 		- Initialize smallest variable to firstUnsorted
	 * 		- for loop from firstUnsorted to input.length - 1
	 * 				- if input[index] < input[smallest]
	 * 					- Store index in smallest
	 * 		- swap firstUnsorted and smallest
	 * 		- Increment firstUnsorted 
	 * 
	 */
	public static void selectionSort_Attempt_1(int[] input) {
		// Initialize partition index
		int firstUnsorted = 0;
		// Loop over the array until the sorted partition is the same length as the whole array
		while (firstUnsorted < input.length - 1) {
			// Initialize variable to track the index of the smallest element found so far
			int smallest = firstUnsorted;
			// Loop over the unsorted partition to find the smallest unsorted value
			for (int index = firstUnsorted; index < input.length; index++) {
				// If a found value is smaller than the current smallest value, update smallest
				if (input[index] < input[smallest]) {
					smallest = index;
				}
			}
			// Swap the first unsorted element with the smallest unsorted element
			int temp = input[firstUnsorted];
			input[firstUnsorted] = input[smallest];
			input[smallest] = temp;
			// Increment the sorted partition size up by one
			firstUnsorted++;
		}
	}
}
