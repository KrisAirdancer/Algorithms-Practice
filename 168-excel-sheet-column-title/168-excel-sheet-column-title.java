class Solution {
    
    /**
     * IDEA: 
     * - Each character in the column can be represented by values 1-26. ex. 1 = A.
     * Thus if we take the modulus of columnNumber, we can get the number that corresponds
     * to the rightmost character in the column name. However, this would require that we
     * write out a chunk of logic with 26 cases to assign each value to a character. Instead,
     * we can use ASCII values to cast the value to a character, but this will require that
     * we shift the values slightly.
     */
    public String convertToTitle(int columnNumber) {
        
        StringBuilder columnName = new StringBuilder();
        
        while (columnNumber > 0) {
            columnNumber--;
            columnName.append((char)('A' + columnNumber % 26));
            columnNumber = columnNumber / 26;
        }
        
        columnName.reverse();
        return columnName.toString();
    }
}