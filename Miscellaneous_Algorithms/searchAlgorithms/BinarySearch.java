package searchAlgorithms;

public class BinarySearch {

	public static void main(String[] args) {
		
		int[] test = {1, 2, 4, 6, 7, 8, 9, 12, 13, 15, 16, 20};
		
		System.out.println(binarySearch_Recursive_A1(test, 20, 0, test.length - 1));
		
		System.out.println(binarySearch_Iterative_ModelSolution(test, 8));
		System.out.println(binarySearch_Recursive_ModelSolution(test, 20, 0, test.length - 1));

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
