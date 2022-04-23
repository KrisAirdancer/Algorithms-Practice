public class Solution {
    
    /// <summary>
    /// 
    /// IDEA:
    /// Use a stack to store all of the nodes that need to be visited. The nodes should be added to the stack beginning with the
    /// starting node. Loop until no more nodes are added to the stack. If a node that is visited is out of bounds or doesn't
    /// need to have its color changed, don't change its color and don't add its neighbors to the stack.
    /// 
    /// PERFORMANCE:
    /// Time Complexity: O(N*M)
    /// Memory Complexity: O(N*M)
    /// 
    /// REFERENCES: 
    /// Followed this solution as a guide: https://leetcode.com/problems/flood-fill/discuss/1493270/Simple-to-read-C-DFS
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