package problems_000_to_99;

public class ReverseInteger_7 {

	public static void main(String[] args) {
		
		int value = -12343897;
		System.out.println(reverseInteger_A4(value));
//		System.out.println(Integer.MAX_VALUE);
//		System.out.println(Integer.MIN_VALUE);

	}
	
	/**
	 * Attempt 4 - July 14, 2021
	 * 
	 * SOLUTION IDEA:
	 * - Make a temporary variable (pop) to hold the last digit of the input num
	 * - Divide num by 10 to remove the last digit
	 * - Check for overflow errors
	 * 	- If reversed > IntegerMAX / 10 || (reversed == intMAX / 10 && pop > 7), return 0
	 * 	- If reversed < IntMIN / 10 || (reversed == intMIN / 10 && pop < -8), return 0
	 * 	- If overflow, return 0
	 * - Append pop to reversed
	 */
	public static int reverseInteger_A4(int num) {
		
		int reversed = 0;
		
		while (num != 0) {
			// Pop last digit off num
			int pop = num % 10;
			
			// Remove last digit from num
			num /= 10;
			
			// Check for overflow errors
			if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && pop > 7)) {
				return 0;
			} else if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			} else {
				reversed = (reversed * 10) + pop;
			}
		}
		return reversed;
	}
	
	/**
	 * Attempt 3 - July 7, 2021 
	 * 
	 * SOULTION OUTLINE:
	 * - Use a while loop to loop over num until num <= 0, each time...
	 * 	- Pull the last digit off of num using %
	 * 	- Check that the new value won't produce an overflow error - must be done before adding
	 * new digit to reversed
	 * 	- Multiply reversed by 10 and add the popped digit to reversed
	 * 	- Divide num by 10 to remove the last digit
	 * 
	 * 
	 */
	public static int reverseInteger_A3(int num) {

		int reversed = 0;
		int popped = 0;
		
		while (num != 0) {
			popped = num % 10;
			num /= 10;
			
			// CONDUCT OVERFLOW CHECK
			if (reversed > Integer.MAX_VALUE / 10) {
				return 0;
			} else if (reversed == Integer.MAX_VALUE / 10 && popped > 7) {
				return 0;
			} else if (reversed < Integer.MIN_VALUE / 10) {
				return 0;
			} else if (reversed == Integer.MAX_VALUE && popped < -8) { 
				return 0;
			} else {
				reversed = (reversed * 10) + popped;
			}
		}
		return reversed;
	}
	
	/**
	 * Attempt 2 - July 1, 2021
	 * 
	 * SOLUTION IDEA:
	 * - Loop over the input integer from end to start, each loop pull the last integer
	 * off the end using remainder (%) operator by 10, divide the input integer by 10
	 * to shorten it for the next round, then multiply the reversed integer by 10 and
	 * add the integer popped off the end of the input integer.
	 * 
	 * - Check for integer overflow error before completing last step of adding the 
	 * popped integer to reversed.
	 * - Check for overflow by comparing reversed (before addition of the most recent
	 * popped value) to Integer.MAX / 10. Because we will be multiplying reversed by
	 * 10 in the addition step, we can make a comparison to Integer.MAX / 10. If reversed
	 * is larger than Integer.MAX, then it will definitely yield an overflow error
	 * when we try to multiply it by 10. This same logic applies for values that are
	 * below the minimum value.
	 * 
	 * - Another case that will have to be checked is the case when reversed is equal
	 * to Integer.MAX / 10. In this case, we are safe to add the value so long as the
	 * value is equal to or less than 7 (positive case) or greater than or equal to -8
	 * (negative case). (We will check both pop > 7 and pop < -8. If either is true,
	 * then we know we will get an overflow error). This is because the range of valid
	 * integer values in Java is -2147483648 to 2147483647. When we make the comparison
	 * of reversed to Integer.MAX we will appear to be fine, when we multiply by 10
	 * to add the pop integer, we will again be just fine because the multiplication
	 * by 10 leaves us with a 0 at the end of the new reversed value. But when we add
	 * the pop value, it must still fall within the acceptable range of integer values
	 * (-2147483648 to 2147483647), this means that after the multiply by 10 step, we
	 * are left with a buffer of 7 and 8, respectively. Therefore, the pop value must
	 * be equal to or less than that buffer range. If not, we will exceed the acceptable
	 * integer values.
	 */
	public static int reverseInteger_A2(int num) {
		
		int reversed = 0;
		int pop = 0;
		// Reverse the integer
		while (num != 0) {
			pop = num % 10;
			num /= 10;
			
			if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10
					&& pop > 7)) {
				return 0;
			} else if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10
					&& pop < -8)) {
				return 0;
			}
			
			reversed = (reversed * 10) + pop;
		}
		return reversed;
		
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
