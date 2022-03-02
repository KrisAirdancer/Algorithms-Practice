public class Solution {
    public int Search(int[] nums, int target) {
        
        return Search(nums, target, 0, nums.Length - 1);
    }
    
    private int Search(int[] nums, int target, int low, int high) {       
        
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