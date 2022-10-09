public class Solution {
    
    /**
     * IDEA:
     * - The slope between any given points on a straight line will be the same.
     *   Therefore, we simply calculate the slope of the first two point, store
     *   that in a variable, then check the slope between each point on the line
     *   and the first point (or any other point). If the slope of any set of 
     *   points doesn't match the stored slope, return false; otherwise, return
     *   true.
     * - Explanation of math:
     *     - slope = (y2 - y1) / (x2 - x1)
     *     - Since we are trying to determine if the slope between all of
     *       the points are equal, we need to check if slope1 == slope2.
     *     - [ slope 1 == slope2 ] == [ (y2 - y1) / (x2 - x1) == (y3 - y1) / (x3 - x1) ]
     *     - Since we might end up with a zero in the denominator, this solution
     *       will require several checks and additional code to handle zero
     *       in the denominator and vertical lines (those with an undefined slope).
     *     - Using algebra, we can rearrange this equation to swap the division
     *       for multiplication:
     *       (y2 - y1) / (x2 - x1) == (y3 - y1) / (x3 - x1)
     *       // Cross-multiply the denominators
     *       == (y2 - y1) * (x3 - x1) == (y3 - y1) * (x2 - x1)
     * 
     * PERFORMANCE:
     * - Time Complexity: O(N) - We don't need to check all combinations
     *                    of points in the array. Instead, we can just
     *                    calculate the slope of each point in the list
     *                    relative to the first point in the list (or 
     *                    compare each set of two points). Thus, we only
     *                    need to loop over the array once, thus O(N).
     * - Memory Complexity: O(N*M) - We only need to store the input array.
     *                      The input array contains M*N elements, where N 
     *                      the number of arrays in the outter array, and
     *                      M is the number of elements in each of the inner
     *                      arrays. This is only the case b/c the array is
     *                      not a jagged array.
     *
     * SOURCES:
     * - Watched this for an explanation of the math: https://www.youtube.com/watch?v=_tfiTQNZCbs
     */
    public bool CheckStraightLine(int[][] coordinates) {
        
        int x1 = coordinates[0][0];
        int y1 = coordinates[0][1];
        
        int x2 = coordinates[1][0];
        int y2 = coordinates[1][1];
        
        for (int i = 1; i <= coordinates.Length - 2; i++) {
            
            int x3 = coordinates[i + 1][0];
            int y3 = coordinates[i + 1][1];
            
            int a = (y2 - y1) * (x3 - x1);
            int b = (y3 - y1) * (x2 - x1);
            
            if (a != b) { return false; }
        }
        
        return true;
    }
}

















