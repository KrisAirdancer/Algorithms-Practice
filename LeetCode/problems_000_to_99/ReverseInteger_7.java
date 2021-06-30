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
		}
		
		if (negative) {
			return reversed * -1;
		} else {
			return reversed;
		}
	}
	
	/**
	 * Model Solution
	 */
	public static int reverseInteger_ModelSolution(int num) {
		// Create a variable to hold our reversted integer 
		int reversed = 0;
		/* Loop over the input integer until it has been reduced to
		 * zero (this is possible b/c when we divide an integer
		 * by 10, the integer will be rounded down to the next
		 * lowest value. When we get to 0.something, it will
		 * be rounded to zero. If this wasn't the case, we would
		 * never reach zero, just an infinitely small decimal value. */
        while (num != 0) {
        	// Pull the last digit off of num and store it
            int last = num % 10;
            num /= 10;
            /* Check to see if the new value that will be created
             * when we add last to reversed is within the 32-bit
             * range. That is, check for overflow. 
             * 
             * 1. If temp = reversed * 10 + last causes overflow,
             * then it must be that reversed >= INTMAX / 10
             * 2. if reversed > INTMAX / 10, then temp = reversed * 10 + last
             * is guaranteed to cause an overflow.
             * 3. If reversed == INTMAX / 10, then temp = reversed * 10 + last
             * will overflow if and only if last > 7
             * 
             * The same logic applies for negative values. */
            if (reversed > Integer.MAX_VALUE/10 || (reversed == Integer.MAX_VALUE / 10 && last > 7)) {
            	return 0;
            }
            if (reversed < Integer.MIN_VALUE/10 || (reversed == Integer.MIN_VALUE / 10 && last < -8)) {
            	return 0;
            }
            // If no overflow detected, add the value to reversed and continue.
            reversed = reversed * 10 + last;
        }
	    return reversed;
	    
	    }
	
	
}
