class Solution {
    
    /**
     * IDEA:
     * - Use the left shift operator and bitwise OR operator to check if the
     *   least significant bit is a 1. If it is, increment a counter.
     * - Essentially, loop over the input value n, check the least significant
     *   bit for a 1 useing |, then bit shift left once. Repeat.
     * 
     * PERFORMANCE:
     * - Time Complexity:
     * - Memory Complexity:
     * 
     */
    public int[] countBits(int n) {
        
        // Instantiate int[n + 1] bitCounts
        // Loop from 0 to n (inclusive on both ends)
            // Instantiate count = 0
            // Loop while current > 0
                // Use bitwise AND to check if the LSB bit is a 1 or 0
                // If LSB is 1, count++
                // Else, continue
                // Bit-shift to right by 1 bit
            // Add count to bitCounts[i] (bitCounts[i] = count)
        // Return bitCounts
        
        
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