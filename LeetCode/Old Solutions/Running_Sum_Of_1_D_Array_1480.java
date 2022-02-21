package problems_1400_to_1499;

import java.util.Arrays;

public class Running_Sum_Of_1_D_Array_1480 {

	public static void main(String[] args) {
		
		int[] test = {1, 2, 3, 4, 5, 6, 7, 8};
		
		System.out.println(Arrays.toString(runningSum_A1(test))); // Should yield, [1, 3, 6, 10, 15, 21, 28, 36]

	}
	
	/**
	 * Attempt 2 - in place variant
	 * 
	 * Note: Unless the user wants this to be in place, this is a BAD solution.
	 * I just did it to see if I could.
	 */
	public static int[] runningSum_A1_InPlace(int[] input) {
		
		for (int index = 1; index < input.length; index++) { // Start at index = 1 b/c the first sum is just the first number in the array 
			input[index] = input[index] + input[index - 1];
		}
		return input;
		
	}
	
	/**
	 * Attempt 1
	 *
	 * SOLUTION IDEA:
	 * - Create a new array to hold the output values (this will be the array that is returned by the method),
	 * then loop over the input array with two pointers
	 * 
	 * - Every element in the output array is equal to the corresponding element in the input array plus the 
	 * the previous element in the output array. That is, output[index] = input[index] + output[index - 1]
	 * 
	 * 
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Indexed for loop starting at zero.
	 * 	- if index = 0, output[0] = input[0]
	 * 	- else,
	 * 		- output[index] = input[index] + output[index - 1]
	 * - return output
	 * 
	 */
	public static int[] runningSum_A1(int[] input) {
		
		int[] output = new int[input.length];
		
		for (int index = 0; index < input.length; index++) {
			if (index == 0) {
				output[index] = input[0];
			} else {
				output[index] = input[index] + output[index - 1];
			}
		}
		
		return output;
	}

}
