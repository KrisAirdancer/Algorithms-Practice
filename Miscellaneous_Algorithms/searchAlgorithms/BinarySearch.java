package searchAlgorithms;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] test = {1, 2, 4, 6, 7, 8, 9, 12, 13, 15, 16, 20};
		
		System.out.println("A1: " + binarySearch_Recursive_A1(test, 20, 0, test.length - 1));
		System.out.println("A2: " + binarySearch_Recursive_A2(test, 20, 0, test.length - 1));
		System.out.println("A3: " + binarySearch_Recursive_A3(test, 20, 0, test.length - 1));
		
		System.out.println("Model Solution: " + binarySearch_Recursive_ModelSolution(test, 20, 0, test.length - 1));

		
		// Good discussion of how to find the midpoint properly and why: https://ai.googleblog.com/2006/06/extra-extra-read-all-about-it-nearly.html
	}

	
	/**
	 * Attempt 3 - July 6, 2021
	 * 
	 * SOULTION OUTLINE:
	 * - If length of input is 1 (< 2), return
	 * - Calculate midpoint
	 * - Compare midpoint to target
	 * 	- If midpiont < target, search right partition - Recursive call
	 * 	- If midpoint > target, search left partition - Recursive call
	 * 	- If midpoint == target, return midpoint
	 * 
	 */
	public static int binarySearch_Recursive_A3(int[] input, int target, int low, int high) {
		
		if (low > high) { // This case should be triggered if the target element is not in the list.
			return -1;
		}
		
		int mid = low + ((high - low) / 2);
		
		if (input[mid] < target) {
			return binarySearch_Recursive_A3(input, target, mid + 1, high);
		} else if (input[mid] > target) {
			return binarySearch_Recursive_A3(input, target, low, mid - 1);
		} else {
			return mid;
		}
	}
	
	/**
	 * Attempt 2 - July 2, 2021
	 * 
	 * - Test for invalid inputs
	 * - Calculate and set the midpoint
	 * - Test location of target relative to midpoint
	 * 	- If target > mid, search right partition
	 * 	- If target < mid, search left partition
	 * - Return index of value when mid == target
	 */
	public static int binarySearch_Recursive_A2(int[] input, int target, int low, int high) {
		
		if (low > high) {
			return -1;
		}
		
		int mid = low + ((high - low) / 2);
		
		if (input[mid] < target) { // Search right partition
			return binarySearch_Recursive_A2(input, target, mid + 1, high);
		} else if (input[mid] > target) { // Search left partition
			return binarySearch_Recursive_A2(input, target, low, mid - 1);
		} else { // If the above conditions aren't satisfied, mid must be equal to target
			return mid;
		}
	}
	
	/**
	 * Attempt 1 - Recursive Implementation - July 1, 2021
	 * 
	 * STEPS:
	 * - Check for invalid inputs
	 * - Calculate the midpoint
	 * - Two recursive calls (if cases)
	 * - Else case is to return the midpiont (the found value)
	 */
	public static int binarySearch_Recursive_A1(int[] input, int target, int low, int high) {
		
		if (low > high) {
			return -1;
		}
		
		int mid = low + ((high - low) / 2);
		
		if (input[mid] > target) { // If target in left partition
			return binarySearch_Recursive_A1(input, target, low, mid - 1);
			
		} else if (input[mid] < target) { // If target in right partition
			return binarySearch_Recursive_A1(input, target, mid + 1, high);
			
		} else { // If target == midpoint - we've found our target
			return mid;
		}
		
	}
	
	/**
	 * Model Solution - From CTCI p149
	 * 
	 * Would benefit from a Driver Method to improve ease of use.
	 */
	public static int binarySearch_Recursive_ModelSolution(int[] input, int target, int low, int high) {
		// Check for invalid input values
		if (low > high) {
			return -1; // If this is triggered, we have an error
		}
		
		// Calculate the midpoint - this method reduces the risk of overflow errors
		int mid = low + ((high - low) / 2);
		
		if (input[mid] < target) { // If the midpoint is less than our target value, search the upper (right) partition
			return binarySearch_Recursive_ModelSolution(input, target, mid + 1, high);
			
		} else if (input[mid] > target) {// If the midpoint is greater than our target, search the lower (left) partition
			return binarySearch_Recursive_ModelSolution(input, target, low, mid - 1);
		
		/* If the midpoint is neither greater than or less than our target, it must equal
		 * our target. We've found our target, return the index of the target value (aka. mid). */
		} else {
			return mid;
		}
		
	}
	
	/**
	 * Model Solution - From CTCI p149
	 * 
	 * Binary search assumes a sorted array.
	 */
	public static int binarySearch_Iterative_ModelSolution(int[] input, int target) {
		
		int low = 0;
		int high = input.length - 1;
		int mid;
		
		while (low <= high) {
			mid = low + (high - low) / 2;
			
			if (input[mid] < target) {
				low = mid + 1;
			} else if (input[mid] > target) {
				high = mid - 1;
			} else {
				return mid;
			}
		}
		return -1; // If we reach this return, we have an error
		
	}
	
}
