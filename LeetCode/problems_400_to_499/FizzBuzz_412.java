package problems_400_to_499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz_412 {

	public static void main(String[] args) {
		
		System.out.println(fizzBuzz_A3(533515));

	}
	
	/**
	 * Attempt 3 - July 9, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - Initialize arraylist of type string
	 * - Initialize variable current of type int to 0
	 * - Use while loop to loop over input - loop until input < 1 (aka. until it is zero) (don't have to worry about negative values)
	 * 	- Set current = input % 10
	 * 	- input / 10 
	 * 	- Check for divisibilty by 5 and 3 with modulus - add FB to array
	 * 	- Check for divisibility by 5
	 * 	- Check for divisibilty by 3
	 * 	- else - add current to array
	 * 
	 *
	 */
	public static List<String> fizzBuzz_A3(int input) {
		
		List<String> output = new ArrayList<String>();
		
		int current = 0;
		
		while (input > 0) {
			
			current = input % 10;
			input /= 10;
			
			if ((current % 5 == 0) && (current % 3 == 0)) {
				output.add("FizzBuzz");
			} else if (current % 5 == 0) {
				output.add("Buzz");
			} else if (current % 3 == 0) {
				output.add("Fizz");
			} else {
				output.add(Integer.toString(input));
			}
		}
		return output;
	}
	
	
	/**
	 * Attempt 2 - July 5, 2021
	 * 
	 * SOLUTION OUTLINE:
	 * - Create output array of type String and length input - 1
	 * - Indexed for loop that starts at 1
	 * - Check for divisibility by 3 and 5
	 * 	- If true, set output[index - 1] to "FizzBuzz"
	 * - Check for divisibility by 3
	 * 	- If true, set output[index - 1] to "Fizz"
	 * - Check for divisibility by 5
	 * 	- If true, set output[index - 1] to "Buzz"
	 * - Else, set output[index - 1] to index
	 * 
	 * 
	 */
	public static List<String> fizzBuzz_A2(int input) {
		List<String> output = new ArrayList<String>();
		
		for (int index = 1; index <= input; index++) {
			
			if (index % 3 == 0 && index % 5 == 0) {
				output.add("FizzBuzz");
			} else if (index % 3 == 0) {
				output.add("Fizz");
			} else if (index % 5 == 0) {
				output.add("Buzz");
			} else {
				output.add(Integer.toString(index));
			}
		}
		return output;
	}
	
	
	/**
	 * SOLUTION IDEA:
	 * - Use a loop to count from zero to value. Each loop, check if the value is divisible
	 * by 3, 5, both, or neither. If divisible by both, return "FizzBuzz", if divisible by
	 * 3, return "Fizz", if divisible by 5, return "Buzz", and if divisible by neither,
	 * return i. Update: Don't return under the above conditions. Instead add the string
	 * value of the returns above to a String array. Start the method by initializing a
	 * String array of length value.
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * 
	 * 
	 */
	public static List<String> fizzBuzz(int value) {
		
		List<String> output = new ArrayList<String>();
		
		for (int index = 1; index <= value; index++) {
			if (index % 3 == 0 && index % 5 == 0) {
				output.add("FizzBuzz");
			} else if (index % 5 == 0) {
				output.add("Buzz");
			} else if (index % 3 == 0) {
				output.add("Fizz");
			} else {
				output.add(Integer.toString(index));
			}
		}
		return output;
	}

}
