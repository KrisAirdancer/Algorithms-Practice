package chapter_1;

import java.util.Arrays;

public class URLify {

	public static void main(String[] args) {
		
		char[] test = {'H', 'e', 'l', 'l', 'o', ' ', 'w', 'o', 'r', 'l', 'd', '!', ' ', 'I', ' ', 'a', 'm', ' ', 'a', 'l', 'i', 'v', 'e', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};

		URLify_A2(test, 23);
		
//		URLify_Model_Solution(test, 23);
		System.out.println(Arrays.toString(test));
	}
	
	/**
	 * Attempt 2 - much better
	 * 
	 * SOLUTION IDEA:
	 * - Loop over the string (array) to count all of the spaces in the string. Then, 
	 * start looping through the array from the back moving all of the characters back
	 * to the point in the array where they need to be placed based on the number of spaces
	 * times two. As you go, if the search pointer (insertion pointer is behind the search
	 * pointer) finds a space, write %20 into the next three empty spaces at the insertion
	 * pointer (yes, move the insertion pointer forward three while doing this), then move
	 * the search pointer up one to skip the found space, and continue the copy process
	 * until the front of the array is reached.
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - for each loop to loop over the array and count the spaces
	 * 	- if ' ', count++
	 * - initialize both the search and insertion indexes
	 * 	- Start the search index at the back of the array based on the necessary excess (count * 2)
	 * - while loop to loop over the array and copy elements back
	 * 	- If ' ' is found, insert %20
	 * 
	 * 
	 */
	public static void URLify_A2(char[] input, int trueLength) {
		// Count variable to count the number of spaces in the array
		int count = 0;
		// Loop over the array to count the number of spaces
		for (int index = 0; index < trueLength; index++) {
			if (input[index] == ' ') {
				count++;
			}
		}
		// Variable to track the character that needs to be copied over
		int searchIndex = trueLength - 1;
		System.out.println(count);
		// Variable to track where to insert the character being copied
		int insertIndex = trueLength + (count * 2) - 1;
		// Loop over the array to copy characters to the "end" of the array or insert %20
		while (searchIndex >= 0) {
			// If a space is found, insert %20
			if (input[searchIndex] == ' ') {
				System.out.println("if: [" + input[insertIndex] + "], searchIndex: " + searchIndex + ", insertIndex: " + insertIndex + ", input length: " + input.length);
				// Insert 0 and bump the insertion point to the next open slot
				input[insertIndex] = '0';
				insertIndex--;
				// Insert 2 and bump the insertion point to the next open slot
				input[insertIndex] = '2';
				insertIndex--;
				// Insert %, but don't bump the insertion point. That will happen below for this one. Otherwise, we move it twice without needing to.
				input[insertIndex] = '%';
			} else { // If no space is found, simply copy the character at the searchIndex back to the insertionIndex location
				System.out.println("else: " + "searchindex: " + searchIndex + ", insertIndex: " + insertIndex + ", input length: " + input.length);
				input[insertIndex] = input[searchIndex];
			}
			
			searchIndex--;
			insertIndex--;
		}
	}
	
	/**
	 * Attempt 1 - DNF
	 * 
	 * SOLUTION IDEA:
	 * - Loop over the array searching for ' '. If one is found, replace the ' ' with
	 * '%', then insert '2' and '0' just after it and shift the whole array up by two places.
	 * Will need to store index + 1 and index + 2 in temporary holding variables. 
	 * 
	 * FULL SOLUTION DESCRIPTION:
	 * - Initialize temp1 and temp2 as char variables
	 * - Indexed for loop to loop over the entire array
	 * 		- if input[index] == ' '
	 * 			- input[index] = '%'
	 * 			- temp1 = input[index + 1]
	 * 			- input[index + 1] = '2'
	 * 			- temp2 = input[index + 2]
	 * 			- input[index + 2] = '0'
	 * 			- // Shift the contents above index + 2 up by two and re-insert temp1 and temp2
	 * 			- char temp3;
	 * 			- for loop to loop over all items starting at i = index + 3
	 * 				- 
	 * 				- if i == index + 3
	 * 					- Insert temp1
	 * 				- else if i -- index + 4
	 * 					- Insert temp2
	 * 				- else
	 * 					- input[i
	 * 				- temp3 = input[i + 1] // Store the next char in temp variable
	 * 
	 * 
	 * 			- Shift the index variable up by the necessary amount (2?) to skip searching over the stuff I just added
	 * 
	 */
	public static void URLify_A1(char[] input) {
		
		char temp1, temp2;
		
		for (int index = 0; index < input.length; index++) {
			if (input[index] == ' ') {
				input[index] = '%';
				temp1 = input[index + 1];
				temp2 = input[index + 2];
				input[index + 1] = '2';
				input[index + 2] = '0';
				
				// Shift all elements from index + 3 and up, up by two
				for (int i = index + 3; i < input.length; i++) {
					
				}
			}
		}
		
	}

	/**
	 * Loop over the string backwards. Start by counting the number of spaces in the string, then multiply
	 * that number by two to get the number of spaces we will need to add to insert the %20. Note: %20 is
	 * three characters, but we are replacing the spaces in the string with the %20, so we are only
	 * overwriting the two characters after the space. Then we loop over the string again, also backwards, 
	 * shifting each item in the array "up" by the number of spaces that we calculated above (two found 
	 * spaces means we shift each character by 4 spaces, 3 found spaces means we shift by six, etc.).
	 * Each time we find a space, we insert %20. Making sure to do the insertion behind our index. That is,
	 * insert % at the index, then 2 at index - 1 and 0 at index - 2.
	 */
	public static void URLify_Model_Solution(char[] input, int trueLength) {
		int numOfSpaces = countOfChar_Model_Solution(input, 0, trueLength, ' ');
		int newIndex = trueLength - 1 + numOfSpaces * 2;
		
		/* If there are excess spaces, add a null character. This indicates that the spaces after that point
		 * have not been replaced with %20. */
		if (newIndex + 1 < input.length) {
			input[newIndex + 1] = '\0';
		}
		
		for (int oldIndex = trueLength - 1; oldIndex >= 0; oldIndex -= 1) {
			if (input[oldIndex] == ' ') { // Insert %20
				input[newIndex] = '0';
				input[newIndex - 1] = '2';
				input[newIndex - 2] = '%';
				newIndex -= 3;
			} else {
				input[newIndex] = input[oldIndex];
				newIndex -= 1;
			}
		}
	}
	
	public static int countOfChar_Model_Solution(char[] input, int start, int end, int target) {
		int count = 0;
		for (int i = start; i < end; i++) {
			if (input[i] == target) {
				count++;
			}
		}
		return count;
	}
	
}
