class Solution
{
    public int finalValueAfterOperations(String[] operations)
    {
        int plusCount = 0;
        int minusCount = 0;
        
        for (int i = 0; i < operations.length; i++)
        {
            char first = operations[i].charAt(0);
            char last = operations[i].charAt(2);
            
            if (first == '+' || last == '+') { plusCount++; }
            if (first == '-' || last == '-') { minusCount++; }
        }
        
        return (plusCount) - (minusCount);
    }
}