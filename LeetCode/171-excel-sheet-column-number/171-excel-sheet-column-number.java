class Solution {
    
    /**
     * IDEA:
     * - For each character in columnTitle (starting with the rightmost character), convert it into
     *   its ASCII value. From here, add 1 to the ASCII value to match the 1-based indexing used in this
     *   version of Excel. Then, multiply that value by 26^x, where x is the zero-based index of the 
     *   character in the list. Repeat this for each of the characters in columnTitle to get the final
     *   columnNumber.
     * 
     * PERFORMANCE:
     * - O(N) time complexity - We only loop over the input string once and all of the operations performed
     *   on the characters of the string are constant, O(1).
     * - O(N) memory complexity - we only store the input array and don't duplicate any data, so O(N).
     */
    public int titleToNumber(String columnTitle) {
        
        int columnNumber = 0;
        
        int multiple = 0;
        int letterIndex = columnTitle.length() - 1;
        
        while (letterIndex >= 0) {
            
            int ascii = (int)columnTitle.charAt(letterIndex);
            
            ascii -= 64; // Convert ASCII index to Excel column index: ASCII - 65 + 1 or ASCII - 64
            
            ascii *= (int)Math.pow(26, multiple);
            
            columnNumber += ascii;
            
            letterIndex--;
            multiple++;
        }
        
        return columnNumber;
    }
}