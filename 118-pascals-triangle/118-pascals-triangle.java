class Solution {
    
    /**
     * IDEA:
     * - Use the naive solution of creating the first row, and then for each subsequent row,
     * pull the elements from the row above to generate it.
     * 
     * OUTLINE:
     * - Create an ArrayList<ArrayList<Integer>> to store the rows called triangleRows.
     * - Add the first row to triangleRows
     * - If numRows == 1, return triangleRows
     * - Use a for loop to loop the number of times specified by numRows - this loops through the rows
     *     - Add a 1 as the first element
     *     - Loop to build each row (loop a number of time equivalent to previousRow.length + 1 - 2) - this loops through the elements in each row.
     *         - Calcualte the new element as elementValue = aboveRow[thisElementIndex - 1] + aboveRow[thisElementIndex - 1]
     *         - Add the new element to triangleRows
     *     - Add a 1 as the last element
     * - Return triangleRows
     */ 
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> triangleRows = new ArrayList<List<Integer>>();
        
        for (int i = 0; i < numRows; i++) {
            
            ArrayList<Integer> row = new ArrayList<Integer>();
            
            for (int j = 0; j < i + 1; j++) {
                
                /* If at first element in row or last element in row. Note: The index of the
                 * last element in the row (the element indices are zero-based) corresponds
                 * exactly to the zero-based row number index.
                 */
                if (j == 0 || j == i) {
                    // Always add a one to the beginning and end of each row.
                    row.add(j, 1);
                } else {
                    // Get the two elements in the row above, add them, and insert the result into the new row.
                    row.add(j, triangleRows.get(i - 1).get(j - 1) + triangleRows.get(i - 1).get(j));
                }
            }
            triangleRows.add(row);
        }
        
        return triangleRows;
    }
}