class Solution {
    
    /**
     * IDEA: 
     * - Each character in the column can be represented by values 1-26. ex. 1 = A.
     * Thus if we take the modulus of columnNumber, we can get the number that corresponds
     * to the rightmost character in the column name. However, this would require that we
     * write out a chunk of logic with 26 cases to assign each value to a character. Instead,
     * we can use ASCII values to cast the value to a character, but this will require that
     * we shift the values slightly to accomodate the fact that ASCII 'A' starts at 65 and 
     * the mod operator will return a 1 that we want to correspond to 'A'. To do this, we
     * reduce the column number by one as an offset then conduct the modulus operation.
     * We can repeat this process until columnNumber == 0;
     * 
     * Performance:
     * - O(N) time complexity - By using StringBuilder to build the columnName and by using .append() and
     * .reverse() to build the string (as opposed to using .insert() alone), the alg only
     * loops over the output string twice for any given input. Thus, O(N).
     * - O(N) space complexity - Because the StringBuilder stores the string as an array of
     * characters, the space complexity will be O(N), where N is comumnNumber / 26. That is,
     * for every multiple of 26 in columnNumber, one additional character will be added
     * to the StringBuilder array.
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