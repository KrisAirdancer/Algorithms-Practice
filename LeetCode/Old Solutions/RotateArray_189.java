package problems_100_to_199;

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
		
		// Testing rotateArray
		rotateArray_A3(test, 3);
		System.out.println("Correct for shift = 3: [5, 6, 7, 1, 2, 3, 4], " + "Actual: " + Arrays.toString(test));
		
		int[] testTwo = {-1,-100,3,99};
		
		rotateArray_A3(testTwo, 2);
		System.out.println("Correct for shift = 2: [3, 99, -1, -100], " + "Actual: " + Arrays.toString(testTwo));
		
		int[] testThree = {1, 2};
		
		rotateArray_A3(testThree, 1);
		System.out.println("Correct for shift = 1: [2, 1], " + "Actual: " + Arrays.toString(testThree));
		
		int[] testFour = {1, 2, 3};
		
		rotateArray_A3(testFour, 2);
		System.out.println("Correct for shift = 2: [2, 3, 1], " + "Actual: " + Arrays.toString(testFour));

	}
	
	/**
	 * Attempt 3 - July 29, 2021
	 * 
	 * SOLUTION IDEA:
	 * - Copy the input array to a new array
	 * - Two loops that copy values from the copy to the original
	 * 	- Loop 1:
	 * 		- While loop with two indexes, read and write
	 * 		- read starts at index 0 of the copy array
	 * 		- write starts at index shift of the original array
	 * 		- Loops until write is greater than the length of input (original) array - copies the value from read to write as it goes
	 * 	- Loop 2:
	 * 		- While loop with two indexes, read and write
	 * 		- read starts at index shift + 1 of copy array
	 * 		- write starts at index 0 of original array
	 * 		- Loops until read is greater than the length of the copy array
	 */
	public static void rotateArray_A3(int[] input, int shift) {
		
		// shift of 0
		if (shift == 0) {
			return;
		}
		
		// Array of length 1
		if (input.length == 1) {
			return;
		}
		
		// Array of length 2
		if (input.length == 2) {
			if (shift != 1 && shift % 2 == 0) { // Even shift
				return;
			} else { // Odd shift
				int temp = input[0];
				input[0] = input[1];
				input[1] = temp;
				return;
			}
		}
		
		int[] copy = new int[input.length];
		
		// Copy the original array to the copy array
		for (int index = 0; index < input.length; index++) {
			copy[index] = input[index];
		}
		
		// Create read and write variables
		int read = 0;
		int write = shift;
		
		// Shift the front half of values up by the shift amount
		while (write < input.length) {
			// Copy values from copy array to original array
			input[write] = copy[read];
			// Increment variables
			read++;
			write++;
		}
		
		// Setup variables for next loop
		if (input.length % 2 == 0 ) { // For even length arrays
			read = shift;
		} else { // For odd length arrays
			read = shift + 1;
		}
		write = 0;
		
		// Copy the back half of values from the back of the array to the front
		while (read < copy.length) {
			// Copy values from copy array to original array
			input[write] = copy[read];
			// Increment variables
			read++;
			write++;
		}
	}
	
	/**
	 * Model Solution 
	 */
	public static void rotateArray_ModelSolution(int[] input, int shift) {

		// NO MODEL SOLUTION YET
	}
	
	/**
	 * Attempt 2 - FAILED - This alg does not work
	 * 
	 * SOLUTION IDEA:
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Hashing it out
	 * 		- Store length - 1 in temp XXX
	 * 		- 1) Replace length - 1 with k XXX
	 * 		- Store k - 1 in temp2 XXX
	 * 		- 2) Replace k - 1 with temp XXX
	 * 		- Store length - 2 in temp
	 * 		- 3) Replace length - 2 with temp2
	 * 		- Store k - 2 in temp2
	 * 		- 4) Replace k - 2 with temp
	 * 		- Store length - 3 in temp
	 * 		- 5) Replace length - 3 with temp2
	 * 		- Store k - 3 in temp2
	 * 		- 6) Replace k - 3 with temp
	 * 		- Store k in temp
	 * 		- 7) Replace k with temp2
	 * 
	 */
	public static void rotateArray_2(int[] input, int shift) {
		
		int temp;
		int temp2;
		
		int index = 1; // Index for upper set (and lower set?)
		int index2 = 0;
		
		/*
		 *  Adjust shift up by one to allow for the use of just one index.
		 *  That is, length - index needs the index to start at 1 b/c
		 *  length starts at one greater than the last index value in the array
		 *  while shift needs to start at shift so it needs a starting index
		 *  value of 1. Or we just make shift larger by one to allow for the
		 *  use of a starting index of 1.
		 */
//		shift++;
		
		while (shift - index2 > 0) { // Loop until k is less than zero
			temp = input[input.length - index]; // Store length - i in temp
			input[input.length - index] = input[shift - index2];// Replace length - i with k
			index2++;
			temp2 = input[shift - index2];// Store k - 1 in temp2
			input[shift - index] = temp;// Replace k - 1 with temp
			
			index++;
			index2++;
//			System.out.println("temp: " + temp + ", temp2: " + temp2);
//			System.out.println("index: " + index + ", index2: " + index2);
		}
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

}
