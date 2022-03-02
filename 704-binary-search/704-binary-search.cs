public class Solution {
    public int Search(int[] nums, int target) {
        
        return Search(nums, target, 0, nums.Length - 1);
    }
    
    private int Search(int[] nums, int target, int low, int high) {
        
        // Base case: low > high
        
        // Calculate midpoint
        
        // If target == nums[mid], return mid (mid is the element's index)
        // If target < nums[mid], search left partition
        // If target > nums[mid], search right partition
        
        // Else, return -1
        
        
        while (low <= high) {
            
            int mid = low + ((high - low) / 2);
            
            if (target == nums[mid]) {
                return mid;
                
            } else if (target < nums[mid]) {
                return Search(nums, target, low, mid - 1);
                    
            } else if (target > nums[mid]) {
                return Search(nums, target, mid + 1, high);
            }
        }
        return -1;
    }
}