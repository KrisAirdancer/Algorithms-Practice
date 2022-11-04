/**
 * IDEA:
 * - Loop over nums starting at index left and go until index right. On each loop,
 *   add the value at nums[i] to the result. Return the result.
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