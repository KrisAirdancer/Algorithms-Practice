public class Solution {
    public int SearchInsert(int[] nums, int target) {
        
        return SearchInsert(nums, target, 0, nums.Length - 1);
    }
    
    public int SearchInsert(int[] nums, int target, int low, int high) {
        
        while (low <= high) {
            int midpoint = low + ((high - low) / 2);
            Console.WriteLine($"low: {low}, high: {high}, midpoint: {midpoint}");
            if (nums[midpoint] == target) {
                return midpoint;

            } else if (nums[midpoint] > target) { // Search left partition
                return SearchInsert(nums, target, 0, midpoint - 1);

            } else if (nums[midpoint] < target) { // Search right partition
                return SearchInsert(nums, target, midpoint + 1, high);
            }
        }
        return FindInsertionPoint(nums, target);
    }
    
    public int FindInsertionPoint(int[] nums, int target) {
        
        int i = 0;
        while (i < nums.Length && target > nums[i]) { i++; }
        return i;
    }
}