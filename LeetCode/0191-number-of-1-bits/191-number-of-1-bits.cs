public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Loop over the input integer n and check each position for a 1. If a 1 is encountered,
    /// increment a count. After iteration, return the count. Use the right bit shift operator, 
    /// >>, to cycle through the bits.
    /// 
    /// Chose not to use the "fancy" bit manipulation trick of comparing n and n - 1 bitwise.
    /// This solution might be faster than the one I implemented, but it is more confusing
    /// and both are O(1) time, so there is no real gain. However, the "fancy"/"faster"
    /// option is less maintainable because it is more difficult to understand and it isn't
    /// faster in any meaningful way. Maybe for an algs competiton, but not for software or
    /// other projects.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(1) b/c always looping over 32 bits
    /// Memory Complexity: O(1)
    /// 
    /// OUTLINE:
    /// Declare int count = 0
    /// Loop while n is greater than zero,
    ///     If n & 1 == 1, increment count
    ///     Shift the bits in n to the right by one (n = n >> 1)
    /// Return count
    /// 
    /// REFERENCES: 
    /// Explanation of the "fancy" method: https://leetcode.com/problems/number-of-1-bits/discuss/1044775/Python-n-and-(n-1)-trick-%2B-even-faster-explained
    /// Worked through this solution to understand the solution and implement my solution: https://leetcode.com/problems/number-of-1-bits/discuss/1044799/C%2B%2B-or-Bit-Manipulation-or-4-Approaches-or-Beats-100-0ms-O(1)
    /// 
    /// </summary>
    public int HammingWeight(uint n) {
        
        int count = 0;
        
        while (n > 0) {
            
            // If the bit in the first (right most) position is a 1
            if ((n & 1) == 1) {
                count++;
            }
            
            // Shift the bits to the right by one
            n = (n >> 1);
        }
        
        return count;
    }
}