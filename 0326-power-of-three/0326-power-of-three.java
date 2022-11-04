class Solution {
    
    /**
     * IDEA:
     * - Apply logarithm rules to determine if n is a power of 3 or not.
     */
    public boolean isPowerOfThree(int n) {
        
        return ((Math.log10(n) / Math.log10(3)) % 1) == 0;
    }
}