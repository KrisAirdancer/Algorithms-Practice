class Solution
{
    // Extract all values from num and put them into an array usign % 10
    // Sort the array in ascending order
    // Sum the values in the sorted array from left to right
        // The first two values get multiplied by 10 before being added
    public int minimumSum(int num)
    {
        int[] digits = new int[4];
        
        for (int i = 0; num > 0; i++)
        {            
            digits[i] = num % 10;
            num /= 10;
        }
        
        Arrays.sort(digits);
        
        int sum = 0;
        
        for (int i = 0; i < digits.length; i++)
        {
            if (i == 0 || i == 1)
            {
                sum += digits[i] * 10;
            }
            else 
            {
                sum += digits[i];
            }
        }
        
        return sum;
    }
}