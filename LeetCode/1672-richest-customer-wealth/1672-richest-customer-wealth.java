class Solution
{
    public int maximumWealth(int[][] accounts)
    {
        int maxWealth = 0;
        
        for (int customer = 0; customer < accounts.length; customer++)
        {
            int wealth = 0;
                
            for (int account = 0; account < accounts[customer].length; account++)
            {
                wealth += accounts[customer][account];
            }
            
            if (wealth > maxWealth) { maxWealth = wealth; }
        }
        
        return maxWealth;
    }
}