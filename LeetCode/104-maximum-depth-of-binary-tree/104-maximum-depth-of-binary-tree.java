/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    /**
    * IDEA:
    * - Use recursion to traverse the entire tree using Depth-First Search.
    * - Each time a node is visited, increase the count by one.
    * - If a null node is reached, return the count.
    * 
    * OUTLINE:
    * - Base Case: if current node is null, return 0
    * - Traverse left node and store the node count
    * - Traverse right node and store the node count
    * - Return the greatest of the two counts
    * 
    * SOURCES:
    * - Worked through this solution: https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/1769344/Java-C%2B%2B-Easy-to-go-Explanation-and-Solution
    */
    public int maxDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int leftCount = maxDepth(root.left);
        int rightCount = maxDepth(root.right);
        
        return Math.max(leftCount, rightCount) + 1;
    }
}