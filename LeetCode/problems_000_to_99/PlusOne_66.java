package problems_000_to_99;

public class PlusOne_66 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * Attempt 1 - August 23, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - Pull the last integer in the array
	 * - Increment it by one
	 * - If it is greater than 9,
	 *  - Set the last integer in the array to 0
	 * 	- Pull the second to last integer in the array and increment it by 1 
	 */
	public static int[] plusOne_A1(int[] digits) {
	    
		int last = digits[digits.length - 1];
		
		digits[digits.length - 1] = ++last;
		
		for (int i = digits.length - 1; i > 0; i++) {
			
			if (digits[i`] > 9) {
				
			}
		}
		
		
		return digits; // Temporary return
	}
	
}



