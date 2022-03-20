public class Solution {
    
    /// <summary>
    /// 
    /// Idea: Goal: O(N) time. Stepping over the array k times will be too slow. Need to
    /// calculate the correct index of each element based on k. Might be able to do this
    /// by looping over the input array (nums) and for each element, adding k to that
    /// element's index and then modding that by the length of the array.
    /// ex. (index + k) % nums.Length yields rotated index.
    /// 
    /// Outline:
    /// 
    /// Initialize new output array to the same length as nums
    /// Loop over nums,
    ///     Add nums[i] to rotatedArr[(index + k) % nums.Length]
    /// Copy rotated back into nums
    /// </summary>
    public void Rotate(int[] nums, int k) {
        
        int[] rotated = new int[nums.Length];
        
        for (int i = 0; i < nums.Length; i++) {
            rotated[(i + k) % nums.Length] = nums[i];
        }
        
        for (int i = 0; i < rotated.Length; i++) {
            nums[i] = rotated[i];
        }
    }
}