package chapter_1;

public class CheckPermutation {

	public static void main(String[] args) {
		
		String testOne = "aabbcc";
		String testTwo = "abcabc";
		String testThree = "Nope!";
		
		// Testing checkPermutation_1
		System.out.println("checkPermutation_1 matching: " + checkPermutation_1(testOne, testTwo));
		System.out.println("checkPermutation_1 not matching: " + checkPermutation_1(testOne, testThree));
		
		// Testing checkPermutation_2
		System.out.println("checkPermutation_2  matching: " + checkPermutation_2(testOne, testTwo));
		System.out.println("checkPermutation_2 not matching: " + checkPermutation_2(testOne, testThree));
		
	}
	
	/**
	 * Second attempt.
	 * 
	 * SOLUTION IDEA:
	 * - Create a tracking array to count the number of instances of each character in the first string,
	 * then count subtract the character counts of the second string from the counts of the first. If, when
	 * the counting is complete, the tracking array contains all zeros, the two strings are permutations,
	 * otherwise, they are not.
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Count how many of each character are in one of the strings. Store this in an array.
	 * 		- Initialized to a size of 256 to accept extended ASCII.
	 * - Loop over the second string and subtract one from the counts in the tracking array.
	 * 		- If any of the values in the tracking array are less than zero, we can quit early.
	 * - At the end, we loop over the tracking array to see if any values are not equal to zero. 
	 * 		- If any values are not zero, the strings are not permutations of each other.
	 * 
	 */
	public static boolean checkPermutation_2(String inputOne, String inputTwo) {
		
		int[] charCount = new int[256];
		
		// Loop over the entire inputOne string and update charCount
		for (int index = 0; index < inputOne.length(); index++) {
			// Increment the count at each character's associated index in the charCount array (their index is their ASCII value)
			charCount[inputOne.charAt(index)]++;
		}
		
		// Loop over the second input string (inputTwo) and update charCount
		for (int index = 0; index < inputTwo.length(); index++) {
			// Decrement the count at each character's associated index in the charCount array (their index is their ASCII value)
			charCount[inputTwo.charAt(index)]--;
			
			// Check if there any extra characters in inputTwo vs inputOne
			if (charCount[inputTwo.charAt(index)] < 0) {
				return false;
			}
		}
		
		// Check tracking array for all zeros
		for (int count : charCount) {
			if (count != 0) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * First attempt.
	 * 
	 * @param inputOne
	 * @param inputTwo
	 * @return
	 */
	public static boolean checkPermutation_1(String inputOne, String inputTwo) {
		
		if (inputOne.length() != inputTwo.length()) {
			return false;
		}
		
		int[] trackingOne = new int[256];
		int[] trackingTwo = new int[256];
		
		for (int index = 0; index < inputOne.length(); index++) {
			trackingOne[inputOne.charAt(index)]++;
			trackingTwo[inputTwo.charAt(index)]++;
		}
		
		for (int index = 0; index < trackingOne.length; index++) {
			if (trackingOne[index] != trackingTwo[index]) {
				return false;
			}
		}
		return true;
	}

}

/*
 ********** ATTEMPT 1 **********
 * RESTATEMENT OF PROBLEM:
 * - Evaluate two strings to determine if they are a permutation. That is, do they contain exactly
 * the same set of characters Ex. aabbcc is a permutation of abcabc
 * 
 * SOLUTION IDEA:
 * - Sort the two input strings then loop over both of them at the same time comparing the characters in
 * each one to each other. That is, string[index] == stringTwo[index]?
 * 
 * BETTER OPTION
 * - Loop over both strings keeping track of how many times each character shows up in each string in
 * separate tracking arrays (will need one tracking array for each string), then compare the values
 * in the tracking arrays to each other. If the tracking arrays are the same, the strings are permutations.
 * 
 * FULL SOLUTION DESCRIPTION:
 * - Declare and initialize two new tracking arrays
 * - for loop to loop over both strings and update their tracking arrays
 * 	- Can use extended ASCII for this - eASCII is 256 characters long
 * 
 * DEFINITIONS OF VARIABLES AND PARAMETERS:
 * - Method parameters: String inputOne and String inputTwo
 * 
 * PSEUDO-CODE SOLUTION:
 * - Declare two tracking arrays - trackingOne and trackingTwo
 * - Initiate for loop with index = 0
 * 	- trackingOne = inputOne[index]
 * 	- etc.
 * - for loop to loop over both tracking arrays and compare their values
 * 	- if block to check for equality (if not equal)
 * 		- return false
 * - return true if the entire for loop is traversed and we make it to this point - that means we've found no
 * unequal values
 * 
 * NOTES ON IMPLEMENTATION:
 * - This is the memory "intensive" implementation. It will take up a bit more memory because it requires that we
 * create two new arrays. However, if we went with the sort both strings, we would also have to create two new arrays
 * or Strings. Since String objects have an array that holds all of the chars in the String, the two will be roughly
 * the same in terms of memory constraints - we could go and calculate the difference, but they would be so close
 * I'll not do the math at this point. If memory is a necessary constraint, we can do the math to work out
 * which option is better.
 * - Because sorting arrays is slower than simply traversing two strings and two arrays once each (four total
 * traversals), going with the non-sorting option will both keep our memory usage low and our speed higher.
 * 
 */
