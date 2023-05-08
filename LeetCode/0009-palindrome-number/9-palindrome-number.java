class Solution {
    
    /**
     * Convert integer to a string using toString()
     * Make two pointers: one left and one right
     * Step over the string from outside in using charAt() and compare values
     * If ever the values don't match, return false
     */
    public boolean isPalindrome(int x) {
        
        String digits = Integer.toString(x);
        
        int left = 0;
        int right = digits.length() - 1;
        
        while (left < right) {
            if (digits.charAt(left) != digits.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}