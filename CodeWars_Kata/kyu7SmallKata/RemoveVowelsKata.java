package kyu7SmallKata;

/**
 * Remove Vowels Kata, Codewars
 * @author Chris Marston, March 2021
 * 
 * *** PASSED ***
 * 
 * CHALLENGE DESCRIPTION:
 * Your task is to write a function that takes a string and returns a new string with all vowels removed.
 * Note: for this Kata y isn't considered a vowel.
 * 
 * Example:
 * "Your task is to write..." --> "Yr tsk t wrt..."
 */

public class RemoveVowelsKata {

	public static void main(String[] args) {
		
		// Testing removeVowels
		System.out.println(removeVowels("Apples") );
		System.out.println(removeVowels("Your task is to write a function that takes a string and returns a new string with all vowels removed"));
		
	}
	
	/**
	 * Removes all vowels from a given String and returns a new string containing only the consonants from the original String.
	 * 
	 * Note that y is not counted as a vowel.
	 * 
	 * @param phrase A String whose vowels will be removed.
	 * @return A new string containing only the consonants of the original.
	 */
	public static String removeVowels(String phrase) {
		
		String newPhrase = "";
		
		for (int index = 0; index < phrase.length(); index++) {
			
			char letter = phrase.charAt(index);
			
			switch (letter) {
				case 'A':
					break;
				case 'E':
					break;
				case 'I':
					break;
				case 'O':
					break;
				case 'U':
					break;
				case 'a':
					break;
				case 'e':
					break;
				case 'i':
					break;
				case 'o':
					break;
				case 'u':
					break;
				default:
					newPhrase = newPhrase + letter;
			}
		}
		return newPhrase;
	}

}
