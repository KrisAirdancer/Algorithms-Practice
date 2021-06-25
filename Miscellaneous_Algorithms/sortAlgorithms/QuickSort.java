package sortAlgorithms;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] test = {25, 57, 99, 27, 53, 45, 63, 92};
		
		quickSort_A2(test);
		System.out.println("Input: [25, 57, 99, 27, 53, 45, 63, 92], Output: " + Arrays.toString(test));

	}
	
	/**
	 * Attempt 2 - My own implementation
	 * 
	 * SOLUTION IDEA:
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * method header quickSort(int[] input, int startIndex, int endIndex)
	 * Recursive Step
	 * - Base Case: If input.length < 2, return
	 * - Recursive Cases: if input.length >= 2,
	 * 	- call quickSort(input, 0, pivot - 1) for the left side of the list
	 * 	- call quickSort(input, pivot + 1, input.length) for the right side of the list 
	 * Sorting Step
	 * - Select the midpoint as the pivot point
	 * - Swap the last item in the list with the pivot point
	 * - Initialize two counters: firstLarger and searchIndex - initialize both to the first item in the list
	 * - while loop that runs until searchIndex reaches the second to last item in the list -> searchIndex < input.length - 1 
	 * 	- if searchIndex < pivot, swap searchIndex with firstLarger then increment first larger
	 * 	- searchIndex++
	 * 	- NOTE: if searchInex > pivot, do nothing.
	 * - Once while loop completes,
	 * 	- Swap pivot element with firstLarger element and sorting is complete
	 * 
	 * 
	 */
	public static void quickSort_A2(int[] input, int start, int end) {
		
		// BASE CASE: if input partition is of length one, return
		if (end - start < 2) {
			return;
		}
		
		// SORT THE ELEMENTS
		// Select a pivot point - in this case, the middle element is selected as the pivot
		int pivotIndex = start + (end - start) / 2;
		
		// Swap the pivot element with the last item in the list to get the pivot out of the way for sorting - we will be using firstLargest to mark where the pivot should go
		int temp = input[pivotIndex];
		input[pivotIndex] = input[input.length - 1];
		input[input.length - 1] = temp;
		// The pivot has been moved, so now we need to reset the pivotIndex to where the pivot element is - in this case, the end of the list
		pivotIndex = input.length - 1;
		
		int searchIndex = start;
		int firstLarger = start;
		
		while (searchIndex < end) {
			// If we find an element that is smaller than the pivot, we swap it with the firstLargest
			if (input[searchIndex] < input[pivotIndex]) {
				temp = input[searchIndex];
				input[searchIndex] = input[firstLarger];
				input[firstLarger] = temp;
				
				// Increment firstLarger to separate the smaller elements from the larger elements
				firstLarger++;
			}
			
			searchIndex++;
		}
		// Swap the pivot and firstLargest to put pivot back in place (pivot should still be the last element in the list)
		temp = input[pivotIndex];
		input[pivotIndex] = input[firstLarger];
		input[firstLarger] = temp;
		pivotIndex = firstLarger;
		
		
		// RECURSIVE CASE:
		// Call quickSort for the left half of the list
		quickSort_A2(input, start, pivotIndex - 1);
		// Call quickSort for the right half of the list
		quickSort_A2(input, pivotIndex + 1, end);
		
	}
	
	/**
	 * Driver for quickSort_A2
	 */
	public static void quickSort_A2(int[] input) {
		quickSort_A2(input, 0, input.length - 1);
	}
	
	
	/**
	 * Attempt 1 - CTCI Implementation
	 * 
	 * SOLUTION IDEA:
	 * - Select the middle element as the pivot point, then loop over each partition and
	 * move any elements in the left partition that are larger than the pivot to the right
	 * partition and any elements in the right partition that are smaller than the pivot
	 * to the left partition - do this by swapping?
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * 
	 * 
	 */
	public static void quickSort_CTCI(int[] input, int left, int right) {
		
		int index = partition_CTCI(input, left, right);
		
		if (left < index - 1) { // Sort left half
			quickSort_CTCI(input, left, index - 1);
		}
		
		if (index < right) { // Sort right half
			quickSort_CTCI(input, index, right);
		}
	}
	
	public static int partition_CTCI(int[] input, int left, int right) {
		
		int pivot = input[left + (right - left) / 2]; // Selecting a pivot point
		
		while (left <= right) {
			// Find element on left that should be on right
			while (input[left] < pivot) {
				left++;
			}
			
			// Find element on right that should be on left
			while (input[right] > pivot) {
				right--;
			}
			
			// Swap element, and move left and right indices
			if (left <= right) {
				swap_CTCI(input, left, right); // I had to write the swap method myself. It may be wrong.
				left++;
				right++;
			}
		}
		return left;
	}
	
	public static void swap_CTCI(int[] input, int left, int right) {
		int temp = input[left];
		input[left] = input[right];
		input[right] = input[left];
	}
	
	/**
	 * Driver method for CTCI implementation
	 */
	public static void quickSort_CTCI(int[] input) {
		quickSort_CTCI(input, 0, input.length - 1);
	}

}
