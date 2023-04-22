class Solution:
    def characterReplacement(self, s: str, k: int) -> int:


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
# > 
# *** THINKING ***
# > Doing this on paper, for simple input strings, humans are fast at this. We quickly identify groups of repeated characters and replace the stuff in between them to get larger repeating substrings. This isn't particularly helpful for an alg.
# > For more complex strings with lower values of k, more thought is required. On paper, I stepped over the input string looking for characters that are flanked on both the left and right by the same character (Ex. ABA, B is flanked by two A's). When one of these was found, I replaced the middle character and looked to see (stepped outward in both directions) how far out that substring had become. I then looked for additional characters at the end of that substring that could be replaced in an effort to increase the length of the new string. We decrement k each time we make a replacement and continue while k > 0.
# >> I could, step over the string until I find an ABA pattern (pointer lands on A and prev = A and next = A), then perform a replacement of B -> A to get AAA. Then, start stepping outward with two pointers (prev goes left and next goes right) to look for non-A characters that can be replaced. Ex. BDC ABA ABBA -> BDC AAA ABBA, we then find the C (left) and the A (right), we update our longestSoFar variable b/c we found an A (and now have AAA A) and replace C with A to get (A AAA A), we continue until k == 0.
# >>> The issue with this is determining which character, left or right, to replace. If we have CAAABA and k = 0, we want to replace the B, not the C b/c it will give us a substring of length 5 instead of a substring of length 4.