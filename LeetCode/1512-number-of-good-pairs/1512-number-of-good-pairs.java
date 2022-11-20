class Solution
{
    public int numIdenticalPairs(int[] nums)
    {
        // If seen before, increment count
        
        int count = 0;
        
        HashMap<Integer, Integer> seenNums = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++)
        {
            int current = nums[i];
            
            if (seenNums.containsKey(current)) // Returns true if added; false if not added. THerefore, if false, we've seen the number before
            {
                int currentCount = seenNums.get(current);
                
                count += seenNums.get(nums[i]);
                seenNums.put(current, currentCount + 1);
            }
            else
            {
                seenNums.put(current, 1);
            }
        }
        
        return count;
    }
}