package problems_000_to_99;

public class ReverseInteger_7 {

	public static void main(String[] args) {
		
		int value = 1534236469;
		System.out.println(reverseInteger_A1(value));

	}
	
	/**
	 * Attempt 1 - June 30, 2021
	 * 
	 * SOLOUTION IDEA:
	 * - Loop over the integer from back to front, while doing so, pull each digit off
	 * using integer * 10 mod 10 (or something like that) and store the digit in a
	 * separate variable. Then take another variable (reversed), multiply it by 10,
	 * then add the pulled digit to reversed.
	 * - Not sure how to check for 32 bit overflow without causing 32 bit overflow...
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - 
	 * 
	 */
	public static int reverseInteger_A1(int num) {
		
		boolean negative = false;
		int temp = 0;
		int reversed = 0;
		
		if (num < 0) {
			negative = true;
			num *= -1;
		}
		
		while (num > 0) {
			temp = num % 10;
			num /= 10;
			
			reversed = (reversed * 10) + temp;
			
			if (reversed < Integer.MIN_VALUE || reversed > Integer.MAX_VALUE) {
				return 0;
			}
		}
		
		if (negative) {
			return reversed * -1;
		} else {
			return reversed;
		}
	}
	
	
}
