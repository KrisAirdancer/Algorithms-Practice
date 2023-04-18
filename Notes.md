class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        # if len(s) == 0: # TODO: Might not need to check for this. Solution might handle that natively.
        #     return 0
        
        longestSoFar = 0
        left = 0
        right = 0

        currentElements = set()
        currentElements.add(s[left])

        while right < len(s) - 1:
            current = s[right + 1]

            while current in currentElements:
                # Remove left
                # Increment left
                currentElements.remove(s[left])
                left += 1
            # Add right to set
            currentElements.add(right)
            # Update longestSoFar
            if (right - left) > longestSoFar:
                longestSoFar = (right - left)
            right += 1
        # Return longestSoFar
        return longestSoFar

# IDEAS
# > Loop over the input array with two pointers: left and right. Both start at zero. Keep a set of all elenments curently in the window. On each iteration of the loop, check if s[right + 1] is in the currentElements set. If it is, step the entire window forward by one (right++ and left++). If it isn't, step the right pointer forward by one (right++). Loop until right reaches the end of the list. Return right - left + 1.
# >> The idea here is that we only care about the largest substring, so we can ignore any that are smaller than the current maximum. Thus, if we keep our window the size of the largest substring we've seen thus far, we can avoid having to calculate all possible substrings - O(N^2) - and instead just search for substrings that are larger than the current maximum in linear - O(N) - time.
# >> ERROR: This solution doesn't quite work. It fails when there are duplicates added to the set. We need to be able to keep duplicates in the list of currentElements so that we can ensure that we don't end up counting the same element more than once. This solution is close, but not quite there.
# OUTLINE
# If s.length == 0,
#     Return 0
# Instantiate left = 0 and right = 0
# Instantiate currentElements Set()
# Loop: While right < s.length,
#     If s[right + 1] is NOT in currenElements, // Expand window to make a larger set
#         right++
#         currentElements.add(s[right])
#     Else, // Step entire window forward by one
#         currentElements.remove(s[left])
#         currentElements.add(s[right])
#         right++
#         left++
# Return (right - left + 1)
# UPDATE - Via NeetCode Solution
# > The above solution is very close, but it is not quite there. The issue is that I was trying to keep duplicates in the set AND that I was trying to keep the lenght of the window at a minimum length of the longest substring I'd found thus far.
# > An alternative is to grow AND shrink the size of the window based as we go and just keep track of the longest window that we've seen in a separate variable.
