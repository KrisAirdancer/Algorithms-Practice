package problems_000_to_99;

public class RomanToInteger_13 {

	public static void main(String[] args) {
		
		System.out.println(romanToInt_A6("I") + ", ONE");
		System.out.println(romanToInt_A6("II") + ", TWO");
		System.out.println(romanToInt_A6("III") + ", THREE");
		System.out.println(romanToInt_A6("IV") + ", FOUR");
		System.out.println(romanToInt_A6("IX") + ", NINE");
		System.out.println(romanToInt_A6("LVIII") + ", FIFTY-EIGHT");
		System.out.println(romanToInt_A6("MCMXCIV") + ", NINETEEN-NINTY-FOUR");

	}
	
	/**
	 * Attempt 6 - August 3, 2021
	 */
	public static int romanToInt_A6(String num) {
		
		// Create sum variable
		int sum = 0;
		
		// Check for length 1 string
		if (num.length() < 2) {
			return charToInt_A6(num.charAt(0));
		}
		
		// Loop over input string
		for (int index = 0; index < num.length(); index++) {
			
			int current = charToInt_A6(num.charAt(index));
			int next;

			if (index + 1 > num.length() - 1) { // For last character (number) in num

				current = charToInt_A6(num.charAt(index));
				sum += current;
				
				index++; // Skip the next number in num - it has already been accounted for in this case

			} else { // For all characters before the last character in num
				
				next = charToInt_A6(num.charAt(index + 1));
			
				if (next > current) { // For subtractive situation. i.e. IV, IX, etc.
					sum = sum + (next - current);
					
					index++; // Skip the next number in num - it has already been accounted for in this case
				} else {
					sum += current;
				}
			}
		}
		return sum;
	}
	
	/**
	 * Helper method for romanToInt_A6.
	 * 
	 * Converts a Roman numeral char into an integer, then returns that integer.
	 */
	public static int charToInt_A6(char roman) {
		
		switch (roman) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return -1;
		}
	}
	
	/**
	 * Attempt 5 - July 15, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - Initialize output variable to 0
	 * - Indexed for loop to loop over the string using charAt to access the characters
	 * 	- *If input is length 1, convert that value and return***
	 * 		- output = output + current
	 * 	- *If index + 1 is greater than the length of the input, only convert index***
	 * 		- output = (output * 10) + current
	 * 	- *If index + 1 has a value that is greater than the current index value, subtract index from index + 1***
	 * 		- output = (output * 10) + (next - current)
	 * 	- *Else, convert only index***
	 * 		- output = (output * 10) + current
	 */
	public static int romanToInt_A5(String input) {
		
		int output = 0;
		
		for (int index = 0; index < input.length(); index++) {
			
			if (input.length() < 2) {
				return charToInt_A5(input.charAt(index));
				
			} else if (index + 1 > input.length() - 1) {
				output = (output) + charToInt_A5(input.charAt(index));
				
			} else if (charToInt_A5(input.charAt(index + 1)) > charToInt_A5(input.charAt(index))) {
				output = (output) + (charToInt_A5(input.charAt(index + 1)) - charToInt_A5(input.charAt(index)));
				
			} else {
				output = (output) + charToInt_A5(input.charAt(index));
			}
		}
		return output;
	}
	
	/**
	 * Auxiliary method for Attempt 5
	 */
	public static int charToInt_A5(char input) {
		
		switch (input) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return -1;
		}
	}
	
	/**
	 * Attempt 4 - July 9, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - Initialize a result variable of type int
	 * - Use indexed for loop to loop over input string - index = 0
	 * 	- if (input[index + 1] < input.length() && input[index + 1] > input[index]) result = result + (input[index + 1] - input[index])
	 * 	- else, just add input[index]
	 * 
	 * - Create helper method with switch statement to convert each character into an integer
	 */
	public static int romanToInt_A4(String input) {
		
		int result = 0;
		
		for (int index = 0; index < input.length(); index++) {
			
			int current = charToInt_A4(input.charAt(index));
			int next = 0; // Initialize to zero b/c current can never be less than 1
			
			if ((index + 1) < input.length()) {
				next = charToInt_A4(input.charAt(index + 1));
			}
			
			if ((index + 1) < input.length() && next > current) {
				result = result + (next - current);
				index++; // Skip the value at index + 1
			} else {
				result += current;
			}
			next = 0; // Clear variable to ensure no false positives on next check
		}
		return result;
	}
	
	/**
	 * Helper method for romanToInt_A4
	 */
	public static int charToInt_A4(char character) {
		
		switch(character) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return -1;
		}
			
	}
	
	/**
	 * Attempt 3 - July 6, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - 
	 * 
	 */
	public static int romanToInt_A3(String input) {
		
		int result = 0;
		
		if (input.length() < 2) {
			result = romanCharToInt_A3(input.charAt(0));
			return result;
		}
		
		for (int index = 0; index < input.length(); index++) {
			
			int current = romanCharToInt_A3(input.charAt(index));
			int next = 0;
			
			if (index + 1 < input.length()) {
				next = romanCharToInt_A3(input.charAt(index + 1));
			}
			
			if (next > current) {
				result += (next - current);
				index++;
			} else {
				result += current;
			}
		}	
		return result;
	}
	
	/**
	 * Helper method for A3
	 */
	public static int romanCharToInt_A3(char input) {
		
		switch (input) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return -1;
		}
	}
	
	
	/**
	 * Attempt 2 - July 5, 2021
	 * 
	 * NOTES:
	 * - "Edge Cases:"
	 * 	- I before V or X
	 * 	- X before L or C
	 * 	- C before D or M
	 * 
	 * SOLUTION IDEA:
	 * - Loop over the String input. For each char, convert it to it's integer value then add
	 * that integer to sum (sum += new integer). On each iteration, before adding the value
	 * to sum, check that the value at index + 1 is not greater than the current value. If
	 * it is, subtract index from index + 1 and add that value to sum instead, then increment 
	 * the index to skip index + 1.
	 * 
	 * - Initialize romanAsInt to 0 
	 * - Indexed for loop that starts at index = 0 and goes to index < input.length()
	 * 	- if index + 1 greater than index,
	 * 		- romanAsInt += (input[index + 1] - input[input]) 
	 * 	- else, romanAsInt += input[index]
	 * - return romanAsInt
	 * 
	 * 
	 */
	public static int romanToInt_A2(String romanNum) {
		int romanAsInt = 0;
		
		for (int index = 0; index < romanNum.length(); index++) {
			
//			int current = charToInt(romanNum.charAt(index));
//			int next = charToInt(romanNum.charAt(index + 1));
			
			if (romanNum.length() > 1 && charToInt(romanNum.charAt(index + 1)) > charToInt(romanNum.charAt(index))) {
				romanAsInt += (charToInt(romanNum.charAt(index + 1)) - charToInt(romanNum.charAt(index)));
			} else {
				romanAsInt += charToInt(romanNum.charAt(index));
			}
		}
		return romanAsInt;
	}
	
	/**
	 * Helper method for romanToInt_A2
	 */
	public static int charToInt(char input) {
		
		switch (input) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return -1;
					
		}
	}
	
	/**
	 * Attempt 1 - June 28, 2021
	 * 
	 * SOLUTION IDEA:
	 * - Sum the roman numerals from left to right. However, on each pass, inspect the next
	 * character to see if it is larger than the current character. If it is larger, instead
	 * of adding the value of the current character to the result, do result = (next - current).
	 * Note: will not need to check more than index + 1 b/c roman numerals only ever subtract
	 * one from the following value, never more.
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Declare result - initialize to 0
	 * - indexed for loop
	 * 	- if charToRoman(index + 1) < charToRoman(index), add the current value to result - charToRoman method returns a numerical value of the roman numeral
	 * 	- else, subtract index from index + 1 then add to result and bump index by an extra place to skip index + 1
	 * 
	 */
	public static int romanToInt_A1(String input) {
		
		int result = 0;
		
		for (int index = 0; index < input.length(); index++) {
			
			int current = charToInt_A1(input.charAt(index));
			int next = 0;
			
			/* If the next instance of index + 1 is in bounds, set the next variable to
			 * the int value of input(index + 1) */
			if (index + 1 < input.length()) { 
				next = charToInt_A1(input.charAt(index + 1));
			}
			
			/* If the next character in the string represents an int that is larger than
			 *  the current int, it is the special case of subtraction (IX, IV, etc.),
			 *  so we subtract the two values before adding them to the result. */
			if (next > current) { 
				
				result = result + (next - current);
				// Increment the index to prevent a double addition of the index + 1 element	
				index++;
			} else { // Add the current value to the result
				switch (current) {
					case 1:
						result++;
						break;
					case 5:
						result += 5;
						break;
					case 10:
						result += 10;
						break;
					case 50:
						result += 50;
						break;
					case 100:
						result += 100;
						break;
					case 500:
						result += 500;
						break;
					case 1000:
						result += 1000;
						break;
				}
			}
		}
		
		
		return result;
	}
	/**
	 * Helper method for romanToInt_A1.
	 * 
	 * Note: Should have functionality to check for invalid inputs. Left out due to time constraints.
	 */
	public static int charToInt_A1(char input) {
		
		switch (input) {
			case 'I':
				return 1;
			case 'V':
				return 5;
			case 'X':
				return 10;
			case 'L':
				return 50;
			case 'C':
				return 100;
			case 'D':
				return 500;
			case 'M':
				return 1000;
			default:
				return -1;
		}
	}

}
