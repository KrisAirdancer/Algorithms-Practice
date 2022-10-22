/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left;
 *     public TreeNode right;
 *     public TreeNode(int val=0, TreeNode left=null, TreeNode right=null) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
public class Solution {
    
    /*
     * IDEA:
     * - Use a recursive Depth-First Search to traverse through each of the possible 
     *   root-to-leaf paths. On each recursive call, if both children nodes are null,
     *   add the current path to the return list. Keep track of the current path
     *   by passing the down a list of visited nodes (can build this as a string as
     *   we go). If either of the children nodes aren't null, vist those nodes and
     *   also add that node to the current path list.
     * 
     * PERFORMANCE:
     * - Time Complexity: 
     * - Memory Complexity: 
     * 
     */
    public IList<string> BinaryTreePaths(TreeNode root) {
        
        List<string> pathsList = new List<string>();
        string currentPath = "";
        
        if (root == null) {
            return pathsList;
        } else {
            RecursiveBinaryTreeSearch(pathsList, root, currentPath);
            return pathsList;
        }
    }
    
    private void RecursiveBinaryTreeSearch(IList<string> pathsList, TreeNode current, string currentPath) {
        
        if (current.left == null && current.right == null) {
            pathsList.Add($"{currentPath}{current.val}");
        }
        
        if (current.left != null) {
            RecursiveBinaryTreeSearch(pathsList, current.left, $"{currentPath}{current.val}->");
        }
        
        if (current.right != null) {
            RecursiveBinaryTreeSearch(pathsList, current.right, $"{currentPath}{current.val}->");
        }
    }
}





















