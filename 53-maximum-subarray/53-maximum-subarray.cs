public class Solution {
    
    /// <summary>
    /// If the current sum is below zero, it means that either...
    /// 1) all future sub arrays will be negative and we need to return the largest negative value (eg. -1 instead of -3)
    /// or
    /// 2) all sub arrays up until that point will be smaller than at least one sub array after it (even a single
    /// positive value or zero will be larger), and adding the subsequent positive numbers to the current negative sum
    /// will yield a smaller sum than if we started over with the sub array that begins immediately after the current
    /// value. That is, if sum is negative and there are positive values ahead of our current position in the array,
    /// summing the values ahead of our current position will yield a sub array with a larger sum than the sub array
    /// comprised of the current negative sum and the following positive sum.
    ///
    /// eg. [-1, -2, 1, 1], sub array [-1, -2], yields -3 and the whole thing yields -1, but [1, 1] yields 2. So when
    /// we hig -1 (index 0), drop the current sum, get a sum of -1, drop that sum again, and start summing from there on.
    ///
    /// eg. [-1, -2, -1, -1], in this case, we will set -1 to be the maxSoFar value before we rest the sum to 0 and will
    /// eventually return -1. The largest sum in the array.
    /// </summary>
    public int MaxSubArray(int[] nums) {
        
        int sum = 0;
        int maxSoFar = nums[0]; // Largest at start is first item in list
        for (int i = 0; i < nums.Length; i++) { // Loop over all elements of the list
            
            // Add each element to the running sum
            sum += nums[i];
            
            // If the current sum is larger than the largest sum found thus far, update current largest sum
            if (sum > maxSoFar) { maxSoFar = sum; }
            
            // See notes in method doc for how this works
            if (sum < 0) { sum = 0; }
        }
        return maxSoFar;
    }
}