package sortAlgorithms;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] test = {11, 28, 10, 19, 5, 21, 16, 14};
		
		mergeSort_A4(test);
		System.out.println("Input: [11, 28, 10, 19, 5, 21, 16, 14], Output: " + Arrays.toString(test));

	}
	
	/**
	 * Driver method for Attempt 4
	 */
	public static void mergeSort_A4(int[] input) {
		int[] duplicate = new int[input.length];
		 
		mergeSort_A4(input, duplicate, 0, input.length - 1);
	}
	
	/**
	 * Attempt 4 - August 4, 2021
	 */
	public static void mergeSort_A4(int[] input, int[] duplicate, int low, int high) {
		
		// Check for valid bounds - BASE CASE???
		if (low >= high) {
			return;
		}
		
		// Calculate mid point
		int mid = low + ((high - low) / 2);
		
		// Sort the left partition
		mergeSort_A4(input, duplicate, low, mid);
		// Sort the right partition
		mergeSort_A4(input, duplicate, mid + 1, high);
		
		// SORT CURRENT PARTITION
		
		// Copy elements from input to duplicate array - duplicate array must stay updated during the sort
		for (int index = 0; index < input.length; index++) {
			duplicate[index] = input[index];
		}
		
		// Create pointers
		int left = low;
		int right = mid + 1;
		int current = low;
		
		// Iterate through the duplicate array and copy values from the duplicate to the original as necessary
		while (left <= mid && right <= high) {
			// Compare left and right partition values and sort
			if (duplicate[left] <= duplicate[right]) { // Left element is less than or equal to right element
				input[current] = duplicate[left];
				left++;
			} else { // Right element is less than left element
				input[current] = duplicate[right];
				right++;
			}
			current++;
		}
		
		// Copy over the remaining elements from duplicate to original array
		int remainder = mid - left;
		for (int index = 0; index <= remainder; index++) {
			input[current + index] = duplicate[left + index];
		}
	}
	
	/**
	 * MODEL SOLUTION - Driver method for mergeSort_MS
	 * 
	 * Note: Model solution from p147 CTCI
	 * 
	 * SOLUTION OUTLINE:
	 * - Decompose the input array into halves until each half is of length 1.
	 * - Merge the length-1 arrays back together, while doing so, place each element in the
	 * correct sorted order.
	 */
	public static void mergeSort_MS(int[] input) { // Driver method for mergeSort_MS - produces correct initial inputs
		int[] duplicate = new int[input.length];
		mergeSort_MS(input, duplicate, 0, input.length - 1);
	}
	
	/**
	 * MODEL SOLUTION - Sorting method for mergeSort_MS - splits the array into halves and calls the sort method
	 */
	public static void mergeSort_MS(int[] input, int[] duplicate, int low, int high) {
		
		if (low < high) { // Check that the high and low bounds are valid
			
			int middle = low + (high - low) / 2; // Calculate midpoint
			
			mergeSort_MS(input, duplicate, low, middle); // Sort left partition
			mergeSort_MS(input, duplicate, middle + 1, high); // Sort right partition
			
			// Call the sort method to sort the current partitions
			merge_MS(input, duplicate, low, middle, high);
		}
	}
	
	/**
	 * MODEL SOLUTION - Sort method for mergeSort_MS - sorts and combines two partitions
	 */
	public static void merge_MS(int[] input, int[] duplicate, int low, int middle, int high) {
		
		// Copy original array to helper array
		for (int index = low; index <= high; index++) {
			duplicate[index] = input[index];
		}
		
		int leftIndex = low;
		int rightIndex = middle + 1;
		int current = low;
		
		/* Iterate through the duplicate array. Compare the left and right half, copying
		 * back the smaller element from the two halves into the original array. */
		while (leftIndex <= middle && rightIndex <= high) {
			
			if (duplicate[leftIndex] <= duplicate[rightIndex]) { // If right element is greater than or equal to left element
				input[current] = duplicate[leftIndex];
				leftIndex++;
				
			} else { // If right element is smaller than left element
				input[current] = duplicate[rightIndex];
				rightIndex++;
				
			}
			current++;
		}
		
		// Copy the rest of the left side of the array into the target array.
		int remaining = middle - leftIndex;
		for (int index = 0; index <= remaining; index++) {
			input[current + index] = duplicate[leftIndex + index];
		}
	}
	
	/*******************
	 * PERSONAL ATTEMPTS
	 *******************/
	
	
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
