class Solution
{
    public int minPartitions(String n)
    {
        int max = 0;
        
        for (int i = 0; i < n.length(); i++)
        {
            int current = n.charAt(i) - 48;
            
            if (current == 9) { return 9; }
            if (current > max) { max = current; }
        }
        
        return max;
    }
}