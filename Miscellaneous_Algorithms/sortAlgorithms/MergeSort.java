package sortAlgorithms;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		
		int[] test = {30, 23, 51, 23, 67, 46, 32, 37, 48, 53, 64, 69, 77, 75, 42, 31, 68};
		
		mergeSort_A1(test);
		System.out.println(Arrays.toString(test));

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
		
//        if (end - start < 2) {
//            return;
//        }
//
//        int mid = (start + end) / 2;
//        mergeSort_A1(input, start, mid);
//        mergeSort_A1(input, mid, end);
//        
//        if (input[mid - 1] <= input[mid]) {
//            return;
//        }
//
//        int i = start;
//        int j = mid;
//        int tempIndex = 0;
//
//        int[] temp = new int[end - start];
//        while (i < mid && j < end) {
//            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
//        }
//        
//        System.arraycopy(input, i, input, start + tempIndex, mid - i);
//        System.arraycopy(temp, 0, input, start, tempIndex);
        
        
        
		
		
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
		// If the elements are already in the right order, return. No sorting needed.
		if (input[mid - 1] <= input[mid]) {
			return;
		}
		
		int startIndex = start;
		int midIndex = mid;
		int tempIndex = 0;
		
		int[] temp = new int[end - start];
		
		while (startIndex < mid && midIndex < end) {
			
			temp[tempIndex++] = input[startIndex] <= input[midIndex] ? input[startIndex++] : input[midIndex++];
		}
		
		// WRITE MY OWN COPY ARRAY METHOD
		
		System.arraycopy(input, startIndex, input, start + tempIndex, mid - startIndex);
        System.arraycopy(temp, 0, input, start, tempIndex);
	}
	
	public static void mergeSort_A1(int[] input) {
		mergeSort_A1(input, 0, input.length);
	}
}
