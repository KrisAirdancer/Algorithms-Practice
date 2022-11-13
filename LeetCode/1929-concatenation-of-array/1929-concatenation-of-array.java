class Solution {
    
    public int[] getConcatenation(int[] nums)
    {
        int[] doubledNums = new int[nums.length * 2];
        
        for (int i = 0; i < nums.length; i++) {
            
            doubledNums[i] = nums[i];
            doubledNums[i + nums.length] = nums[i];
        }
        
        return doubledNums;
    }
}