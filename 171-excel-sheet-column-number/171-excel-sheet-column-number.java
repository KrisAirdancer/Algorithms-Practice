class Solution {
    public int titleToNumber(String columnTitle) {
        
        int columnNumber = 0;
        
        int multiple = 0;
        int letterIndex = columnTitle.length() - 1;
        
        while (letterIndex >= 0) {
            
            int ascii = (int)columnTitle.charAt(letterIndex);
            System.out.println("ascii: " + ascii);
            
            ascii = ascii - 65 + 1;
            System.out.println("ascii: " + ascii);
            
            ascii = ascii * (int)Math.pow(26, multiple);
            System.out.println("ascii: " + ascii);
            
            columnNumber += ascii;
            System.out.println("columnNumber: " + columnNumber);
            
            letterIndex--;
            multiple++;
        }
        
        return columnNumber;
    }
}