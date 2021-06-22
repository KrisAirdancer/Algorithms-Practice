package sortAlgorithms;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] test = {25, 57, 99, 27, 53, 45, 63, 92};
		
		quickSort_CTCI(test);
		System.out.println(Arrays.toString(test));

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
