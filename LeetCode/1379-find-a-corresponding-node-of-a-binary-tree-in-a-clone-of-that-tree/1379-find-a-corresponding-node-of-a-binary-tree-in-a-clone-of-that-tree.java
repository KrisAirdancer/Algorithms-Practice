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
        return doubleDFS(original, cloned, target);
    }
    
    private TreeNode doubleDFS(TreeNode original, TreeNode cloned, TreeNode target)
    {
        TreeNode result = null;
        
        if (original == null) { return null; }
        if (original == target) { return cloned; }
        
        // Go left
        result = doubleDFS(original.left, cloned.left, target);

        if (result != null && result.val == target.val) { return result; }
        
        // Go right
        result = doubleDFS(original.right, cloned.right, target);
        
        return result;
    }
    
    // A practice DFS implementation
    // Not used in my solution to this problem
    private void DFSTraversal(TreeNode root)
    {        
        // BASE CASE: Current node is null
        if (root == null) { return; }
        
        // Pre-Order Traversal
        System.out.println(root.val);
        
        // Go left
        DFSTraversal(root.left);
        
        // Go right
        DFSTraversal(root.right);
    }
}