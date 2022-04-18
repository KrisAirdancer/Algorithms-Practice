public class Solution {
    
    /// <summary>
    /// 
    /// IDEA: 
    /// Make two pointers (left and right) to loop over the input string s. Start right two indexes
    /// ahead of left to produce a window of length 3. Make an int[] of length 128 (ASCII) to store
    /// the character frequencies of the characters in the window between the pointers.
    /// 
    /// Loop until right reaches the end of the array. While looping, update the int[] as characters
    /// enter/exit the window. On each iteration (each time the window is shifted by one), check
    /// the int[] for duplicate values. Specifically, the int[] will store a 0 if the character
    /// represented by the index is not present or a value greater than 0 that represents the
    /// frequency of that character. When checking for duplicates, all that needs to be checked
    /// for are values greater than 1. If a substring with on duplicates is found increment a
    /// count variable.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N)
    /// Space Complexity: O(N)
    /// 
    /// OUTLINE:
    /// Initialize two poiners: left to 0 and right to zero
    /// Initialize int[] freq
    /// Loop to shift right to index 2 - update freq while doing this
    /// While rigth < s.Length
    ///     Check freq for values greater than 1 using a helper method
    ///         If true, do nothing; if false, count++
    ///     Decrement freq[s[left]]
    ///     Increment left
    ///     Increment right
    ///     Increment freq[s[right]]
    /// return count
    /// 
    /// </summary>
    public int CountGoodSubstrings(string s) {
        
        if (s.Length < 3) {
            return 0;
        }
        
        int count = 0;        
        int left = 0;
        int right = 0;
        
        int[] freq = new int[128];
        
        while (right < 2) {
            
            freq[s[right]]++;
            right++;
        }
        freq[s[right]]++;
        
        while (right < s.Length) {
            
            if (ContainsDups(freq) == false) {
                count++;
            }
            
            freq[s[left]]--;
            left++;
            right++;
            if (right < s.Length) {
                freq[s[right]]++;
            }
        }
        return count;
    }
    
    /// <summary>
    /// Returns true if any value in arr is greater than one; false otherwise.
    /// </summary>
    private bool ContainsDups(int[] arr) {
        
        foreach (int count in arr) {
            
            if (count > 1) {
                return true;
            }
        }
        return false;
    }
}