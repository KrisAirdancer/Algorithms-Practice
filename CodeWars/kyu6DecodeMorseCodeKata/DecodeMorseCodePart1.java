package kyu6DecodeMorseCodeKata;

/**
 * Decode Morse Code Kata, Codewars
 * @author Chris Marston, March 2021
 * 
 * NOTE: This class is dependent on the MorseCodeDictionary class
 * 
 * NOTE TO FUTURE-SELF:
 * This ended up being a very long and confusing solution. Try to condense it using some of the existing functions in Java.
 * The .split() method would be useful to split the input string into words (use .split("   ") <- 3 spaces) then to split each
 * word into letters using .split(" ").
 * 
 * *** PASSED ***
 * 
 * CHALLENGE DESCRIPTION:
 * In this kata you have to write a simple Morse code decoder. While the Morse code is now mostly superseded by voice and digital
 * data communication channels, it still has its use in some applications around the world. The Morse code encodes every character
 * as a sequence of "dots" and "dashes". For example, the letter A is coded as ·−, letter Q is coded as −−·−, and digit 1 is coded
 * as ·−−−−. The Morse code is case-insensitive, traditionally capital letters are used. When the message is written in Morse code,
 * a single space is used to separate the character codes and 3 spaces are used to separate words. For example, the message HEY JUDE
 * in Morse code is ···· · −·−−   ·−−− ··− −·· ·.
 * 
 * NOTE: Extra spaces before or after the code have no meaning and should be ignored.
 * 
 * In addition to letters, digits and some punctuation, there are some special service codes, the most notorious of those is the
 * international distress signal SOS (that was first issued by Titanic), that is coded as ···−−−···. These special codes are treated
 * as single special characters, and usually are transmitted as separate words. Your task is to implement a function that would take
 * the Morse code as input and return a decoded human-readable string.
 * 
 * For example:
 * MorseCodeDecoder.decode(".... . -.--   .--- ..- -.. .") //should return "HEY JUDE"
 * NOT * : For coding purposes you have to use ASCII characters . and -, not Unicode characters.
 * 
 * The Morse code table is preloaded for you as a dictionary, feel free to use it:
 * 
 * Coffeescript/C++/Go/JavaScript/Julia/PHP/Python/Ruby/TypeScript: MORSE_CODE['.--']
 * C#: MorseCode.Get(".--") (returns string)
 * Elixir: @morse_codes variable (from use MorseCode.Constants). Ignore the unused variable warning for morse_codes because it's no
 * longer used and kept only for old solutions.
 * Elm: MorseCodes.get : Dict String String
 * Haskell: morseCodes ! ".--" (Codes are in a Map String String)
 * Java: MorseCode.get(".--")
 * Kotlin: MorseCode[".--"] ?: "" or MorseCode.getOrDefault(".--", "")
 * Rust: MORSE_CODE
 * Scala: morseCodes(".--")
 * Swift: MorseCode[".--"] ?? "" or MorseCode[".--", default: ""]
 * C: provides parallel arrays, i.e. morse[2] == "-.-" for ascii[2] == "C"
 * All the test strings would contain valid Morse code, so you may skip checking for errors and exceptions. In C#, tests will fail if
 * the solution code throws an exception, please keep that in mind. This is mostly because otherwise the engine would simply ignore the
 * tests, resulting in a "valid" solution.
 * 
 * Good luck!
 * 
 * After you complete this kata, you may try yourself at Decode the Morse code, advanced.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DecodeMorseCodePart1 {

	public static int testVar = 2;
	public static String testString = "YOLO!";

	public static void main(String[] args) {

		// Testing the decode method. Should have used some JUnit tests for this one...
		String test = " .... . -.--   .--- ..- -.. .";
		 System.out.println(test);
		
		 System.out.println(decode(test));
		
		 test = " .... . -.-- .--- ..- -.. . -.-.-- .-- .... . .-. . "
		 + "-.. .. -.. .- .-.. .-.. - .... . -... . .- - .-.. . ... "
		 + "--. --- ..--.. ";
		
		 System.out.println(decode(test));

		test = " . ";
		System.out.println(decode(test));

		test = "...---...";
		System.out.println(decode(test));

		test = ".-.. --- ...-";
		System.out.println(decode(test));

		test = ".-.. --- ...- . -- ..- ..-. ..-. .. -.";
		System.out.println(decode(test));

		test = ".-.. . .- --. ..- .   --- ..-.   ...- .. .-.. .-.. .- .. -. --- ..- ...   "
				+ ". ...- .. .-.. -.. --- . .-. ...   -- .- -. .. .- -.-. .- .-.. .-.. -.--   "
				+ "..- -. .. - . -..   ..-. --- .-.   ..-. .-. .. --. .... - . -. .. -. --.   "
				+ ".. -. ...- . ... - -- . -. - ...   .. -.   -. .- ..- --. .... - .. -. . ... ...";
		System.out.println(decode(test));
	}

	public static String decode(String morseCode) {

		String english = "";
		String currentLetter = "";
		boolean dontAddChar = false;
		boolean lockout = false;

		// *** ADD SOMETHING TO MANAGE SINGLE CHARACTERS OR WORDS AS INPUTS ***
		if (morseCode.length() == 1) {
			english = MorseCodeDictionary.morseCodeToEnglish(morseCode);
			return english;
		}

		for (int index = 0; index < morseCode.length(); index++) {

			dontAddChar = false;

			if (morseCode.charAt(0) == ' ' && lockout == false) { // Move index to a point above any spaces at the beginning of the String
				while (morseCode.charAt(index) == ' ') {
					index++;
				}
				lockout = true;
			}

			if (morseCode.charAt(index) == ' ' && index + 1 < morseCode.length()
					&& morseCode.charAt(index + 1) != ' ') { // Checking for single spaces - the separation between Morse letters
				english = english + MorseCodeDictionary.morseCodeToEnglish(currentLetter);
				currentLetter = "";
				dontAddChar = true;
			} else if (morseCode.charAt(index) == ' ') { // Checking for triple spaces - the separation between Morse words
				if (index + 1 < morseCode.length() && morseCode.charAt(index + 1) == ' ') {
					if (index + 2 < morseCode.length() && morseCode.charAt(index + 2) == ' ') {
						if (index + 3 >= morseCode.length()) { // Prevents additional spaces at the end of the string from being added by cutting the operation off early with a return
							english = english + MorseCodeDictionary.morseCodeToEnglish(currentLetter);
							return english;
						} else { // If triple space set isn't at the end of the morseCode String, adding the indicated space between words to the english return String
							english = english + MorseCodeDictionary.morseCodeToEnglish(currentLetter);
							english = english + " ";
							currentLetter = "";
							dontAddChar = true;
							index = index + 2;
						}
					} else { // Prevents double spaces at the end of the morseCode String from being included in the final english output String
						english = english + MorseCodeDictionary.morseCodeToEnglish(currentLetter);
						return english;
					}
				} else {
					english = english + MorseCodeDictionary.morseCodeToEnglish(currentLetter);
					return english;
				}
			} else if (index + 1 >= morseCode.length()) { // If the next space in the morseCode string is the end of the String, add the last letter then return - if this is left to the for loop it will fail to add the last letter to the english return String
				currentLetter = currentLetter + morseCode.charAt(index);
				english = english + MorseCodeDictionary.morseCodeToEnglish(currentLetter);
				return english;
			} else if (dontAddChar == false) { // If none of the above operations were conducted, continue building up our current Morse letter String
				currentLetter = currentLetter + morseCode.charAt(index);
			}
		}
		return english;
	}

}
