package sortAlgorithms;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] test = {30, 23, 51, 23, 67, 46, 32};
		
		mergeSort_A1(test);
		System.out.println(Arrays.toString(test));

	}
	
	/**
	 * Attempt 2 - CTCI Implementation
	 * 
	 * See here - https://www.youtube.com/watch?v=KF2j-9iSf4Q&ab_channel=HackerRank
	 * See p147 CTCI
	 */
	public static void mergeSort_A2(int[] input, int start, int end) {
		
		
	}

	/**
	 * Attempt 1
	 * 
	 * SOLUTION IDEA:
	 * - Recursively reduce the array (in-place) down to a series of size 1 arrays (base case).
	 * Then, on the way back out of the recursion, place the elements in the size one arrays
	 * by inserting them into the growing larger array...?
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * 
	 * 
	 */	
	public static void mergeSort_A1(int[] input, int start, int end) {
		
		// BASE CASE: If the array is of size 1, end recursion
		if (end - start < 2) {
			return;
		}
		
		// Setting out midpoint
		int mid = (start + end) / 2;
		
		// RECURSIVE CASE: For left partition
		mergeSort_A1(input, start, mid);
		// RECURSIVE CASE: For right partition
		mergeSort_A1(input, mid, end);
		
		// VISTA SAYS THE BELOW PART SHOULD ESSENTIALLY BE INSERTION SORT
		/* If the last element in the left array is smaller than the first
		 * element in the right array, the two arrays and all of their elements
		 * are already in the correct sorted order relative to each other.
		 */
		if (input[mid - 1] <= input[mid]) {
			return;
		}
		
		int startIndex = start;
		int midIndex = mid;
		int tempIndex = 0; // Keeps track of where we are in the temporary array
		
		/* The temporary array will be used for sorting the two partitions.
		 * We will loop over each of the partitions and sort the values into
		 * the temporary array, then, after we've finished sorting the partitions
		 * into the array, we will copy the contents of the temp array over
		 * to the correct location in the original array. */
		int[] temp = new int[end - start]; // Needs to be large enough to hold all of the elemnts in the left and right arrays
		
		while (startIndex < mid && midIndex < end) {
			/* Not really sure how this is working. */
			temp[tempIndex++] = input[startIndex] <= input[midIndex] ? input[startIndex++] : input[midIndex++];
		}
		
		// WRITE MY OWN COPY ARRAY METHOD
		
		System.arraycopy(input, startIndex, input, start + tempIndex, mid - startIndex);
        System.arraycopy(temp, 0, input, start, tempIndex);
	}
	
	/**
	 * Driver for A1
	 */
	public static void mergeSort_A1(int[] input) {
		mergeSort_A1(input, 0, input.length);
	}
}
