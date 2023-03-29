class Solution:
    def isPalindrome(self, s: str) -> bool:

        left = 0
        right = len(s) - 1

        while left < right:
            
            while left < right and not self.isAlphaNumeric(s[left]):
                left += 1
            while right > left and not self.isAlphaNumeric(s[right]):
                right -= 1
            
            if s[left].lower() != s[right].lower():
                return False
            
            left += 1
            right -= 1
        
        return True

    
    def isAlphaNumeric(self, c) -> bool:
        return (ord(c) >= ord('A') and ord(c) <= ord('Z')
             or ord(c) >= ord('a') and ord(c) <= ord('z')
             or ord(c) >= ord('0') and ord(c) <= ord('9'))

# OUTLINE & NOTES
# > A simple solution would be to make two pointers, one at each end of the string and loop towards the center of the string.
# >> On each step, compare the characters at each pointer to each other. If they are NOT the same, return false; otherwise, continue until
# >> the two pointers pass each other (not equal - if the string has an even number fo characters, the pointers will never be equal and will
# >> pass each other on what should be the final step and if the string has an odd number of characters, the last comparision will be skipped
# >> or will require a special case to handle it because == will stop the loop before the comparison happens). If you reach this point, the
# >> string is a palindrome.
# PSEUDO CODE
# Instantiate two pointers: left = 0 and right = len(s)
# Loop: While left is less than or equal to (<=) right,
#     If s[left] != s[right], return false
#     left += 1
#     right -= 1
# Return true
# RESTART
# > Loop over the input string with two pointers, one from the beginning and one from the end. To skip whitespace and special characters, use a helper function to check if the current character is a special character or not. If it is (or if it isn't alphanumeric), skip the current character by stepping the pointer forward one index. Continue this process until both pointers point to an alphanumeric character. Then, compare the characters at the two pointers. If the characters are not the same, return True, the string is not a palindrome; otherwise, continue until the left pointer is grater than the right poitner. If this point is reached, then the string is a palindrome, return True.
# OUTLINE
# Instanitate a left and right pionter for the string
# Loop: While left pointer is less than or equal to right pionter,
#     Loop: While s[left] is not alphanumeric,
#         left++
#     Loop: While s[right] is not alphanumeric,
#         right--
#     If left.toLower != right.toLower, <- Make sure to check same case
#         return False
#     left++
#     right--
# Return True