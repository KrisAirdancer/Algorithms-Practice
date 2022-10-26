class Solution {
    
    /**
     * IDEA:
     * - Sequentially divide n by each of the acceptable prime factors until 
     *   n is no longer divisible by them. That is, repeatedly divide by 2
     *   to remove all factors of n, then repeatedly divide by 3 to remove
     *   all factors of 3, and finally repatedly divide by 5 to remove all
     *   factors of 5. If the final result is 1, n's prime factors are limited
     *   to 2, 3, and 5; else, n has other prime factors.
     * 
     * PERFORMANCE:
     * - Time Complexity:
     * - Memory Complexity:
     * 
     * SOURCES:
     * - Used to understand the logic of the problem: https://leetcode.com/problems/ugly-number/solution/
     * 
     */
    public boolean isUgly(int n) {
        
        if (n <= 0) { return false; }
        
        while (n % 2 == 0) {
            n = n / 2;
        }
        
        while (n % 3 == 0) {
            n = n / 3;
        }
        
        while (n % 5 == 0) {
            n = n / 5;
        }
        
        return n == 1;
    }
}