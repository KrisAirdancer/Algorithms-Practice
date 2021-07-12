package sortAlgorithms;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		
		int[] test = {23, 2, 36, 9, 68, 2, 99, 5, 16, 9, 0, 35, 0, 64, 6, 92, 4, 12, 2, 69, 6, 97, 9, 35};

		insertionSort_A2(test);
		System.out.println(Arrays.toString(test));
		
	}
	
	/**
	 * Attempt 2 - July 12, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - Indexed for loop to loop over the whole length of the array - index here is firstUnsorted
	 * 	- Initialize searchIndex to firstUnsorted
	 * 	- while input[searchIndex] < input[searchIndex - 1] && (searchIndex - 1) >= 0
	 * 		- Swap input[searchIndex] with input[searchIndex - 1]
	 * 		- searchIndex--;
	 * 
	 * TIME/MEMORY COMPLEXITY:
	 * - TC: Best: O(n) - Linear, Average: O(n^2) - Quadratic, Worst: O(n^2) - Quadratic
	 * - MC: O(1) - Constant
	 * 
	 */
	public static void insertionSort_A2(int[] input) {
		
		for (int firstUnsorted = 0; firstUnsorted < input.length; firstUnsorted++) {
			
			int searchIndex = firstUnsorted;
			
			while ((searchIndex - 1) >= 0 && input[searchIndex] < input[searchIndex - 1]) {
				
				int temp = input[searchIndex];
				input[searchIndex] = input[searchIndex - 1];
				input[searchIndex - 1] =  temp;
						
				searchIndex--;
			}
		}
	}
	
	
	/**
	 * SOLUTION IDEA:
	 * - Split the array into sorted and unsorted partitions. Then iterate over the array
	 * by comparing the firstUnsorted element with the one just before it. If the one
	 * before it is larger, swap them. After a swap, compare the originally found value
	 * (the one that was at firstUnsorted) with the value that is now to its left.
	 * Swap if it is smaller. Continue doing so until either the current element is
	 * larger than the value to its left or until the front of the array is reached.
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - This seems like a good candidate for recursion. I will do it iteratively for now.
	 * 
	 * - Initialize firstUnsorted = 0
	 * - while firstUnsorted is less than input.length
	 * 		- Indexed for loop to iterate over the unsorted partition - initialize index to firstUnsorted
	 * 				- if input[index] < input[index - 1]
	 * 					- int i = index;
	 * 					- while (i > 0 || input[i] < input[i - 1]
	 * 						- Swap elements
	 * 						- Decrement i
	 * OR
	 * 					- for (int i = index; i >= 0; i--)
	 * 						- 
	 * 		- firstUnsorted++
	 * 
	 */
	public static void insertionSort_A1(int[] input) {
		// Initialize partition index pointer
		int firstUnsorted = 0;
		// Loop over the unsorted partition until the sorted partition is the same size as the whole array
		while (firstUnsorted < input.length) {
			// Initialize a pointer to move through the sorted partition
			int i = firstUnsorted;
			// Loop over the sorted partition to place the next value in the correct spot
			while (i > 0 && input[i] < input[i - 1]) {
				// Swap the current element with the element before it
				int temp = input[i];
				input[i] = input[i - 1];
				input[i - 1] = temp;
				// Decrement index i
				i--;
			}
			// Increment firstUnsorted index
			firstUnsorted++;
		}
	}
}
