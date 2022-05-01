public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Loop over the input integer n and check each position for a 1. If a 1 is encountered,
    /// increment a count. After iteration, return the count. Use the right bit shift operator, 
    /// >>, to cycle through the bits.
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
    /// </summary>
    public int HammingWeight(uint n) {
        
        int count = 0;
        
        while (n > 0) {
            
            if ((n & 1) == 1) {
                count++;
            }
            
            n = (n >> 1);
        }
        
        return count;
    }
}