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
    
    /**
     * IDEA:
     * - Use recursion to traverse all nodes in the two trees simulataneously. The recursive
     *   function should take in the current TreeNode of each tree (each is incremented in the 
     *   previous recursive call). At the start of each recursive call, check if the two 
     *   TreeNodes that were passed in are the same. If they are, continue with the recursion;
     *   otherwise, return false. If the whole tree is searched without a premature return, 
     *   the trees are the same, return true.
     */
    public bool IsSameTree(TreeNode p, TreeNode q) {
        
        return recursiveIsSameTree(p, q);
    }
    
    private bool recursiveIsSameTree(TreeNode p, TreeNode q) {
        Console.WriteLine("AT: recusriveIsSameTree()");
        
        // BASE CASE 2: End of branch reached, return.
        if (p == null && q == null) { return true; }
        
        Console.WriteLine("Case 1.1 Passed");
        
        if (p == null || q == null) { return false; }
        
        Console.WriteLine("Case 1.2 Passed");
        Console.WriteLine($"p: {p.val}, q: {q.val}");
        
        // BASE CASE 2: Nodes are not equal; therefore, trees are not equal.
        if (p.val != q.val) { return false; }
        
        Console.WriteLine("Case 2 Passed");
        
        return recursiveIsSameTree(p.left, q.left) && recursiveIsSameTree(p.right, q.right);
    }
}