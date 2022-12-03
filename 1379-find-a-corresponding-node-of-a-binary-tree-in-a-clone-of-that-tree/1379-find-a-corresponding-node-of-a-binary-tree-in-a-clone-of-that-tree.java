/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution
{
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target)
    {
        // System.out.println(original.val);
        // DFS to traverse both trees at the same time
        return doubleDFS(original, cloned, target);
        // BFSTraversal(original);
        
        // return null;
    }
    
    private TreeNode doubleDFS(TreeNode original, TreeNode cloned, TreeNode target)
    {
        TreeNode result = null;
        
        if (original == null) { return null; }
        if (original.val == target.val) {
            System.out.println("Target found: " + original.val);
            return cloned;
        }
        
        // Pre-Order Traversal
        System.out.println(original.val);
        
        // Go left
        result = doubleDFS(original.left, cloned.left, target);
        System.out.println("result: " + result);
        if (result != null && result.val == target.val) { System.out.println("Returning. Result: " + result); return result; }
        
        // Go right
        result = doubleDFS(original.right, cloned.right, target);
        
        return result;
    }
    
    // For now, just traverse the entire tree using DFS
    private void BFSTraversal(TreeNode root)
    {        
        // BASE CASE: Current node is null
        if (root == null) { return; }
        
        // Pre-Order Traversal
        System.out.println(root.val);
        
        // Go left
        BFSTraversal(root.left);
        
        // Go right
        BFSTraversal(root.right);
    }
}