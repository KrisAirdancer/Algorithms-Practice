package problems_101_to_200;

import java.util.Arrays;

/**
 * PROBLEM EXPLANATION:
 * URL: https://leetcode.com/problems/rotate-array/
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * Example 1:
 * Input: nums = [1,2,3,4,5,6,7], k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * 
 * Example 2:
 * Input: nums = [-1,-100,3,99], k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * 
 */

public class RotateArray_189 {

	public static void main(String[] args) {
		
		int[] test = {1, 2, 3, 4, 5, 6, 7};
		
		// Testing rotateArray_1
		rotateArray_1(test, 3);
		System.out.println("Correct for shift = 3: {5, 6, 7, 1, 2, 3, 4}, " + "Actual: " + Arrays.toString(test));
		

	}
	
	/**
	 * Attempt 2.
	 * 
	 * @param input
	 * @param shift
	 */
	public static void rotateArray_2(int[] input, int shift) {
		
	}
	
	/**
	 * Attempt 1
	 * 
	 * SOLUTION IDEA:
	 * - Store the last value of the array in a temporary variable, then loop over the array, starting
	 * with the last value, to set the current index value to the index value (index) before it (index - 1).
	 * Do this for as many times as the shift value indicates.
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Start while loop that runs until shift <= 0
	 * 		- Initialize temp variable as last element in the array.
	 * 		- Start inner indexed for loop that loops over entire array
	 * 			- Set current index value equal to index value minus 1 (index - 1)
	 *		- Set index = 0 to temp
	 *		- Decrement shift variable
	 * 
	 */
	public static void rotateArray_1(int[] input, int shift) {
		
		while (shift > 0) {
			// Set temp to last element in the input array
			int temp = input[input.length - 1];
			
			// Loop over the array starting with the last element and ending with the second element from the front (index = 1)
			for (int index = input.length - 1; index > 0; index--) {
				input[index] = input[index - 1];
				
			}
			// Set the first element in the index equal to the former last element in the index (temp)
			input[0] = temp;
			
			shift--;
		}
		
	}

	/**
	 * Model Solution.
	 * 
	 * @param input
	 * @param shift
	 */
	public static void rotateArray_ModelSolution(int[] input, int shift) {

		// NO MODEL SOLUTION SELECTED YET
	}
}
