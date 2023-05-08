class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:

        # If s2 is shorter than s1, it is not possible for s2 to contain a permutation of s1.
        if len(s2) < len(s1):
            return False

        s1Counts = [0] * 26
        s2Counts = [0] * 26

        # Populate the character counts for s1 in s1Counts.
        for character in s1:
            s1Counts[ord(character) - 97] += 1
        
        left = 0
        right = 0

        # This loop steps the right pointer forward to set the size of our window to the lenght of s1.
        while right < len(s1):
            s2Counts[ord(s2[right]) - 97] += 1
            right += 1

        while right < len(s2):

            if s2Counts == s1Counts:
                return True

            # This step adds the right element to the window. right was updated on the previous iteration.
            s2Counts[ord(s2[right]) - 97] += 1 # Add right element to window
            # This step removes the left element from the window. left will be updated on this iteration.
            s2Counts[ord(s2[left]) - 97] -= 1 # Remove left element from window
            left += 1
            # This change to right will not be realized (s2Counts won't be updated) until the next iteration.
                # This means, that we will fail to check the last window in each input.
            right += 1 # Have to do this last b/c we need the loop to do bounds checking.
        
        # This check is needed b/c the above loop is failing to check the last window for validity.
        if s2Counts == s1Counts:
            return True
        
        return False
        
# ***** IDEAS *****
# IDEA 1
# > Put all of the characters from s1 and their counts into a dictionary. Then, use a sliding window over s2 to determine if the window has the same characters and character frequencies of s1.
# IDEA 2
# Store the counts of each character in s1 in an array of length 26 such that the index in the array is the ASCII value of the character minus 97.
# > Ex. a is at index 0 b/c a - 97 = 97 - 97 = 0 and z is at index 25 b/c 122 - 97 = 25 (ASCII for z is 122)
# Once we've created our s1Counts array, we can implement a sliding window over s2. The sliding window should be the length of s1 and should not change in size. On each iteration (stepping of the window forward), we update an array s2Counts that is structured the same as s1Counts but contains the counts of the characters in the window. On each iteration, we can check to see if we've found a permutation of s1 as a substring of s2 by comparing the two arrays. 
# The trick here is that permutations contain all of the same characters at the same frequency as each other.
# Another trick that we are using here is that we can compare lists (arrays) directly in Python and it will compare their contents
# > Ex. For s1 = [1, 2, 3] and s2 = [1, 2, 3], s1 == s2 resolves to True.
# 
# ***** NOTES *****
# > If s2 is shorter than s1, return false b/c s1 cannot fit inside s2.
#
# ***** OUTLINE *****
# OUTLINE 1
# Initialize two arrays of all zeros of length 26
# Loop over s1 and populate s1Counts
# Initialize left and right pointers to 0 (on s2)
# Loop over s2 with right pointer until right is at s1.length - 1 (this to set the width of the window)
#     While doing this, update the s2Counts array
# Loop to step the window forward (loop until right is at end of s2)
#     Increment count of s2[right] in s2Counts
#     If s2Counts == s1Counts, return True
#     Decrement count of s2[left] in s2Counts
#     Left++
#     Right++
# 
# OUTLINE 2
# s1Counts = [0, 0, ...]
# s2Counts = [0, 0, ...]
# for charcater in s1,
#     s1Counts[character - 97] += 1
# left = 0
# right = 0
# s2Counts[s2[right]] += 1
# while right < s1.length - 1,
#     right++
#     s2Counts[s2[right]] += 1
# If s2Counts == s1Counts, return True
# while right < s2.length,
#     right++ # Step right forward
#     s2Counts[s2[right]] += 1 # Add new element on the right
#     s2Counts[s2[left]] -= 1 # Remove leftmost element
#     left += 1 # Step left forward
#     If s2Counts == s1Counts, return True
# Return False












