public class Solution {
    
    public int MaxSubArray(int[] nums) {
        
        int sum = 0;
        int maxSoFar = nums[0]; // Largest at start is first item in list
        for (int i = 0; i < nums.Length; i++) { // Loop over all elements of the list
            
            // Add each element to the running sum
            sum += nums[i];
            
            // If the current sum is larger than the largest sum found thus far, update current largest sum
            if (sum > maxSoFar) { maxSoFar = sum; }
            
            // By reseting the sum if it gets below
            if (sum < 0) { sum = 0; }
        }
        return maxSoFar;
    }
}