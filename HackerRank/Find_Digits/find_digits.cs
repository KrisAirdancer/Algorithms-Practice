using System;

/// <summary>
/// HackerRank Find Digits
/// </summary>
public class find_digits

{
    public static int findDigits(int n) {

        // Duplicate n
        // Separate the digits of n into an array list using while loop (while n != 0)
        // Use n mod 10 to remove each digit
        // Initialize int count = 0;
        // Loop over array using for loop and check if each digit evenly dvivides n
        // If current digit == 0, continue;
        // If digit divides n, count++

        int num = n;
        List<int> digits = new List<int>();

        while (num != 0) {
            digits.Add(num % 10);
            num = num / 10;
        }

        int count = 0;

        for (int i = 0; i < digits.Count; i++) {
            int digit = digits[i];

            if (digit == 0) { continue; }
            if (n % digit == 0) { count++; }
        }
        return count;
    }
}
