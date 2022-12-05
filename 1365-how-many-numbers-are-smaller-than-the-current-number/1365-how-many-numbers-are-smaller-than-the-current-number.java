class Solution
{
    public int[] smallerNumbersThanCurrent(int[] nums)
    {
        // nums contains values from 0 to 100, so 101 unique values
        int[] counts = new int[101]; // int[] arrays' elements default to 0
        
        // Count the number of occurances of each of the vlaues in the nums array
        for (int num : nums)
        {
            counts[num]++;
            System.out.println("num: " + num + ", count: " + counts[num]);
        }
        System.out.println("----- BREAK -----");
        
        // Generate a running sum for all values in the array. That is, each entry after this step will be the sum of the number of occurances of the value at that index plus all values less than that index
        for (int i = 1; i < counts.length; i++)
        {
            counts[i] = counts[i] + counts[i - 1];
            System.out.println("i: " + i + ", counts[i]: " + counts[i]);
        }
        System.out.println("----- BREAK -----");
        
        int[] finalCounts = new int[nums.length];
        
        // Pull only the values in counts that corespond to a value in nums
        for (int i = 0; i < nums.length; i++)
        {
            if (nums[i] == 0)
            {
                continue;
            }
            else
            {
                finalCounts[i] = counts[nums[i] - 1];   
            }
            // System.out.println("i: " + i + ", nums[i]: " + nums[i] + ", counts[nums[i]]: " + counts[nums[i] - 1]);
        }
        
        return finalCounts;
    }
}