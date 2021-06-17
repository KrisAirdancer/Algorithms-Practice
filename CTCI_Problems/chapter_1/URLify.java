package chapter_1;

public class URLify {

	public static void main(String[] args) {
		

	}
	
	/**
	 * Attempt 1
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

}
