package problems_100_to_199;

public class FindPeakElement_162 {

	public static void main(String[] args) {
		
		int[] test = {1, 2, 1, 3, 5, 6, 4};
		
		System.out.println(findPeakElement_A1(test));
		

	}
	
	/**
	 * Attempt 1 - July 13, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - For the first element in the array, check if the value after it is smaller.
	 * If it is, return current index.
	 * - For the last element in the array, check that the previous element is smaller
	 * than it. If it is, return current index.
	 * - Loop over each element in the array comparing the current element to the elements
	 * before and after it. If current is larger than both previous and next, return
	 * the index of current. 
	 * - Optimization - skip elements - not sure how though?
	 */
	public static int findPeakElement_A1(int[] nums) {
		
		if (nums.length < 2) {
			return 0;
		}
		
		for (int index = 0; index < nums.length; index++) {
			
			int current = nums[index];
			
			if (index == 0) {
				if (current > nums[index + 1]) {
					return index;
				}
			} else if (index == nums.length - 1) {
				if (current > nums[index - 1]) {
					return index;
				}
			} else {
				if (current > nums[index - 1] && current > nums[index + 1]) {
					return index;
				}
			}
		}
		return -1;
	}

}
