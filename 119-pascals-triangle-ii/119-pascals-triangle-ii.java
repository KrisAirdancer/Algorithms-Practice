class Solution {
    
    /**
     * IDEA:
     * - Brute Force Solution: Generate pascal's triangle up to the desired row,
     * then return only the last row.
     8 - Optimized Solution: Unsure...
     */
    public List<Integer> getRow(int rowIndex) {
        // Create a new 2D ArrayList, triangleRows, to store the rows of the triangle
        // Loop to generate rows - for loop that runs for the number of rows requested
            // Create a new ArrayList, row, to be filled with the row elements and added to triangleRows
            // Loop to add additional elements to `row` - loop (currentRowNum - 1) times
                // If at beginning or end of row (first or last element), 
                    // Add a 1 to `row`
                // Else,
                    // Calculate the value of the element to be added:
                        // (triangleRows.get(currentRowNum - 1).get(currentEleNum - 1)) + 
                        // (triangleRows.get(currentRowNum - 1).get(currentEleNum))
                    // Add the new element to `rows`
            // Add `row` to `triangleRows`
        // Return triangleRows.get(rowIndex)
        
        List<List<Integer>> triangleRows = new ArrayList<List<Integer>>();
        
        for (int i = 0; i <= rowIndex; i++) {
            ArrayList<Integer> row = new ArrayList<Integer>();
            
            for (int j = 0; j < i + 1; j++) {
                System.out.println("i: " + i + ", j: " + j);
                
                if (j == 0 || j == i) {
                    row.add(j, 1);
                } else {
                    int value = triangleRows.get(i - 1).get(j - 1) + triangleRows.get(i - 1).get(j);
                    row.add(j, value);
                }
            }
            triangleRows.add(i, row);
        }
        return triangleRows.get(rowIndex);
    }
}