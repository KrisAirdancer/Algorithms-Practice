class Solution
{
    /**
     *IDEA:
     * - Loop over the array and count up all of the "+" and "-" signs (seaparately).
     *   Then, divide each count by two and subtract the "-" count from the "+" count.
     *   This should yield the final value.
     */
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