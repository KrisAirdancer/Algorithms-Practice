class Solution {
    
    /**
     * OUTLINE:
     * - Clean input buy removing all whitespace and non-alphanumeric characters and making all chars lowercase.
     * - Make two pointers: left and right
     * - Loop over the array with while loop (while left <= right)
     *     - If both pointers point to the same element, continue
     *     - Else, return false
     * - Return false
     * 
     * PERFORMANCE: O(N) - b/c replaceAll likely runs in O(N) time and my while loop runs in O(1/2 N),
     * so overall, it has O(N) behavior.
     */
    public boolean isPalindrome(String s) {
        // This Regex will match anything other than the specified characters - it is a Negated Character Set in Regex
        String cleanS = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = cleanS.length() - 1;

        while (left <= right) {
            if (cleanS.charAt(left) != cleanS.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}