public class Solution {
    
    public int MaxSubArray(int[] nums) {
        
        // int maxValue = nums[0];
        // for (int i = 1; i < nums.Length; i++) {
        //     if (nums[i] > maxValue) { maxValue = nums[i]; }
        // }
        
        int sum = 0;
        // int maxSoFar = maxValue;
        int maxSoFar = nums[0];
        for (int i = 0; i < nums.Length; i++) {
            
            sum += nums[i];
            
            if (sum > maxSoFar) { maxSoFar = sum; }
            
            if (sum < 0) { sum = 0; }
        }
        return maxSoFar;
    }
}