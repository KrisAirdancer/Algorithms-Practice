package problems_000_to_99;

import java.util.Arrays;

public class RemoveElement_27 {
	
	public static void main(String[] args) {
		
		int[] test = {1, 2, 3, 4, 5, 6, 2, 8, 9, 10, 2, 12, 13, 14, 15};
		
		System.out.println(removeElement_A1(test, 2));
		System.out.println(Arrays.toString(test));
		
	}
	
	/**
	 *  Attempt 1 - October 14, 2021 - SUBMITTED, PASSED
	 * 
	 * Should be running in O(N) time.
	 */
	public static int removeElement_A1(int[] nums, int val) {
		
		int newLength = nums.length;
		int swapDist = 0;
		
		for (int i = 0; i < nums.length; i++) {
			
			if (nums[i] == val) {
				swapDist++;
				newLength--;
			} else {
				int temp = nums[i - swapDist];
				nums[i - swapDist] = nums[i];
				nums[i] = temp;
			}
		}
		
		return newLength;
	}
	
	

}
