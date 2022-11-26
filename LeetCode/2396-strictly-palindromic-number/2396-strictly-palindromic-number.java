class Solution
{
    public boolean isStrictlyPalindromic(int n)
    {
        boolean flag = true;
        
        for (int i = 2; i <= n - 2; i++)
        {
            if (!isPalindrome(Integer.toString(n, i))) { flag = false; }
        }
        
        return flag;
    }
    
    private boolean isPalindrome(String str)
    {
        // System.out.println(str);
        int left = 0;
        int right = str.length() - 1;
        while (left < right)
        {
            char charLeft = str.charAt(left);
            char charRight = str.charAt(right);
            
            if (charLeft != charRight) { return false; }
            
            left++;
            right--;
        }
        
        return true;
    }
}