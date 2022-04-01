public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Create two pointers to loop over the string. Keep the first pointer (left) at
    /// the beginning of the list and move the second (right) to the right one
    /// character at a time. For each character visited by right (including the
    /// one that it starts on), add it to a Dictionary. If an element visited by
    /// right is already in the Dictionary, increment left by one (move it right)
    /// and store the Count of the Dictionary in a variable largestSoFar. Continue
    /// until right reaches the end of the string, then return largestSoFar.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N)
    /// Memory Complexity: O(N)???
    /// 
    /// OUTLINE: 
    /// Initialize right and left pointers to zero
    /// Initialize longest
    /// Instantiate chars as an empty Dictionary 
    /// Loop over string s
    ///     If right char is not in chars,
    ///         Add it to chars
    ///         If chars.Count > longest,
    ///             Set longest to chars.Count
    ///     If right char IS in chars,
    ///         Remove left char
    /// return longest
    /// 
    /// </summary>
    public int LengthOfLongestSubstring(string s) {

        int left = 0;
        int right = 0;
        int longest = 0;
        
        HashSet<char> chars = new HashSet<char>();
        
        while (right < s.Length) {
            
            if (!chars.Contains(s[right])) {
                chars.Add(s[right]);
                if (chars.Count > longest) { longest = chars.Count; }
                right++;
            } else {
                chars.Remove(s[left]);
                left++;
            }
            // right++;
        }
        return longest;
    }
}