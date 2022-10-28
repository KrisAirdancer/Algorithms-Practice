class Solution {
    
    /**
     * IDEA:
     * - The sum of the values in the array should end up being equal to the sum of all of the individual
     *   values from 0 to n only if all values are included in the array. Since we are guaranteed that one
     *   value won't be present in the array, we can conclude that the sum of the elements in the array
     *   will be x less than the sum of all values from 0 to n, where x is the missing value. Therefore, 
     *   we can sum the values in the array and the values from 0 to n, then compare the two results.
     *   The difference between the results will be the missing value.
     * 
     * PERFORMANCE:
     * - Time Complexity: O(N) - Where N is the number of elements in nums (nums.length or just n). Since
     *                    we only need to loop over nums once and all of the values from 0 to n once, we
     *                    loop 2N times. Thus, O(N).
     * - Memory Complexity: O(1) - This solution requires no backing data structures, copies of data, and
     *                      only a few primative variables. Thus, O(0) memory complexity.
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