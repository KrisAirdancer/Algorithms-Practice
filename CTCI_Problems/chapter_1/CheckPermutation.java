package chapter_1;

public class CheckPermutation {

	public static void main(String[] args) {
		
		String testOne = "aabbcc";
		String testTwo = "abcabc";
		String testThree = "Nope!";
		
		System.out.println(checkPermutation(testOne, testTwo));
		System.out.println(checkPermutation(testOne, testThree));
		
	}
	
	public static boolean checkPermutation(String inputOne, String inputTwo) {
		
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
 * - return true if the enitre for loop is traversed and we make it to this point - that means we've found no
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
