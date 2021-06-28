package problems_000_to_99;

public class RomanToInteger_13 {

	public static void main(String[] args) {
		
		System.out.println(romanToInt_A1("I"));
		System.out.println(romanToInt_A1("II"));
		System.out.println(romanToInt_A1("III"));
		System.out.println(romanToInt_A1("IV"));
		System.out.println(romanToInt_A1("IX"));
		System.out.println(romanToInt_A1("LVIII"));
		System.out.println(romanToInt_A1("MCMXCIV"));

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
