package problems_000_to_99;

public class LongestCommonPrefix_14 {

	public static void main(String[] args) {
		
		String[] test = {"flight", "flew", "fly"};
		String[] testTwo = {"ab", "a"};
		
		System.out.println(longestCommonPrefix_A1(test));
		System.out.println(longestCommonPrefix_A1(testTwo));

	}

	/**
	 * Attempt 1 - Aug 26, 2021
	 */
	public static String longestCommonPrefix_A1(String[] strs) {
		
		// Initialize output = ""
		// Loop over all characters in the first element in the list
			// Save the first letter of the first string to the variable "match"
			// Loop over the current char of every element in the list starting at element 2 (i = 1)
				// If match != current character, return output
			// If loop completes, concatenate match to output
		// return output - this fires in the case that the words are a complete match
		
		String output = "";
		
		for (int i = 0; i < strs[0].length(); i++) {
			
			char match = strs[0].charAt(i);
			
			for (int index = 1; index < strs.length; index++) {
				
				if (strs[index].length() > strs[0].length() && strs[index].length() < index) {
					return output;
				}
				
				if (strs[index].charAt(i) != match) {
					return output;
				}
			}
			
			output += match;
		}
		return output;
	}
}
