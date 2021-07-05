package sortAlgorithms;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] test = {25, 57, 99, 27, 53, 45, 63, 92, 34, 66, 80, 29, 30, 66, 24, 34};
		
//		quickSort_A2(test);
		quickSort_A4(test, 0, test.length - 1);
		System.out.println("Input: [25, 57, 99, 27, 53, 45, 63, 92, 34, 66, 80, 29, 30, 66, 24, 34],\nOutput: " + Arrays.toString(test));

	}
	
	/**
	 * Attempt 4 - July 5, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - Choose a pivot element, then move all values that are larger than that pivot
	 * to the right of the pivot and all that are smaller to the left.
	 * 
	 * - Base case: low > high, we return
	 * 
	 * - Calculate the pivot (mid) using mid = input.length / 2;
	 * - Sort partitions using while loop (while searchIndex < high - 1???)
	 * 	- Move pivot to end of the array by swapping it with the value at the last position in the array
	 * 	- Create two pointers: searchIndex and firstLarger - initialize both to low
	 * 	- Iterate over the array with searchIndex until a value less than the pivot is found
	 * 		- If value < pivot found, swap the searchIndex value with the firstLarger index value
	 * then increment firstLargest up by 1.
	 * 
	 * - Recursive cases: sort the left and right partitions
	 * 	- Call quickSort for left partition
	 * 	- Call quickSort for right partition
	 * 
	 * 
	 * 
	 */
	public static void quickSort_A4(int[] input, int low, int high) {
		// BASE CASE: Return if array is length 1
		if ((high - low) < 2) {
			return;
		}
		
		// Calculate midpoint (pivot)
		int mid = low + ((high - low) / 2);
		
		// Sort the partitions
		// Initialize pointers
		int searchIndex = low;
		int firstLarger = low;
		
		// Swap the midpoint for the last item in the partition
		int temp = input[high];
		input[high] = input[mid];
		input[mid] = temp;
		// Set the pivot index (mid) to the end of the array
		mid = high;
		
		// Loop over the array looking for values smaller than the pivot
		while (searchIndex < mid) {
			// If value smaller than pivot is found, swap it with firstLarger
			if (input[searchIndex] < input[mid]) {
				temp = input[searchIndex];
				input[searchIndex] = input[firstLarger];
				input[firstLarger] = temp;
				// Increment firstLarger to make room for the new value in the left partition
				firstLarger++;
			}
			searchIndex++;
		}
		
		// Swap the pivot element with the element at firstLarger
		temp = input[mid];
		input[mid] = input[firstLarger];
		input[firstLarger] = temp;
		// Move pivot index (mid) to firstLarger index
		mid = firstLarger;
		
		// RECURSIVE CASES: Sort the left and right partitions
		quickSort_A4(input, low, mid - 1); // Sort left partition
		quickSort_A4(input, mid + 1, high); // Sort right partition
	}
	
	
	
	/**
	 * Attempt 3 - July 2, 2021 - My own implementation
	 * 
	 * SOLUTION OUTLINE:
	 * 
	 */
	public static void quickSort_A3(int[] input, int low, int high) {
		// Base case - Partition of length 1
		if ((high - low) < 2) {
			return;
		}
		
		// Set pivot index
		int pivotIndex = low + ((high - low) / 2);
		
		// Sorting step
		int temp = input[high];
		input[high] = input[pivotIndex];
		input[pivotIndex] = temp;
		pivotIndex = high;
		
		int searchIndex = low;
		int firstUnsorted = low;
		
		while (searchIndex < high) { // Stop one index place before the last item in the list b/c the last index is just holding our pivot and doesn't need to be compared to itself
			if(input[searchIndex] < input[pivotIndex]) {
				temp = input[searchIndex];
				input[searchIndex] = input[firstUnsorted];
				input[firstUnsorted] = temp;
				firstUnsorted++;
			}
			
			searchIndex++;
		}
		
		// Swap the pivot back to its proper location (swap pivot with firstUnsorted)
		temp = input[pivotIndex];
		input[pivotIndex] = input[firstUnsorted];
		input[firstUnsorted] = temp;
		pivotIndex = firstUnsorted;
		
		// Recursive Cases
		quickSort_A3(input, low, pivotIndex - 1); // Call for left partition
		quickSort_A3(input, pivotIndex + 1, high); // Call for right partition
		
		
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
		if (end - start < 1) {
			return;
		}
		
		// SORT THE ELEMENTS
		// Select a pivot point - in this case, the middle element is selected as the pivot
		int pivotIndex = start + (end - start) / 2;
		
		// Swap the pivot element with the last item in the list to get the pivot out of the way for sorting - we will be using firstLargest to mark where the pivot should go
		int temp = input[pivotIndex];
		input[pivotIndex] = input[end];
		input[end] = temp;
		// The pivot has been moved, so now we need to reset the pivotIndex to where the pivot element is - in this case, the end of the list
		pivotIndex = end;
		
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
