public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Create two pointers (left and right), start one at index zero and one at the index
    /// that corresponds to k (in this case, k - 1). Shift the pointers over the input array
    /// nums until right reaches the end of the array. On each iteration, calculate the
    /// average value of the elements in the array. Store the average value and for each
    /// average that is taken, if it is larger than the currently stored value, update
    /// the stored value with the new one. After all sub-arrays have been checked (right
    /// reaches the end of the array), return the stoered average.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N)
    /// Memory Complexity: O(N)
    /// 
    /// OUTLINE: 
    /// Initialize left and right pointers to zero
    /// Loop to place right pointer in correct starting position
    ///     While looping, sum up the values passed over
    /// Initialize currentMaxAve to zero (there should be a better value for this)
    /// Take the average of the current sum and store it in currentMaxAve
    /// Loop over nums array while right < nums.Length
    ///     Subtract left from sum
    ///     Increment left
    ///     Increment right
    ///     Add right to sum
    ///     Take average of sum, if greater than currentMaxAve, update currentMaxAve
    /// Return currentMaxAve
    /// 
    /// REFERENCES:
    /// Solution copied from here: https://leetcode.com/problems/maximum-average-subarray-i/discuss/105432/Java-solution-Sum-of-Sliding-window
    /// </summary>
    public double FindMaxAverage(int[] nums, int k) {
        
        int sum = 0;
        int maxSum = 0;
        
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        maxSum = sum;

        for (int i = k; i < nums.Length; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        return (double)maxSum / (double)k;
    }
}