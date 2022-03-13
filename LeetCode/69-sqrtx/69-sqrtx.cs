public class Solution {
    
    /// <summary>
    /// Newton Solution
    /// Time complexity: O(logx)
    ///
    /// Source: https://leetcode.com/problems/sqrtx/discuss/25198/3-JAVA-solutions-with-explanation
    /// </summary>
    public int MySqrt(int x) {
        
        if (x == 0) { return 0; }
        
        long i = x;
        while (i > (x / i)) {
            i = (i + (x / i)) / 2;
        }
        return (int)i;
    }
}