package problems_1600_to_1699;

import java.util.Arrays;

public class Mean_Of_Array_After_Removing_Some_Elements_1619 {

	public static void main(String[] args) {
		
		int[] test = {6,0,7,0,7,5,7,8,3,4,0,7,8,1,6,8,1,1,2,4,8,1,9,5,4,3,8,5,10,8,6,6,1,0,6,10,8,2,3,4};
		int[] test2 = {6, 2, 7, 5, 1, 2, 0, 3, 10, 2, 5, 0, 5, 5, 0, 8, 7, 6, 8, 0};
		
		System.out.println(trimmedMean_A1(test));
		System.out.println(Arrays.toString(test));

	}
	
	
	/**
	 * Attempt 1
	 * 
	 * SOLUTION IDEA:
	 * - Sort the array using insertion sort.
	 * - Calculate the starting point for the sum (to be used for the mean) by calculating 5%
	 * of the total number of elements in the array (input.length)
	 * - Do the same for the end point of the sum
	 * - Sum all of the elements in the restricted range
	 * - Divide by the total number of elements minus the number of excluded elements
	 * (essentially just the number of elements in the restricted range)
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * 
	 * 
	 */
	public static double trimmedMean_A1(int[] input) {
		// Sort the input array using insertion sort
		int firstUnsorted = 1;
		
		while (firstUnsorted < input.length) {
			int index = firstUnsorted;
			while (index > 0 && input[index] < input[index - 1]) {
				// Swap
				int temp = input[index];
				input[index] = input[index - 1];
				input[index - 1] = temp;
				
				index--;
			}
			firstUnsorted++;
		}
		
		int start = (int)(input.length * 0.05);
		int end = input.length - start; // end set to the index just after the last element included in the restricted range
		int restrictedLength = input.length - (start * 2);	
	
		double sum = 0;
		
		for (int index = start; index < end; index++) {
			sum = sum + input[index];
		}
		return sum / restrictedLength;
	}
	
}
