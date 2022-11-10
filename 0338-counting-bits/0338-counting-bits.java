class Solution {
    
    /**
     * IDEA:
     * - Use the left shift operator and bitwise AND operator to check if the
     *   least significant bit is a 1. If it is, increment a counter. When the
     *   current value has been fully evaluated (it becomes 0), add the count
     *   to the next open position in an array, clear the counter, and repeat.
     * 
     * PERFORMANCE:
     * - Time Complexity: O(NlogN) - Looping from 0 to n is linear, O(N). The number
     *                    of bits in each of the valuse from 0 to n grows at 
     *                    a logarithmic rate. So, for each additional N, where
     *                    N == n, we loop an additional log(N) times. Therefore, 
     *                    since we have an O(logN) loop inside an O(N) loop, we have
     *                    an overall time complexity of O(logN) * O(N), which is
     *                    just O(NlogN).
     * - Memory Complexity: O(N) - Because we are storing an array of length n,
     *                      we need O(N) space, where N == n. So, O(N).
     * 
     * OUTLINE:
     * - Instantiate int[n + 1] bitCounts
     * - Loop from 0 to n (inclusive on both ends)
     *     - Instantiate count = 0
     *     - Loop while current > 0
     *         - Use bitwise AND to check if the LSB bit is a 1 or 0
     *         - If LSB is 1, count++
     *         - Else, continue
     *         -  Bit-shift to right by 1 bit
     *     - Add count to bitCounts[i] (bitCounts[i] = count)
     *     - Reset count to 0
     * - Return bitCounts
     */
    public int[] countBits(int n) {    
        
        int[] bitCounts = new int[n + 1];
        bitCounts[0] = 0;
        
        for (int i = 0; i <= n; i++) {
            
            int count = 0;
            int current = i;
            
            while (current > 0) {
                
                if ((current & 1) == 1) {
                    count++;
                }
                current = current >> 1;
            }
            bitCounts[i] = count;
            count = 0;
        }
        
        return bitCounts;
    }
}