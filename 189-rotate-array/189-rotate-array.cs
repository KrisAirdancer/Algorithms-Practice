public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Reverse the entire array, then reverse the first k - 1 elements, and then
    /// reverse the last k to length - 1 elements. This will rotate the elements
    /// of the array.
    /// This will result in a higher constant O(N) time solution than the Out-Of-Place
    /// solution, but will be in-place, making the space complexity O(1) instead of O(N)
    /// in the Out-Of-Place solution.
    /// 
    /// OUTLINE:
    /// 
    /// Reverse the whole array (use two pointers at the head & tail to swap all elements)
    /// Reverse the first 0 to k - 1 elements
    /// Reverse the last k to length - 1 elements
    /// 
    /// </summary>
    public void Rotate(int[] nums, int k) { // IN-PLACE ROTATION
        
        // Ensure that the given k is less than the length of the array
        // but that the correct number of rotations are still completed
        k = k % nums.Length;
        
        // Reverse the entire array
        reverseArray(nums, 0, nums.Length - 1);
        
        // reverse first k - 1 elements
        reverseArray(nums, 0, k - 1);
        
        // reverse last half of array (from k to end of array)
        reverseArray(nums, k, nums.Length - 1);
    }
    
    /// <summary>
    /// Helper method for O(1) space solution.
    /// Reverses the given array between left (inclusive) and right (inclusive) indices.
    /// </summary>
    private static void reverseArray(int[] arr, int left, int right) {
        
        while (right >= left) { 
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            
            left++;
            right--;
        }
    }
    
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
    public void RotateNotInPlace(int[] nums, int k) { // NOT IN-PLACE ROTATION
        
        int[] rotated = new int[nums.Length];
        
        for (int i = 0; i < nums.Length; i++) {
            rotated[(i + k) % nums.Length] = nums[i];
        }
        
        for (int i = 0; i < rotated.Length; i++) {
            nums[i] = rotated[i];
        }
    }
}