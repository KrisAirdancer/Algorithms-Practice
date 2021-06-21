package problems_400_to_499;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FizzBuzz_412 {

	public static void main(String[] args) {
		
		

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
