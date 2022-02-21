package problems_000_to_99;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {
	
	public static void main(String[] args) {
		
		int[] test = {3, 2, 3};
		
		System.out.println(Arrays.toString(twoSum_A3(test, 6)));

	}
	
	/**
	 * Attempt 3 - July 12, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - Loop over the array. On each iteration, check if the target value minus the current value
	 * (target - current = value to check for) has already been stored in the HashMap.
	 * 	- If in hashmap, store the index of the current value and the index of the first value in the output
	 * array. The index of the first value is the value (key-value pair) in the hashmap.
	 * 		- Then return output.
	 * 	- If not in hashmap, add the current value to the hashmap as the key and add its index
	 * value as the value.
	 * 
	 * 
	 * TIEM/MEMORY COMPLEXITY:
	 * - TC: O(n) - Have to loop over the array just once - n-times, that is.
	 * - MC: O(n) - Worst case, may have to add every element in the array to the HashMap
	 */
	public static int[] twoSum_A3(int[] input, int target){
		
		int[] output = new int[2];
		
		HashMap<Integer, Integer> foundValues = new HashMap<Integer, Integer>();
		
		for (int index = 0; index < input.length; index++) {
			
			if (foundValues.containsKey((target - input[index]))) {
				output[0] = foundValues.get(target - input[index]);
				output[1] = index;
				return output;
			} else {
				foundValues.put(input[index], index);
			}
		}
		return output;
	}
	
	/**
	 * Attempt 2 - July 2, 2021
	 * 
	 * SOLUTION IDEA:
	 * - Loop over the entire array comparing each number to each other number until the sum 
	 * equals the target.
	 * 
	 */
	public static int[] twoSum_A2(int[] input, int target) {
		
		int[] result = new int[2];
		
		for (int current = 0; current < input.length; current++) {
			for (int search = current + 1; search < input.length; search++) {
				if (input[current] + input[search] == target) {
					result[0] = current;
					result[1] = search;
					return result;
				}
			}
		}
		return result;
	}
	
	
	/**
	 * Attempt 1 - June 29, 2021
	 * 
	 * SOLUTION IDEA:
	 * - Starting with the first element in the nums array, subtract each element in the
	 * nums array from the target value (save a copy of target to modify), then loop over
	 * the array starting with the first value and sum each value with each other value. 
	 * 
	 * 
	 * 
	 * then loop over
	 * the entire remainder of the array (and any elements before the subtracted element)
	 * to see if they == the remainder of the target value. If yes, set the two values
	 * into the return array and return it.
	 * 
	 * FULL SOLUTION DESCRPTION:
	 * - Create return array (values[])
	 * - Indexed for loop to loop over the first values
	 * 	- Create variable (sum) to hold the current sum
	 * 	- Indexed for loop to loop over the second values
	 * 	- If Sum = firstValue + secondValue, set the current index values in values[]
	 * - return values[]
	 * 
	 * 
	 */
	public static int[] twoSum_A1(int[] nums, int target) {
		// Create an array to hold the index values of the two elements that sum to target
		int[] values = new int[2];
		// Nested for loops to sum all possible combinations of elements in the nums array
		for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
			
			for (int secondIndex = firstIndex + 1; secondIndex < nums.length; secondIndex++) {
				// Sum the two values
				int sum = nums[firstIndex] + nums[secondIndex];
				// Check if current two elements sum to target
				if (sum == target) {
					values[0] = firstIndex;
					values[1] = secondIndex;
					return values;
				}
			}
		}
		
		return values;
	}
	
}
