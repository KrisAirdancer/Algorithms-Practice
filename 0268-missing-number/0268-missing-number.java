class Solution {
    
    /**
     * IDEA:
     * - 
     * 
     * PERFORMANCE:
     * - Time Complexity:
     * - Memory Complexity: 
     * 
     */
    public int missingNumber(int[] nums) {
        
        int expectedSum = 0;
        int actualSum = 0;
            
        // Generate expected sum from nums.length
        for (int i = nums.length; i > 0; i--) {
            expectedSum += i;
        }
        
        // Gnerate actual sum by looping over nums
        for (int num : nums) {
            actualSum += num;
        }
        
        // Compare expectedSum to actualSum
        return Math.abs(expectedSum - actualSum);
    }
}