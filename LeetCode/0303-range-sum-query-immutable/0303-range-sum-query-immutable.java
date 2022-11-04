/**
 * IDEA:
 * - Loop over nums starting at index left and go until index right. On each loop,
 *   add the value at nums[i] to the result. Return the result.
 * 
 * PERFORMANCE (of sumRange()):
 * - Time Complexity: O(N) - Where N is the difference between left and right. That is,
 *                    the length of the range to be summed.
 * - Memory Complexity: O(1) - Only a few variables need to be stored. No data needs to
 *                      be copied.
 * 
 * PERFORMANCE (of multiple calls to sumRange()):
 * - Time Complexity: O(N) - Still O(N). Since a single call to sumRange() is O(N), M calls
 *                    to sumRange() wil be M * O(N), which is just O(N).
 * - Memory Complexity: O(1) - Same as a single call to sumRange(). Only a few variables
 *                      need to be stored. No data needs to be copied.
 */
class NumArray {

    private int[] nums;

    public NumArray(int[] nums) {
        this.nums = nums;
    }
    
    public int sumRange(int left, int right) {
        
        int result = 0;
        
        for (int i = left; i <= right; i++) {
            result += this.nums[i];
        }
        
        return result;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */