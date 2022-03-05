public class Solution {
    public int MaxSubArray(int[] nums) {

        // Loop over entire nums array to find the largest item in the list.
            // This will be our minimum sum threshold
            // Takes O(N) time
        // Loop over the entire nums array,
            // Add the current element to the sum
            // If the current sum is larger than the maximum value, maxSoFar = sum
            // If sum < largestValue, sum = 0 (might need to be if sum < 0)
        // return maxSoFar
        
        int maxValue = nums[0];
        for (int i = 1; i < nums.Length; i++) {
            if (nums[i] > maxValue) { maxValue = nums[i]; }
        }
        
        int sum = 0; // May need to be set to 0
        int maxSoFar = maxValue; // May need to be set to 0
        for (int i = 0; i < nums.Length; i++) {
            
            sum += nums[i];
            
            if (sum > maxSoFar) { maxSoFar = sum; }
            
            if (sum < 0) { sum = 0; }
        }
        return maxSoFar;
    }
}