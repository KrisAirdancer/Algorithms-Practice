public class Solution {
    
    /// <summary>
    /// 
    /// IDEA: 
    /// Loop over the array from front to back, when a zero is found, begin swapping
    /// it towards the end of the array. When each subsequent zero is found, add it to
    /// the group of zeros. As each non-zero element is encountered, swap the leftmost
    /// zero in the group of zeros with the number just after the group of zeros.
    /// Continue until the rightmost zero reaches the end of the array.
    /// 
    /// COMPLEXITY:
    /// Time: O(N) - loop over the entire array only once
    /// Space: O(1) - in-place
    /// 
    /// OUTLINE:
    /// Create two pointers, left and right - initialzie to zero
    /// Loop while right < nums.Length
    ///     If current value (right pointer) == 0,
    ///         Move right pointer right one index (right++)
    ///     Else,
    ///         Swap element at right index with element at left index
    /// </summary>
    public void MoveZeroes(int[] nums) {
        
        int left = 0;
        int right = 0;
        
        while (right < nums.Length) {
            
            if (nums[right] == 0) {
                right++;
            } else {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;
                
                left++;
                right++;
            }
        }
    }
}