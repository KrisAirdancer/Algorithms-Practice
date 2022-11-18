class Solution
{
    public int[] shuffle(int[] nums, int n)
    {
        int[] shuffled = new int[2 * n];
        
        for (int i = 0; i < n; i++)
        {
            shuffled[i * 2] = nums[i];
            System.out.println("i: " + i + ", nums[i]: " + nums[i]);
            shuffled[(i * 2) + 1] = nums[n + i];
            System.out.println("i: " + i + ", nums[n + i]: " + nums[n + i]);
        }
        
        return shuffled;
    }
}