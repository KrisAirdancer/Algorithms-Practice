package kyu6SmallKata;

import java.math.BigInteger;

/**
 * Is Prime Kata, Codewars
 * @author Chris Marston, March 2021
 * 
 * *** PASSED ***
 * 
 * CHALLENGE DESCRIPTION:
 * Define a function that takes one integer argument and returns logical value true or false depending on if the integer is a prime.
 * Per Wikipedia, a prime number (or a prime) is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * 
 * Requirements:
 * You can assume you will be given an integer input.
 * You can not assume that the integer will be only positive. You may be given negative numbers as well (or 0).
 * 
 * NOTE on performance:
 * There are no fancy optimizations required, but still the most trivial solutions might time out.
 * Numbers go up to 2^31 (or similar, depends on language version). Looping all the way up to n, or n/2, will be too slow.
 * 
 * Example:
 * is_prime(1) --> false
 * is_prime(2) --> true
 * is_prime(-1) --> false
 *
 */

public class IsPrimeKata {

	public static void main(String[] args) {
		
		// Testing isPrimeFermat
		System.out.println("isPrime with 1 returned: " + isPrimeFermat(1) );
		System.out.println("isPrime with 2 returned: " + isPrimeFermat(2) );
		System.out.println("isPrime with 3 returned: " + isPrimeFermat(3) );
		System.out.println("isPrime with -5 returned: " + isPrimeFermat(-5) );
		System.out.println("isPrime with 9973 returned: " + isPrimeFermat(9973) ); // Fails this test. Value to large.
		
		// Testing isPrimeLargeFermat
		System.out.println("isPrimeLittleFermat for 9973 returned: " + isPrimeLargeFermat(9973) );
		System.out.println("isPrimeLittleFermat for 17 returned: " + isPrimeLargeFermat(17) );
		System.out.println("isPrimeLittleFermat for 725269781 returned: " + isPrimeLargeFermat(725269781) );
		System.out.println("isPrimeLittleFermat for 2 returned: " + isPrimeLargeFermat(2) );

	}
	
	/**
	 * Returns true if input integer is prime and false otherwise. Tests for primality using the Fermat Primality Test.
	 * This theorm, in non-rigorous terms, returns 1 if the input value is prime and any other integer if the input
	 * value is a composite. Note that there are no false negatives (prime numbers being marked as composite)
	 * with Fermat's Little Theorm, but that there are false positives (composites being marked as prime). These values
	 * are known as pseudoprimes or Carmichael numbers. This method does not test for these values.
	 * 
	 * Fermat's Little Theorm: https://mathworld.wolfram.com/FermatsLittleTheorem.html
	 * Fermat's Little Theorm Mathematical Algorithm: https://en.wikipedia.org/wiki/Fermat_primality_test#Algorithm
	 * Pseudoprimes: https://en.wikipedia.org/wiki/Fermat%27s_little_theorem#Pseudoprimes
	 * 
	 * @param number An integer to be evaluated for primality.
	 * @return True if number is prime, false otherwise. Note the possibility of pseudoprimes.
	 */
	public static boolean isPrimeLargeFermat(int number) {
		
		if (number <= 1) {
			return false;
		}
		
		if (number == 2 || number == 3) {
			return true;
		}
		
		BigInteger num = new BigInteger("" + number);
		BigInteger exponent = new BigInteger("" + (number - 1) );
		BigInteger base  = new BigInteger("" + 2); 
		
		// The modPow method of BigInteger is effectively Fermat's Little Theorm when used correctly.
		BigInteger result = base.modPow(exponent, num);
		
		if (result.intValue() == 1) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns true if input integer is prime and false otherwise. Tests for primality using the Fermat Primality Test.
	 * This theorm, in non-rigorous terms, returns 1 if the input value is prime and any other integer if the input
	 * value is a composite. Note that there are no false negatives (prime numbers being marked as composite)
	 * with Fermat's Little Theorm, but that there are false positives (composites being marked as prime). These values
	 * are known as pseudoprimes or Carmichael numbers. This method does not test for these values.
	 * 
	 * *** This method can only handle smaller values as large values will result in an overflow. Use isPrimeLargeFermat
	 * for larger values.
	 * 
	 * Fermat's Little Theorm: https://mathworld.wolfram.com/FermatsLittleTheorem.html
	 * Fermat's Little Theorm Mathematical Algorithm: https://en.wikipedia.org/wiki/Fermat_primality_test#Algorithm
	 * Pseudoprimes: https://en.wikipedia.org/wiki/Fermat%27s_little_theorem#Pseudoprimes
	 * 
	 * @param number An integer to be evaluated for primality.
	 * @return True if number is prime, false otherwise. Note the possibility of pseudoprimes.
	 */
	public static boolean isPrimeFermat(int number) {
		
		if (number <= 1) {
			return false;
		}
		
		if (number == 2 || number == 3) {
			return true;
		}
		
		if ( (Math.pow(2, (number - 1) ) % number) == 1) {
			return true;
		}
		return false;
	}
	
}
