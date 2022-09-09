class Solution {
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