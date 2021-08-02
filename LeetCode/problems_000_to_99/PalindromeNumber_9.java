package problems_000_to_99;

public class PalindromeNumber_9 {

	public static void main(String[] args) {
		
		// Testing palindromeNumber
		int palindrome = 121;
		int nonidrome = 123456;
		
		System.out.println("Expected: true, Actual: " + palindromeNumber_A1(palindrome));
		System.out.println("Expected: false, Actual: " + palindromeNumber_A1(nonidrome));

	}
	
	/**
	 * Attempt 1 - August 2, 2021
	 */
	public static boolean palindromeNumber_A1(int num) {
		// Convert integer to String
		String stringNum = Integer.toString(num);
		
		// Create pointers
		int beginning = 0;
		int end = stringNum.length() - 1;
		int cycleCount = stringNum.length();
		
		// Compare values
		while (cycleCount > 0) {
//			System.out.println("num: " + num + " - beginning: " + stringNum.charAt(beginning) + ", end: " + stringNum.charAt(end));
			if (stringNum.charAt(beginning) != stringNum.charAt(end)) {
				return false;
			}
			
			beginning++;
			end--;
			
			cycleCount--;
		}
		
		return true;
	}

}
