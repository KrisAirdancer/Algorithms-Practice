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
     * OUTLINE:
     * - If targetSum == 0 && at leaf node, return true
     * - If targetSum == 0 && not at leaf node, return false
     * - If targetSum < 0, return false.
     * - hasPathSum(root.left, targetSum - root.val);
     * - hasPathSum(root.right, targetSum - root.val);
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        
        if (root == null) {
            return false;
        }
            
        if (targetSum - root.val == 0 && (root.left == null && root.right == null)) {
            return true;
        }
        
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}