public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Use recursion to visit every node connected to the starting node. At each node, 
    /// check...
    ///     If the node is out of the bounds of the image
    ///     If the node has been visited
    ///     If the node is the color to be changed (only need to change the color of nodes that are the same color as the starting node)
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N*M)
    /// Memory Complexity: 2 * O(N*M)
    /// 
    /// OUTLINE: 
    /// Input check: if the staring node's color is already newColor, return
    /// Create a boolean[][] to track if a node has been visited or not - defaults to false
    /// Call recursive helper method to conduct depth-first search
    /// Return image
    ///
    /// Helper Method:
    /// Check that the current node is in bounds, hasn't been visited, and is the target color
    ///     If not, return
    /// Set visited to true for the current node
    /// Search the top node
    /// Search the left node
    /// Search the bottom node
    /// Search the right node
    /// 
    /// 
    /// REFERENCES: 
    /// Followed this solution to produce my solution: https://leetcode.com/problems/flood-fill/discuss/442143/How-do-you-think-about-solving-a-question-using-DFS-Learn-before-you-Code
    /// 
    /// </summary>
    public int[][] FloodFill(int[][] image, int startRow, int startColumn, int newColor) {
        
        // If the starting "pixel" is already the newColor, we don't want to change any of its neighbors. Return.
        if (image[startRow][startColumn] == newColor) {
            return image;
        }
        
        int targetColor = image[startRow][startColumn];
        
        // Create a stack to store the "pixels" in as we search them
        Stack<(int, int)> changeStack = new Stack<(int, int)>(); // <(int, int)> is storing a tuple in the stack. This tuple stores the location of the pixel
        
        // Add the first "pixel," the starting pixel, to the stack
        changeStack.Push( (startRow, startColumn) );
        
        // Loop until there are no more neighboring pixels to process
        while (changeStack.Count > 0) {
            // Get the current pixel off of the stack
            (int, int) currentPixel = changeStack.Pop();
            int row = currentPixel.Item1;
            int column = currentPixel.Item2;
            
            // Check that current "pixel" is in bounds
            if (row < 0 || row > image.Length - 1 || column < 0 || column > image[0].Length - 1) {
                continue;
            }
            
            // Check that the current "pixel" is of the color to be changed, if not, don't change the color
            if (image[row][column] != targetColor || image[row][column] == newColor) {
                continue;
            }
            
            // Change the color of the current pixel
            image[row][column] = newColor;
            
            // Add all of the neighboring pixels to the stack - even if they don't need to have their color changed or they are out of bounds, these cases will be handled when we process that pixel by the logic above.
            changeStack.Push( (row - 1, column) ); // Search top pixel
            changeStack.Push( (row, column - 1) ); // Search left pixel
            changeStack.Push( (row + 1, column) ); // Search bottom pixel
            changeStack.Push( (row, column + 1) ); // Search right pixel
        }
        return image;
    }
    
}