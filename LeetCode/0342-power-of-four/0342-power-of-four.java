class Solution {
    
    /**
     * IDEA:
     * - Since n = 4^x returns true, we can take log4(n) to get the 
     *   exponent (power) to which we would have to raise 4 to get n.
     *   We can then check to see if the result is an integer. If it
     *   is, n is a power of 4; otherwise, it is not.
     * 
     * PERFORMANCE:
     * - Time Complexity: O(1) - Constant time b/c the log10() function
     *                    will always run in O(1) and we have no loops.
     * - Memory Complexity: O(1) - Only need to store a single constant.
     *                      And even that is optional - doing so for
     *                      readability.
     */
    public boolean isPowerOfFour(int n) {
        
        double result = Math.log10(n) / Math.log10(4);
        
        return (result % 1) == 0;
    }
}