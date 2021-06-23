package sortAlgorithms;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] test = {11, 28, 10, 19, 5, 21, 16, 14};
		
		mergeSort_A3(test);
		System.out.println("Input: [11, 28, 10, 19, 5, 21, 16, 14], Output: " + Arrays.toString(test));

	}

	/***********
	 * Attempt 3
	 **********/
	
	/**
	 * Driver method for mergeSort_A3.
	 */
	public static void mergeSort_A3(int[] input) {
		// Pass in the input array, a starting index of zero, and an end index of length - 1
		mergeSort_A3(input, 0, input.length - 1);
	}
	
	/**
	 * Attempt 3 - my own attempt
	 * 
	 * SOLUTION IDEA:
	 * - Recursively call the 
	 * 
	 * FULL SOLUTION DESCRIPTION/PSEUDO CODE:
	 * - Base case: if length < 2, return
	 * 
	 * - set midpoint as (start + end) / 2 - NOTE: may need to subtract one from end, shouldn't have to b/c already done by helper, but check it if issues arise
	 * 
	 * - Recursive calls
	 * - Call for left half: mergeSort(input, start (should be the same start point), middle (new end should be the midpoint))
	 * - Call for right half: mergeSort(input, midpoint (new start should be the midpoint), end (the old end should still be our endpoint))
	 * 
	 * - Merge functionality
	 * - Check to see if the rightmost element in the left partition is greater or less than the leftmost element
	 * in the right partition. Because both partitions are already sorted, if the leftmost element of the right partition
	 * is larger than the rightmost element of the left partition, then we can simply return, the sorting is done. However,
	 * if the opposite is true, we must sort the two partitions together. (This can be done by checking that
	 * mid < mid + 1, if true, return, if false, merge the two partitions.
	 * 		- Sort the partitions using Insertion Sort. See my implementation of insertion sort.
	 * 		- Split the input array into two partitions: sorted and unsorted. (Start firstUnsorted at index = 0)
	 * 		- loop over the sorted partition while index < 0 or until firstUnsortedm > index - 1
	 * 			- NOTE: need to stop index at 0 or get indexOutOfBounds exception, due to index - 1 check we will hit the index 0 item
	 * 			- While looping, if index (the first iteration will be the item at firstUnsorted) is > index - 1,
	 * 			swap the two elements.
	 * 		- Increment firstUnsorted - loop until firstUnsorted < input.length
	 * 
	 */
	public static void mergeSort_A3(int[] input, int leftIndex, int rightIndex) {
		// BASE CASE: Return if array is of length 1
		if ((rightIndex - leftIndex) < 2) {
			return;
		}
		
		// Calculate middle
		int mid = (leftIndex + rightIndex) / 2;
		
		// RECURSIVE CASES: Split the array into halves
		// Call mergeSort for left partition
		mergeSort_A3(input, leftIndex, mid);
		// Call mergeSort for right partition;
		mergeSort_A3(input, mid + 1, rightIndex); // mid + 1 b/c mid is included in the left partition, so the startIndex for the right partition is mid + 1.
		
		// MERGE THE PARTITIONS
		// Check to see if partitions are already sorted relative to each other
		if (input[mid] < input[mid + 1]) {
			return;
		}
		
		// Use Insertion Sort to merge the two partitions
		int firstUnsorted = leftIndex;
		
		while (firstUnsorted <= rightIndex) { // <= b/c we want to include the rightIndex in our merge;
			
			int index = firstUnsorted;
			
			while (index > 0 && input[index] < input[index - 1]) {
				// Swap the two out of order elements
				int temp = input[index];
				input[index] = input[index - 1];
				input[index - 1] = temp;
				
				index--;
			}
			
			firstUnsorted++;
		}
		
		
		
	}
	
	
	
	/***********
	 * Attempt 2 
	 **********/
	
	/**
	 * Attempt 2 - CTCI Implementation
	 * 
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
