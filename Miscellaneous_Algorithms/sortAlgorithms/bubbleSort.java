package sortAlgorithms;

import java.util.Arrays;

public class bubbleSort {

	public static void main(String[] args) {
		
		int[] test = {23, 2, 36, 9, 68, 2, 99, 5, 16, 9, 35, 0, 64, 6, 92, 4, 12, 2, 69, 6, 97, 9, 35};

		bubbleSort_Attempt_1(test);
		System.out.println(Arrays.toString(test));
	}
	
	/**
	 * SOLUTION IDEA:
	 * - Loop over the array comparing the current element with the next
	 * element. When the next element is smaller than the current element,
	 * swap them. When the next element is greater than the current element,
	 * don't swap. Use a boolean flag to tell the algorithm if it performed
	 * a swap on the last pass or not. If it did, do another pass, if not,
	 * sorting is completed.
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Initialize sortAgain to true
	 * - while sortAgain == true
	 * 		- Set sortAgain to false
	 * 		- Indexed for loop - stop at index - 2 b/c loop checks index + 1 on each loop
	 * 				- if current is less than next, swap
	 * 					- Initialize temp variable
	 * 					- temp = current
	 * 					- current = next
	 * 					- next = temp
	 * 					- sortAgain = true
	 * 
	 */
	public static void bubbleSort_Attempt_1(int[] input) {
		// Create boolean flag to track if sorting is complete
		boolean sortAgain = true;
		// Loop until sorting is complete
		while (sortAgain) {
			// Set flag to terminate sorting unless a swap is performed
			sortAgain = false;
			// Loop over the entire array
			for (int index = 0; index <= input.length - 2; index++) {
				// If the left number is larger than the right number, swap
				if (input[index] > input[index + 1]) {
					int temp = input[index];
					input[index] = input[index + 1];
					input[index + 1] = temp;
					// Set flag to continue sorting
					sortAgain = true;
				}
			}
		}
	}

}
