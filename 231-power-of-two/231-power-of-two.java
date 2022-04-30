class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Use bit manipulation to evaluate the input integer n. If n is a power of two
    /// it will have only a single "one" bit in it's binary representation.
    /// eg. 2^3 = 8 = 1000 (in binary)
    /// The quickest way to determine if a given integer has a single "one" bit in its
    /// binary representation is to compare it bitwise (&) to the integer that is
    /// one less than it. eg. If n = 8, then we compare 8 to 7 bitwise.
    /// If n is a power of two, then the integer one less than it will have a binary
    /// representation of all "one" bits, except for the bit that is in the same
    /// position as the "one" bit in n. eg. 8 = 1000 and 7 = 0111
    /// If we do a bitwise comparison of the two values, it will yield a value of zero.
    /// This means that if we perform a bitwise comparison in this way and get a value
    /// of zero, n is a power of two. If we get a non-zero value, it is not a power of two.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(1)
    /// Memory Complexity: O(1)
    /// 
    /// OUTLINE:
    /// Check if n is less than or equal to zero. If it is, return false. Negatives and zero cannot be a power of two.
    /// Return true if the bitwise comparision of n & n - 1 is zero, false otherwise.
    /// 
    /// REFERENCES
    /// - James Oravec posted a helpful explanation of why bitwise operations are O(1): https://stackoverflow.com/questions/36830801/can-i-assume-that-a-bitwise-and-operation-is-o1-if-so-why/36844240#36844240
    /// - I followed the explanations posted in these two posts to get to and understand my solution:
    ///     - 3. Bit Manipulation, https://leetcode.com/problems/power-of-two/discuss/1638704/C%2B%2B-EASY-TO-SOLVE-oror-All-INTERVIEW-APPROACHES-with-Detailed-Explanations
    ///     - Solution V - Bit Manipulation, https://leetcode.com/problems/power-of-two/discuss/1638961/C%2B%2BPython-Simple-Solutions-w-Explanation-or-All-Possible-Solutions-Explained
    /// 
    /// </summary>
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        return ((n & (n - 1)) == 0);
    }
}