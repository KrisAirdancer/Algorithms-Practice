package kyu6SmallKata;

/**
 * Digital Root Kata, Codewars
 * @author Chris Marston, March 2021
 * 
 * *** PASSED ***
 * 
 * CHALLENGE DESCRIPTION:
 * Digital root is the recursive sum of all the digits in a number.
 * Given n, take the sum of the digits of n. If that value has more than one digit,
 * continue reducing in this way until a single-digit number is produced.
 * The input will be a non-negative integer.
 * 
 * Examples
 * 16  -->  1 + 6 = 7
 * 942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
 * 132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
 * 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 *
 */

public class DigitalRootKata {

	public static void main(String[] args) {
		
		// Testing solutions
		System.out.println(digitalRoot(16) );
		System.out.println(digitalRoot(942) );
		System.out.println("Reursive Digital Root: " + recursiveDigitalRoot(942) );
		System.out.println("Recursive Final Digital Root for 942: " + recursiveFinalDigitalRoot(942) );
		System.out.println("Recursive Final Digital Root for 132189: " + recursiveFinalDigitalRoot(132189) );
		System.out.println("Recursive Final Digital Root for 493193: " + recursiveFinalDigitalRoot(493193) );

	}
	
	/**
	 * Returns the "first" Digital Root of an integer using a while loop.
	 * 
	 * Ex. 942  -->  9 + 4 + 2 = 15
	 * 
	 * @param value An integer to be evaluated for its "first" digital root.
	 * @return The "first" digital root of a given integer.
	 */
	public static int digitalRoot(int value) {
		
		int sum = 0;
		
		while(value > 0) {
			
			sum = sum + (value % 10);
			value = (value / 10);
		}
		return sum;
	}
	
	/**
	 * Returns the "first" Digital Root of a given integer using a recursive method.
	 * 
	 * Ex. 942  -->  9 + 4 + 2 = 15
	 * 
	 * @param value An integer to be evaluated for its "first" digital root.
	 * @return The "first" digital root of the input integer.
	 */
	public static int recursiveDigitalRoot(int value) {
		
		int sum = (value % 10);
		
		if (value <= 0) {
			return sum;
		} else {
			sum = sum + recursiveDigitalRoot(value / 10);
			value = value % 10;
		}
		return sum;
	}
	
	/**
	 * *** SUBMITTED SOLUTION ***
	 * Returns the "final" Digital Root of a given integer. The "final" digital root is calculated
	 * using a recursive method.
	 * 
	 * Ex. 942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
	 * 
	 * @param value An integer to be evaluated for its "final" digital root.
	 * @return The "final" digital root of a given integer.
	 */
	public static int recursiveFinalDigitalRoot(int value) {
		
		int sum = (value % 10);
		
		if (value <= 0) {
			return sum;
		} else {
			sum = sum + recursiveFinalDigitalRoot(value / 10);
			value = value % 10;
		}
		
		if ( (sum / 10) > 0) {
			sum = recursiveFinalDigitalRoot(sum);
		}
		return sum;
	}

}










