package kyu6SmallKata;

/**
 * Bit Counting Kata, Codewars 
 * @author Chris Marston, March 2021
 * 
 * *** PASSED ***
 * 
 * CHALLENGE DESCRIPTION:
 * Write a function that takes an integer as input, and returns the number of bits that are equal
 * to one in the binary representation of that number. You can guarantee that input is non-negative.
 * 
 * Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case.
 *
 */

public class BitCountingKata {

	public static void main(String[] args) {
		
		// Testing solutions
		System.out.println(bitCounting(1234) );
	}
	
	/**
	 * *** SUBMITTED SOLUTION ***
	 * Returns the sum of the bits in a given integer that are equal to one.
	 * 
	 * @param value  An integer whose number of bits equal to one will be returned.
	 * @return The number of bits equal to one in a given integer.
	 */
	public static int bitCounting(int value) {
		
		String bits = Integer.toBinaryString(value);
		
		int numberOfOnes = 0;
		
		for (int index = (bits.length() - 1); index >= 0; index--) {
			
			if (bits.charAt(index) == '1') {
				numberOfOnes++;
			}
		}
		return numberOfOnes;
	}

}