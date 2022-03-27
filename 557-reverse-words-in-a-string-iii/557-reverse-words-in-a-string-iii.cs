public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Convert the string to a char[] to allow for low-cost manipulation.
    /// Loop over the char[] from left to right, leave a pointer behind,
    /// just after the most recent piece of whitespace. When the right pointer
    /// finds the next piece of whitespace, reverse the elements between the
    /// two pointers (including the character at the left pointer). Continue
    /// until the entire char[] is processed, then convert the char[] into
    /// a string and return it.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N)
    /// Memory Complexity: O(1)
    /// 
    /// OUTLINE:
    /// Initialize two pointers: left = 0, right = 0
    /// Convert string into char[]
    /// Loop while right < char[].Length
    ///     If right pointer on whitespace,
    ///         Reverse chars between left and right
    ///         Set left = right + 1 (character just after the whitespace)
    ///     Increment right pointer
    /// Reverse final word in string (won't get caught due to no trailing whitespace)
    /// Convert char[] into string
    /// Return string
    /// 
    /// QUESTIONS:
    /// - What do we do about ending punctuation? Does it stay at the end
    /// of the string when we reverse it, or does it get reversed with the
    /// last string in the word?
    /// </summary>
    public string ReverseWords(string s) {
        
        int left = 0;
        int right = 0;
        
        char[] chars = s.ToCharArray();
        
        while (right < chars.Length) {
            
            if (chars[right] == ' ') {
                ReverseChars(chars, left, right - 1);
                left = right + 1;
            }
            right++;
        }
        
        ReverseChars(chars, left, right - 1);
        
        return new string(chars);
    }
    
    /// <summary>
    /// Reverses the characters in a given char[] between the
    /// specified indices. Left and right indices are inclusive.
    /// </summary> 
    private void ReverseChars(char[] chars, int left, int right) {
        
        while (left < right) {
            
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            left++;
            right--;
        }
    }
}