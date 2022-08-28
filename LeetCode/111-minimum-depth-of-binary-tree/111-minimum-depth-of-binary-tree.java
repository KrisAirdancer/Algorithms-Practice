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
    
    // Note: Depth is one indexed in this problem - the shallowest depth is 1, not zero.
    // If we reach a node that yields a zero and something else, it is not a leaf.
    // If we reach a node that yields two non-zero values, it is not a leaf.
    // If we reach a nod3e that yields two zeros, it is a leaf.
    public int minDepth(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        int minDepthLeft = minDepth(root.left);
        int minDepthRight = minDepth(root.right);
        
        if (Math.min(minDepthLeft, minDepthRight) > 0) {
            return Math.min(minDepthLeft, minDepthRight) + 1;
        } else {
            return Math.max(minDepthLeft, minDepthRight) + 1;
        }
    }
}