class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        counts = {} # A dictionary to hold the counts of the characters currently in the window. Ex. { A:2, B:1, ...}
        longestSoFar = 0
        left = 0
        right = 0

        windowLength = ( right - left + 1 ) # Setup a variable to keep track of the length of the window. Not strictly necessary, but helps with readability.

        while right < len(s):
            # Update the count for the character being added to the window (character at right pointer) (the character stepped to by the right++ @ the bottom of this loop on the last iteration)
            counts[s[right]] = counts.get(s[right], 0) + 1 # In .get(key, default), "default" is the value that will be returned if the key is not in the dict.

            # Check that the window is valid (if windowLength - most common char in window is greater than k, we need to shrink the window)
            # This loop only runs if the window is NOT valid
            while ( windowLength - max( counts.values() ) ) > k:
                counts[s[left]] -= 1 # Remove the left element from the window
                left += 1 # Move the left side of the window forward by one
                windowLength -= 1 # Update the window length variable

            # Update the current maximum length if our window is longer than the current maximum
            if ( windowLength > longestSoFar):
                longestSoFar = windowLength

            right += 1 # Expand the window on the right side by one
            windowLength += 1 # Update the window length variable

        return longestSoFar
             
# *** INPUTS ***
# > A string of UPPERCASE English letters (essentially a subset of ASCII).
# > An integer (k) indicating the maximum number of character replacements we are allowed to perform.
# >> k may be zero - thus we need to also be able to find the longest EXISTING repeating substring in the input string.
# *** OUTPUTS ***
# > Need to return the length of the longest possible substring that contains only a single repeating character.
# >> Ex. For "ABAB" and k = 2, we can replace the two A's with B's or the two B's with A's to get either AAAA or BBBB. Either way, we return 4, the length of the new longest string.
# >> Ex. For "AABABBA" and k = 1, we can replace the middle A with a B to get AABBBBA, which contains the substring BBBB and has a length of 4. Since it is the longest substring of repeating characters that can be made from the input parameters, we return its length: 4.
# > We are able to replace any character in the string with any other chareacter. We may do this k times.
# *** Brute Force Solution (BFSol) ***
# > The most basic solution is to check every substring in the input string. We can loop over the input string and for every possible substring, we will check to see if we can make the necessary replacements to make the characters of that substring into the same character.
# >> This solution is not great b/c it will take O(N^2) time to complete.
# *** NeetCode Solution ***
# > Use an expanding/contracting window solution.
# > We use two pointers, a left and right, to keep track of our window. Both pointers start at the beginning of the string. We increment the right pointer while our window is still valid and our left pointer when our window is invalid. In this way, we expand our window until it is no longer valid, then shrink it until it becomes valid once again.
# > A valid window is one that has,
# >> windowLength - count(max(chars-in-hashmap)) <= k
# >> That is, while the length of the window less the count of the most common character in the window is less than or equal to the replacement maximum (k), we will be able to replace all of the other characters in the substring to get a fully repeating sequence of characters the length of the window.
# > To do this, we will use a HashMap of character counts. Specifically, we'll use the HashMap to track the counts of the characters currently in the sliding window. As we add characters to the window, we will increment their value in the HashMap. As we remove characters from the window, we will decrement their count in the HashMap.
# >> This will allow us to, on each iteration (for each window), step over the HashMap and find the character with the largest value. This character will be the the most common character in the window. From here, we can calculate the number of replacements that need to be made - the equation above.
# > With all of this, we can slide our window over the entire input string until right reaches the end, at which point we can simply return the longest valid substring that we've seen so far (will need to keep track of this in a variable).
# > COMPLEXITY/PERFORMANCE
# >> Time Complexity: O(N) - Technically O(26 * N) b/c we have to loop over the HashMap for every character in the input string. But Big O drops constants, so we reduce to O(N).
# >> Memory Complexity: O(N) - We only need to store the input array and the HashMap, so O(2 * N), but, again, we drop constants, so we reduce to O(N).
# PSEUDO CODE
# Initialize a Dictionary counts
# Initialize longestSoFar
# Initialize two pointers: left = 0 and right = 0
# Initialize longestSoFar = 1
# Set Dict[s[right]] = 1
# Loop: While right < s.length,
#     windowLength = (right - left)
#     mostCommonChar = max(counts).value
#     Calculate replacements = windowLength - mostCommonChar
#     Loop: While replacements <= k
#         If windowLength...
#         right++
#         Update replacements = (right - left) - max(counts).length
# *** THINKING ***
# > Doing this on paper, for simple input strings, humans are fast at this. We quickly identify groups of repeated characters and replace the stuff in between them to get larger repeating substrings. This isn't particularly helpful for an alg.
# > For more complex strings with lower values of k, more thought is required. On paper, I stepped over the input string looking for characters that are flanked on both the left and right by the same character (Ex. ABA, B is flanked by two A's). When one of these was found, I replaced the middle character and looked to see (stepped outward in both directions) how far out that substring had become. I then looked for additional characters at the end of that substring that could be replaced in an effort to increase the length of the new string. We decrement k each time we make a replacement and continue while k > 0.
# >> I could, step over the string until I find an ABA pattern (pointer lands on A and prev = A and next = A), then perform a replacement of B -> A to get AAA. Then, start stepping outward with two pointers (prev goes left and next goes right) to look for non-A characters that can be replaced. Ex. BDC ABA ABBA -> BDC AAA ABBA, we then find the C (left) and the A (right), we update our longestSoFar variable b/c we found an A (and now have AAA A) and replace C with A to get (A AAA A), we continue until k == 0.
# >>> The issue with this is determining which character, left or right, to replace. If we have CAAABA and k = 0, we want to replace the B, not the C b/c it will give us a substring of length 5 instead of a substring of length 4.