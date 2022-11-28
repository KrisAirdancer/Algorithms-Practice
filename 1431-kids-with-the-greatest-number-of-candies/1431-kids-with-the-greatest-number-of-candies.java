class Solution
{
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies)
    {
        List<Boolean> result = new ArrayList<Boolean>();
        int max = 0;
        
        for (int i = 0; i < candies.length; i++)
        {
            if (candies[i] > max)
            {
                max = candies[i];
            }
        }
        
        for (int i = 0; i < candies.length; i++)
        {
            if (candies[i] + extraCandies >= max)
            {
                result.add(i, true);
            }
            else
            {
                result.add(i, false);
            }
        }
        
        return result;
    }
}