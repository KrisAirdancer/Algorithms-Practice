class Solution {
    
    /**
     * IDEA:
     * - Use the naive solution of creating the first row, and then for each subsequent row,
     * pull the elements from the row above to generate it.
     * 
     * SOURCES:
     * Worked through this solution to get my solution: https://leetcode.com/problems/pascals-triangle/discuss/38125/Solution-in-Java 
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